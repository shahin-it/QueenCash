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
        var unitPrice = productSelection.find(".unit-price");
        var priceTotal = productSelection.find(".total-price");
        productSelection.find("select.product").change(function (evt) {
            var option = $(this).find(":selected");
            var item = option.data();
            quantity.val(1);
            unitPrice.val(item.basePrice);
            priceTotal.val(item.basePrice * 1);
        }).trigger("change");
        quantity.add(unitPrice).change(function () {
            priceTotal.val(unitPrice.val() * quantity.val());
        })

        productSelection.find(".add-to-cart").click(function () {
            var select = productSelection.find("select.product")
            var option = select.find(":selected");
            var data = option.data();
            var row = panel.find(".item-template").clone().show().removeClass("item-template");
            row.find("input").prop("disabled", false);

            row.find(".id .value").text(select.val());
            row.find(".id input").val(select.val());

            row.find(".item .value").text(option.text());
            row.find(".item input").val(option.text());

            row.find(".unit-price input").val(unitPrice.val());
            row.find(".quantity input").val(quantity.val());


            row.find(".total-price .value").text(priceTotal.val());
            row.find(".total-price .cost-price").val(data.costPrice);
            row.find(".total-price .total").val(priceTotal.val());

            panel.find(".cart-table tbody").append(row);
        });

        panel.on("change", ".order-item .unit-price input, .order-item .quantity input", function () {
            var row = $(this).parents(".order-item");
            var priceBlock = row.find(".total-price");
            var price = row.find(".unit-price input").val() * row.find(".quantity input").val();
            priceBlock.find(".value").text(price);
            priceBlock.find(".total").val(price);
        })

        panel.on("click", ".action-navigator .remove", function () {
            $(this).parents(".order-item").remove();
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