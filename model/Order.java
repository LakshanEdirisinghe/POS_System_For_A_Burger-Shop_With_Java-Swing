package model;

public class Order {

    private String orderId;
    private String custId;
    private OrderStatus orderStatus;

    public Order(String orderId, String custId, OrderStatus orderStatus) {
        this.orderId = orderId;
        this.custId = custId;
        this.orderStatus = orderStatus;
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

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setCustId(String custId) {
        this.custId = custId;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }


}