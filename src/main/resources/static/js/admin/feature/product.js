var _product = {};
app.tab.product = function() {
    this.loading_url = app.base + "productAdmin";
    this.id = "product-tab";
    this.createEditUrl = app.base + "productAdmin/edit";
    this.removeUrl = app.base + "productAdmin/delete";
    this.processor = _product;
    return this;
};

(function () {
    _product.init = function() {
        var _self = this;
    }
})()