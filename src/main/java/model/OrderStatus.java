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
    @Column(nullable = false)
    private int employeeId;

    public OrderStatus() {
    }

    public OrderStatus(int orderId, String registerDate, OrderStates orderStates) {
        this.orderId = orderId;
        this.registerDate = registerDate;
        this.orderStates = orderStates;
    }

    public OrderStatus(int orderId, String registerDate, OrderStates orderStates, String acceptDate, String sendingDate, String deliverDate, int employeeId) {
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

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
