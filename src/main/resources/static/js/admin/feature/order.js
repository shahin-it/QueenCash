/**
 * Created by shahin on 05-Aug-16.
 */
$(function() {
    var order_list_tab = {};
    app.tab.order_list_tab = function() {
        this.loading_url = app.ajaxBase("orderList", "list");
        this.id = "order-tab";
        this.processor = order_list_tab;
        return this;
    }

    var _c = order_list_tab;

    _c.init = function() {
        var _self = this;
        _self.body.find(".tool-item .add-new").click(function() {
            _self.editOrder();
        })
        _self.body.find(".navigator .edit").click(function() {
            var data = this.jq.parent().data() || {};
            _c.editOrder(data);
        });
        _self.body.find(".navigator .payment-list").click(function() {
            location.href = this.jq.attr("data-href")
        });
        _self.body.find(".navigator .cancel").click(function() {
            var data = this.jq.parent().data() || {};
            _c.cancelOrder(data.id);
        });
    }

    _c.editOrder = function(data) {
        var _self = this;
        data = $.extend({
            id: null,
            name: null
        }, data);
        var title = data.id ? "Edit Order" : "New order"
        var popup = sui.editPopup(app.ajaxBase("orderAdmin", "edit-order"), title, data, {
            success: function() {
                _self.reload();
            }
        });
    }

    _c.cancelOrder = function(id) {
        var _self = this;
        sui.confirmDelete(app.ajaxBase("orderAdmin", "cancel-order"), "Are you sure?", {id: id}, function() {
            _self.reload();
        });
    }
});