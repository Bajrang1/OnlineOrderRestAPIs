package com.project.Order.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class OrderMapping {
    @Id
    @GeneratedValue
    private Long orderMappingId;
    private Long orderPlacedId;
    private Long itemId=2l;

    private int quantity;


    //******************************************************************************************************



    public OrderMapping(Long orderMappingId, Long orderPlacedId, Long itemId, Long userId, int quantity) {
        this.orderMappingId = orderMappingId;
        this.orderPlacedId = orderPlacedId;
        this.itemId = itemId;

        this.quantity = quantity;
    }

    public OrderMapping() {
    }


    //*********************************************************************************************************\


    public Long getOrderMappingId() {
        return orderMappingId;
    }

    public void setOrderMappingId(Long orderMappingId) {
        this.orderMappingId = orderMappingId;
    }

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }


    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Long getOrderPlacedId() {
        return orderPlacedId;
    }

    public void setOrderPlacedId(Long orderPlacedId) {
        this.orderPlacedId = orderPlacedId;
    }
//****************************************************************************************************


    @Override
    public String toString() {
        return "OrderMapping{" +
                "orderMappingId=" + orderMappingId +
                ", orderPlacedId=" + orderPlacedId +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
