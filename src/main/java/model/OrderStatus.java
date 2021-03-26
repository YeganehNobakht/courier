package model;

import javax.persistence.*;
import java.sql.Date;
@Entity
public class OrderStatus {
    @Id
    private int orderId;
    @Column(nullable = false)
    private Date registerDate;
    @Column(nullable = true)
    private Date acceptDate;
    @Column(nullable = true)
    private Date sendingDate;
    @Column(nullable = true)
    private Date deliverDate;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStates orderStates;
    @Column(nullable = false)
    private int employeeId;

    public OrderStatus(int orderId, Date registerDate, Date acceptDate, Date sendingDate, Date deliverDate, OrderStates orderStates, int employeeId) {
        this.orderId = orderId;
        this.registerDate = registerDate;
        this.acceptDate = acceptDate;
        this.sendingDate = sendingDate;
        this.deliverDate = deliverDate;
        this.orderStates = orderStates;
        this.employeeId = employeeId;
    }

    public OrderStatus() {
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(Date registerDate) {
        this.registerDate = registerDate;
    }

    public Date getAcceptDate() {
        return acceptDate;
    }

    public void setAcceptDate(Date acceptDate) {
        this.acceptDate = acceptDate;
    }

    public Date getSendingDate() {
        return sendingDate;
    }

    public void setSendingDate(Date sendingDate) {
        this.sendingDate = sendingDate;
    }

    public Date getDeliverDate() {
        return deliverDate;
    }

    public void setDeliverDate(Date deliverDate) {
        this.deliverDate = deliverDate;
    }

    public OrderStates getOrderStates() {
        return orderStates;
    }

    public void setOrderStates(OrderStates orderStates) {
        this.orderStates = orderStates;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
}
