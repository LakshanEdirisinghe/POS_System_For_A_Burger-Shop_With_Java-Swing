package Controller;

import model.Order;
import util.OrderStatus;

public class UpdateDetailsController {

    public enum UpdateResult {
        SUCCESS,
        NO_ORDER_SELECTED,
        ORDER_NOT_PREPARING,
        INVALID_QUANTITY,
        CUSTOMER_NOT_FOUND,
        UPDATE_FAILED
    }

    public Order search(String orderId) {
        return OrderManager.findOrder(orderId);
    }

    public String findCustomerName(String customerId) {
        return CustomerManager.findEqualName(customerId);
    }

    public UpdateResult update(Order order, String customerId, String quantityText, String statusText) {
        if (order == null) {
            return UpdateResult.NO_ORDER_SELECTED;
        }

        if (order.getOrderStatus() != OrderStatus.PREPARING) {
            return UpdateResult.ORDER_NOT_PREPARING;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText.trim());
        } catch (NumberFormatException ex) {
            return UpdateResult.INVALID_QUANTITY;
        }

        if (quantity <= 0) {
            return UpdateResult.INVALID_QUANTITY;
        }

        OrderStatus status = OrderStatus.valueOf(statusText);
        if (CustomerManager.findCustomerById(customerId.trim()) == null) {
            return UpdateResult.CUSTOMER_NOT_FOUND;
        }

        return OrderManager.updateOrder(order.getOrderId(), customerId, quantity, status)
                ? UpdateResult.SUCCESS
                : UpdateResult.UPDATE_FAILED;
    }
}