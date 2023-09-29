package com.cox.oss.billingService.interfaces.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Billing_Table")
public class Billing implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private Long number;
    @Column
    private String billingPeriod;
    @Column
    @NotNull
    private String customerName;
    @Column
    @NotNull
    private Double total;
    @Column
    @NotNull
    private Date dueDate;

    public Billing() {
    }

    public Billing(Long number, String billingPeriod, String customerName, Double total, Date dueDate) {
        this.number = number;
        this.billingPeriod = billingPeriod;
        this.customerName = customerName;
        this.total = total;
        this.dueDate = dueDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getBillingPeriod() {
        return billingPeriod;
    }

    public void setBillingPeriod(String billingPeriod) {
        this.billingPeriod = billingPeriod;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
