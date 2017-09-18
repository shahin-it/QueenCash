/**
 * Created by shahin on 14-Aug-16.
 */
$(function() {
    var content = $("#content-render")
    $.each(app.tab, function(k, v) {
        var tab = {};
        var base = v.apply(tab);
        tab = $.extend(base.processor, tab);
        tab.body = content.find(".sui-single-tab#"+tab.id);
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
        tab.reload = table.reload;
        tab.beforeLoad = table.beforeLoad;
        tab.afterLoad = table.afterLoad;
        tab.init();
    })
})