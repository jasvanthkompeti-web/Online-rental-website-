package com.rental.model;

import jakarta.persistence.*;

@Entity
@Table(name="products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String brand;
    private String category;
    @Column(length=1000)
    private String description;
    private double pricePerDay;
    private double securityDeposit;
    private String imageUrl;
    private boolean available = true;

    public Product() {}
    public Product(String name, String brand, String category, String description,
                    double pricePerDay, double securityDeposit, String imageUrl) {
        this.name=name; this.brand=brand; this.category=category;
        this.description=description; this.pricePerDay=pricePerDay;
        this.securityDeposit=securityDeposit; this.imageUrl=imageUrl;
    }
    public Long getId(){return id;}
    public String getName(){return name;}
    public void setName(String v){name=v;}
    public String getBrand(){return brand;}
    public void setBrand(String v){brand=v;}
    public String getCategory(){return category;}
    public void setCategory(String v){category=v;}
    public String getDescription(){return description;}
    public void setDescription(String v){description=v;}
    public double getPricePerDay(){return pricePerDay;}
    public void setPricePerDay(double v){pricePerDay=v;}
    public double getSecurityDeposit(){return securityDeposit;}
    public void setSecurityDeposit(double v){securityDeposit=v;}
    public String getImageUrl(){return imageUrl;}
    public void setImageUrl(String v){imageUrl=v;}
    public boolean isAvailable(){return available;}
    public void setAvailable(boolean v){available=v;}
}
