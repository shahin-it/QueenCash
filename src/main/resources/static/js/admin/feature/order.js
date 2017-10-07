var _order = {};
app.tab.order = function() {
    this.loading_url = app.base + "orderAdmin";
    this.id = "order-tab";
    this.createEditUrl = app.base + "orderAdmin/edit";
    this.removeUrl = app.base + "orderAdmin/delete";
    this.processor = _order;
    return this;
};

(function () {
    _order.init = function() {
        var _self = this;
    }
})()