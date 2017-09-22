/**
 * Created by shahin on 05-Aug-16.
 */
var _brand = {};
app.tab.brand = function() {
    this.loading_url = app.base + "brandAdmin";
    this.id = "brand-tab";
    this.createEditUrl = app.base + "brandAdmin/edit";
    this.removeUrl = app.base + "brandAdmin/delete";
    this.processor = _brand;
    return this;
};

(function () {
    _brand.init = function() {
        var _self = this;
    }
})()




// category tab
var _category = {};
app.tab.category = function() {
    this.loading_url = app.base + "categoryAdmin";
    this.id = "category-tab";
    this.createEditUrl = app.base + "categoryAdmin/edit";
    this.removeUrl = app.base + "categoryAdmin/delete";
    this.processor = _category;
    return this;
};

(function () {
    _category.init = function() {
        var _self = this;
    }
})()