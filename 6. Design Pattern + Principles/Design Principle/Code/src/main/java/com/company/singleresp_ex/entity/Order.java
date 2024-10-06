package com.company.singleresp_ex.entity;

import com.company.singleresp_ex.domain.OrderStatus;

public class Order {

    private Long orderId;

    private Long placedOn;

    private Long createdOn;

    private Long deliveredOn;
    
    private Long canceledOn;

    private Long lastUpdatedOn;

    private double value;

    private OrderStatus status;

    public Order() {

    }
    
    public Order(Long orderId, double value) {
        this.orderId = orderId;
        this.value = value;
    }

    /**
     * @return the orderId
     */
    public Long getOrderId() {
        return orderId;
    }

    /**
     * @param orderId the orderId to set
     */
    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    /**
     * @return the placedOn
     */
    public Long getPlacedOn() {
        return placedOn;
    }

    /**
     * @param placedOn the placedOn to set
     */
    public void setPlacedOn(Long placedOn) {
        this.placedOn = placedOn;
    }

    /**
     * @return the createdOn
     */
    public Long getCreatedOn() {
        return createdOn;
    }

    /**
     * @param createdOn the createdOn to set
     */
    public void setCreatedOn(Long createdOn) {
        this.createdOn = createdOn;
    }

    /**
     * @return the deliveredOn
     */
    public Long getDeliveredOn() {
        return deliveredOn;
    }

    /**
     * @param deliveredOn the deliveredOn to set
     */
    public void setDeliveredOn(Long deliveredOn) {
        this.deliveredOn = deliveredOn;
    }

    /**
     * @return the canceledOn
     */
    public Long getCanceledOn() {
        return canceledOn;
    }

    /**
     * @param canceledOn the canceledOn to set
     */
    public void setCanceledOn(Long canceledOn) {
        this.canceledOn = canceledOn;
    }

    /**
     * @return the lastUpdatedOn
     */
    public Long getLastUpdatedOn() {
        return lastUpdatedOn;
    }

    /**
     * @param lastUpdatedOn the lastUpdatedOn to set
     */
    public void setLastUpdatedOn(Long lastUpdatedOn) {
        this.lastUpdatedOn = lastUpdatedOn;
    }

    /**
     * @return the value
     */
    public double getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    
}