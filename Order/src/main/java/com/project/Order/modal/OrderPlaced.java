package com.project.Order.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;
import java.util.List;

@Entity
public class OrderPlaced {
    @Id
    @GeneratedValue
    private Long orderPlacedId;
    private Long userId;
    private float total;

    @Transient
    List<OrderMapping> orderTraceList;

 //***************************************************************************************************************

    public Long getOrderPlacedId() {
        return orderPlacedId;
    }

    public void setOrderPlacedId(Long orderPlacedId) {
        this.orderPlacedId = orderPlacedId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public List<OrderMapping> getOrderTraceList() {
        return orderTraceList;
    }

    public void setOrderTraceList(List<OrderMapping> orderTraceList) {
        this.orderTraceList = orderTraceList;
    }


    //******************************************************************************************************************


    public OrderPlaced(Long orderPlacedId, Long userId, float total) {
        this.orderPlacedId = orderPlacedId;
        this.userId = userId;
        this.total = total;
    }

    public OrderPlaced() {
    }


    //********************************************************************************************************


    @Override
    public String toString() {
        return "OrderPlaced{" +
                "orderPlacedId=" + orderPlacedId +
                ", userId=" + userId +
                ", total=" + total +
                '}';
    }
}
