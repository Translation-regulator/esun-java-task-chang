package com.esunbank.backend.model;

public class Product {
    private int no;
    private String productName;
    private double price;
    private double feeRate;

    public int getNo() { return no; }
    public void setNo(int no) { this.no = no; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public double getFeeRate() { return feeRate; }
    public void setFeeRate(double feeRate) { this.feeRate = feeRate; }
}