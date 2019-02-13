package com.project.Order.modal;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name ="users")

public class User {
    @Id
    @GeneratedValue
    private Long userId;
    private String name;
    private String address;
    private Long mob;

  private String customerType;
    //***************************************************** constructor ****************************************


    public User(Long userId, String name, String address, Long mob, String customerType) {
        this.userId = userId;
        this.name = name;
        this.address = address;
        this.mob = mob;
        this.customerType = customerType;
    }

    public User() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getMob() {
        return mob;
    }

    public void setMob(Long mob) {
        this.mob = mob;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", mob=" + mob +
                ", customerType='" + customerType + '\'' +
                '}';
    }
}

