/**
 * Created by shahin on 05-Aug-16.
 */
var sui = {
    ajax: function(settings) {
        if(!settings) {
            return;
        }
        var response = settings.response, success = settings.success, error = settings.error;
        delete settings.response;
        delete settings.success;
        delete settings.error;
        settings = $.extend({
            dataType: "json",
            success: function() {
                response && response.call(this);
                success && success.apply(this, arguments);
            },
            error: function() {
                response && response.call(this);
                error && error.apply(this, arguments);
            }
        }, settings);
        return $.ajax(settings);
    },
    singleTab: function(container, data, config) {
        if(!container.is(".sui-single-tab")) {
            return;
        }
        data = $.extend({
            offset: 0,
            max: 10,
            searchText: ""
        }, data);

        config = $.extend({
            url: "#",
            beforeLoad: function() {},
            afterLoad: function() {}
        }, config);
        container.on("click", ".tab-reload", function() {
            container.reload();
        });
        container.on("click", ".tab-search", function() {
            container.reload({searchText: this.jq.prev("input.search-text").val()});
        });

        container.reload = function(reloadData) {
            var before = config.beforeLoad.apply(this, [data]);
            if(before == false) {
                return;
            }
            var reqData = $.extend(data, reloadData);
            container.loader();
            sui.ajax({
                url: config.url,
                data: data,
                dataType: "html",
                complete: function(resp) {
                    container.loader(false);
                },
                success: function(resp) {
                    resp = resp.jq;
                    if(resp.length) {
                        container.html(resp.html());
                        container.updateUi();
                        container.find(".tab-search").prev("input.search-text").val(reqData.searchText);
                        config.afterLoad.apply(this, arguments);
                    }
                }
            });
        };
        return $.extend(config, {
            reload: function() {
                container.reload();
            }
        });
    },
    highlight: function (item, time, blink) {
        item.addClass("highlight-row" + (blink ? " blink" : ""));
        setTimeout(function () {
            item.removeClass("highlight-row" + (blink ? " blink" : ""));
        }, time ? time : 3000);
    },
    errorHighLight: function(item, time) {
        item.addClass("error-highlight");
        setTimeout(function () {
            item.removeClass("error-highlight");
        }, time ? time : 1000);
    },
    alert: function($message, $type) {
        alert($message);
    },
    editPopup: function(url, title, data, config) {
        var content
        config = $.extend({
            class: "",
            title: "",
            width: 600,
            preSubmit: null
        }, config);
        data = $.extend({
            id: null
        }, data);
        if(typeof url != "string") {
            content = url;
        }
        var popup = $('<div class="sui-edit-popup '+config.class+'"><div class="popup-body"></div></div>');
        $("body").append(popup);
        popup = popup.dialog({
            title: title ? title : config.title,
            width: config.width,
            modal: true,
            open: function(evt, ui) {
                var body = popup.find(".popup-body");
                if(content && content.length) {
                    popupLoaded(content);
                } else {
                    body.loader();
                    sui.ajax({
                        url: url,
                        data: data,
                        dataType: "html",
                        complete: function() {
                            body.loader(false);
                        },
                        success: function(resp) {
                            popupLoaded(resp.jq);
                        }
                    });
                }

                function popupLoaded(content) {
                    body.html(content);
                    content.updateUi();
                    popup.dialog("option", "position", popup.dialog( "option", "position" ));
                    var form = popup.find("form:first");
                    form.ajaxForm({
                        type: "POST",
                        dataType: "json",
                        beforeSubmit: function(arr, $form, options) {
                            form.loader();
                            if(config.preSubmit) {
                                return config.preSubmit.apply(this, arguments);
                            }
                        },
                        success: function(resp, type) {
                            form.loader(false);
                            if(config.response) {
                                config.response.apply(this);
                            }
                            if(resp && resp.message) {
                                sui.alert(resp.message);
                            }
                            if(config.success) {
                                config.success.apply(this, arguments);
                            }
                            popup.dialog("close");
                        },
                        error: function() {
                            form.loader(false);
                            if(config.response) {
                                config.response.apply(this);
                            }
                        }
                    });
                    form.find(".btn-cancel").click(function() {
                        popup.dialog("close");
                    })
                    config.loaded && config.loaded.apply(popup, body);
                }
            },
            close: function(evt, ui) {
                config.close && config.close.apply(this, arguments);
                popup.remove();
            }
        });
        return popup;
    },
    confirm: function(message, yes, no) {
        var confirm = window.confirm(message);
        if(confirm) {
            yes && yes();
        } else {
            no && no();
        }
    },
    confirmDelete: function(url, title, data, success) {
        this.confirm(title, function() {
            "body".jq.loader();
            sui.ajax({
                url: url,
                dataType: "json",
                data: data,
                response: function() {
                    "body".jq.loader(false);
                },
                success: function(resp) {
                    if(resp && resp.message) {
                        sui.alert(resp.message);
                    }
                    if(success) {
                        success.apply(this, arguments);
                    }
                }
            })
        });
    },
    notify: function(message, type) {
        var icon = {error: "fa-times", success: "fa-check", alert: "fa-exclamation-triangle"}
        var dom = $('<div class="notification-popup shake-out '+type+'"><div class="title-bar"><i class="fa fa-times-circle-o close-popup"></i></div>' +
            '<div class="body"><i class="fa icon '+icon[type]+'"></i> <span class="message"><p>'+message+'</p></span></div></div>');
        $("body").append(dom);
        dom.find(".close-popup").on("click", function() {
            dom.remove();
        })
        setTimeout(function() {
            dom.remove();
        }, 10000);
    },
    accordion: function(panel) {
        if(!panel.is(".sui-accordion-panel")) {
            return
        }
        panel.expand = function(label) {
            panel.find(".sui-accordion-label").removeClass("expanded");
            panel.find(".sui-accordion-item").removeClass("expanded").hide();
            label.addClass("expanded");
            label.next(".sui-accordion-item").addClass("expanded").show();
        }
        panel.expand(panel.find(".sui-accordion-label:first"));
        panel.on("click", ".sui-accordion-label", function() {
            panel.expand(this.jq);
        })
        return panel;
    }

}