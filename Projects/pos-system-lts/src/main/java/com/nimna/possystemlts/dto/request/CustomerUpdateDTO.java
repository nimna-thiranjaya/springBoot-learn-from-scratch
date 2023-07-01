package com.nimna.possystemlts.dto.request;

import java.util.ArrayList;

public class CustomerUpdateDTO {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private Double customerSalary;

    public CustomerUpdateDTO() {
    }

    public CustomerUpdateDTO(int customerID, String customerName, String customerAddress, Double customerSalary) {
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerAddress = customerAddress;
        this.customerSalary = customerSalary;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Double getCustomerSalary() {
        return customerSalary;
    }

    public void setCustomerSalary(Double customerSalary) {
        this.customerSalary = customerSalary;
    }

    @Override
    public String toString() {
        return "CustomerUpdateDTO{" +
                "customerID=" + customerID +
                ", customerName='" + customerName + '\'' +
                ", customerAddress='" + customerAddress + '\'' +
                ", customerSalary=" + customerSalary +
                '}';
    }
}
