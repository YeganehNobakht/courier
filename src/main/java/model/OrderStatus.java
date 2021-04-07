package model;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class OrderStatus {
    @Id
    private int orderId;
    @Column(nullable = false)
    private String registerDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStates orderStates;
    @Column(nullable = true)
    private String acceptDate;
    @Column(nullable = true)
    private String sendingDate;
    @Column(nullable = true)
    private String deliverDate;
    @Column(nullable = false, unique = true)
    private String employeeId;
    @Column(nullable = false)
    private String customerUsername;


    public OrderStatus() {
    }

    public OrderStatus(int orderId, OrderStates orderStates, String acceptDate, String sendingDate, String deliverDate, String employeeId) {
        this.orderId = orderId;
        this.orderStates = orderStates;
        this.acceptDate = acceptDate;
        this.sendingDate = sendingDate;
        this.deliverDate = deliverDate;
        this.employeeId = employeeId;
    }

    public OrderStatus(int orderId, String registerDate, OrderStates orderStates, String customerUsername) {
        this.orderId = orderId;
        this.registerDate = registerDate;
        this.orderStates = orderStates;
        this.customerUsername = customerUsername;
    }

    public OrderStatus(int orderId, String registerDate, OrderStates orderStates, String acceptDate, String sendingDate, String deliverDate, String employeeId) {
        this.orderId = orderId;
        this.registerDate = registerDate;
        this.orderStates = orderStates;
        this.acceptDate = acceptDate;
        this.sendingDate = sendingDate;
        this.deliverDate = deliverDate;
        this.employeeId = employeeId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }

    public OrderStates getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(OrderStates orderStates) {
        this.orderStates = orderStates;
    }

    public String getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(String acceptDate) {
        this.acceptDate = acceptDate;
    }

    public String getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(String sendingDate) {
        this.sendingDate = sendingDate;
    }

    public String getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(String deliverDate) {
        this.deliverDate = deliverDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getCustomerUsername() {
        return customerUsername;
    }

    public void setCustomerUsername(String customerUsername) {
        this.customerUsername = customerUsername;
    }
}