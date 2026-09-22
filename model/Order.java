package model;

import util.OrderStatus;

public class Order {

    private String orderId;
    private String custId;
    private int quantity;
    private OrderStatus orderStatus;

    public Order(String orderId, String custId, OrderStatus orderStatus, int quantity) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderStatus = orderStatus;
        this.quantity = quantity;
    }


    public String getOrderId() {
        return orderId;
    }

    public String getCustId() {
        return custId;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


}