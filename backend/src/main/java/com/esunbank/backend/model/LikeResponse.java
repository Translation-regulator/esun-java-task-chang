package com.esunbank.backend.model;

public class LikeResponse {
    private int sn;
    private String productName;
    private double price;
    private double feeRate;
    private int orderQuantity;
    private double totalAmount;
    private double totalFee;
    private String account;
    private String email;

    // Getters and Setters
    public int getSn() { return sn; }
    public void setSn(int sn) { this.sn = sn; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getFeeRate() { return feeRate; }
    public void setFeeRate(double feeRate) { this.feeRate = feeRate; }

    public int getOrderQuantity() { return orderQuantity; }
    public void setOrderQuantity(int orderQuantity) { this.orderQuantity = orderQuantity; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}