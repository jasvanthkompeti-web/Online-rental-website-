package com.rental.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="rentals")
public class Rental {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productId;
    private String customerName;
    private String customerEmail;
    private LocalDate startDate;
    private LocalDate endDate;
    private int days;
    private double totalPrice;
    private String status = "BOOKED";

    public Rental() {}
    public Long getId(){return id;}
    public Long getProductId(){return productId;}
    public void setProductId(Long v){productId=v;}
    public String getCustomerName(){return customerName;}
    public void setCustomerName(String v){customerName=v;}
    public String getCustomerEmail(){return customerEmail;}
    public void setCustomerEmail(String v){customerEmail=v;}
    public LocalDate getStartDate(){return startDate;}
    public void setStartDate(LocalDate v){startDate=v;}
    public LocalDate getEndDate(){return endDate;}
    public void setEndDate(LocalDate v){endDate=v;}
    public int getDays(){return days;}
    public void setDays(int v){days=v;}
    public double getTotalPrice(){return totalPrice;}
    public void setTotalPrice(double v){totalPrice=v;}
    public String getStatus(){return status;}
    public void setStatus(String v){status=v;}
}
