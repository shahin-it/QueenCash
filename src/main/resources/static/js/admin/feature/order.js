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
    _order.onCreateEditLoad = function (panel) {
        var _self = this;
        var productSelection = panel.find(".product-selection");
        var quantity = productSelection.find(".quantity");
        var price = productSelection.find(".unit-price");
        var priceTotal = productSelection.find(".total-price");
        productSelection.find("select.product").change(function (evt) {
            var option = $(this).find(":selected");
            var item = option.data();
            quantity.val(1);
            price.val(item.basePrice);
            priceTotal.val(item.basePrice * 1);
        }).trigger("change");
        quantity.add(price).change(function () {
            priceTotal.val(price.val() * quantity.val());
        })
    }

    _order.prepareOrderItem = function (panel, orderItem) {
        var _self = this;
        var tr = panel.find(".item-template").clone();
        tr.find(".id").text(orderItem.productId);
        tr.find(".unit-price input").val(orderItem.unitPrice);
        tr.find(".quantity input").val(orderItem.quantity);
        tr.find(".total-price").text(orderItem.totalPrice);
        return tr;
    }

})()