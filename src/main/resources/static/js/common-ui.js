/**
 * Created by shahin on 05-Aug-16.
 */
Object.defineProperty(String.prototype, "jq", {
    get: function () {
        return jQuery("" + this)
    }
});

Object.defineProperty(Element.prototype, "jq", {
    get: function () {
        return jQuery(this)
    }
});

$.extend($.prototype, {
    loader: function(show) {
        if(show === false) {
            this.mask(false);
        } else {
            var l = this.mask().addClass("loader");
            if(this.is("body")) {
                l.css({position: "fixed"})
            }
        }
        return this;
    },
    mask: function(show) {
        if(show === false) {
            this.find(".overlay").remove();
        } else {
            this.append('<div class="overlay">\n' +
                '                <div class="m-loader mr-20">\n' +
                '                  <svg class="m-circular" viewBox="25 25 50 50">\n' +
                '                  \t<circle class="path" cx="50" cy="50" r="20" fill="none" stroke-width="4" stroke-miterlimit="10"></circle>\n' +
                '                  </svg>\n' +
                '                </div>\n' +
                '                <h3 class="l-text">Loading</h3>\n' +
                '              </div>');
        }
        return this.find(".overlay");
    },
    serializeObject: function () {
        var o = {};
        var a = (this.is("form") ? this : this.find(":input")).serializeArray();
        $.each(a, function () {
            if (o[this.name] !== undefined) {
                if (!$.isArray(o[this.name])) {
                    o[this.name] = [o[this.name]];
                }
                o[this.name].push(this.value || '');
            } else {
                o[this.name] = this.value || '';
            }
        });
        return o;
    },
    updateUi: function() {
        this.find(".sui-file-chooser").on("change", "input[type=file]:last", function() {
            if(this.value) {
                if((this.files[0].size/1024) > (+this.jq.attr("max-size"))) {
                    sui.notify("Max size 2 MB");
                    this.jq.replaceWith(this.jq.val('').clone(true));
                    return false;
                }
                if(!this.jq.is(".single")) {
                    var input = $('<div class="input"><input type="file" name="s_image[]" value="" max-size="2048"><i class="action remove fa fa-times color-red" title="Remove"></i></div>');
                    this.jq.parents(".input").after(input);
                    input.find(".remove").click(function() {
                        this.jq.parents(".input").remove();
                    })
                }
            }
        });
        this.find(".sui-accordion-panel").each(function() {
            sui.accordion(this.jq);
        })
    },
    updateSiteUi: function() {
        var _self = this;
        _self.find(".owl-carousel.image-slider, .owl-carousel.product-slider").each(function () {
            var owl = this.jq;
            owl.owlCarousel({
                navigation : true, // Show next and prev buttons
                nav: true,
                singleItem:true,
                // loop: true,
                margin: 10,
                responsiveClass: true,
            })
        })

        _self.find(".thumb-image-wrapper img").click(function() {
            var data = this.jq.parents(".thumb-image-wrapper").data("size").split(":")
            this.jq.parents(".product-details").find(".product-image img").attr("src", this.jq.attr("src").replace(data[0], data[1]));
        })

        _self.find(".sui-accordion-panel").on("click", ".item-label", function () {
            var item = this.jq.next(".item-body");
            if(!item.length) {
                item = this.jq.parent().next(".item-body");
            }
            item.stop().slideToggle();
        })
    }
});

var _to_fixed = Number.prototype.toFixed;
$.extend(Number.prototype, {
    /**
     * removes trailing 0s from fixed values if true is passed as trimmed
     */
    toFixed: function (count, trimmed) {
        var fixed = _to_fixed.call(this, count);
        if (trimmed) {
            return fixed.replace(/\.?0+$/, '');
        }
        return fixed;
    }
});