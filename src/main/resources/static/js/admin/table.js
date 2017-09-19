/**
 * Created by shahin on 14-Aug-16.
 */
$(function() {
    var content = $(".sui-tabular-content")
    $.each(app.tab, function(k, v) {
        var tab = {createEditUrl: "", removeUrl: ""};
        var base = v.apply(tab);
        tab = $.extend(base.processor, tab);
        tab.body = content.filter("#"+tab.id);
        if(!tab.body.length) {
            return;
        }
        tab.body.updateUi();
        var table = sui.singleTab(tab.body, {}, {
            url: tab.loading_url,
            afterLoad: function() {
                tab.body.updateUi();
                tab.init();
            }
        });
        var _init = tab.init;
        tab.init = function () {
            var _self = this;
            _self.body.find(".add-new-button, .action-navigator .edit").click(function() {
                var data = this.jq.parent().data() || {};
                var popup = sui.renderCreateEdit(tab.createEditUrl, data, {
                    target: _self.body,
                    success: function() {
                        _self.reload();
                    }
                });
            });
            _self.body.find(".navigator .remove").click(function() {
                var data = this.jq.parent().data() || {};
                sui.confirmDelete(tab.removeUrl, "Are you sure?", data, function() {
                    _self.reload();
                });
            });
            _init && _init();
        }
        tab.reload = table.reload;
        tab.beforeLoad = table.beforeLoad;
        tab.afterLoad = table.afterLoad;


        tab.init();
    })
})