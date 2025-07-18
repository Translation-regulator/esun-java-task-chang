package com.esunbank.backend.model;

public class LikeResponse {
    private int sn;
    private String productName;
    private double totalAmount;
    private double totalFee;
    private String account;
    private String email;

    // getter/setter
    public int getSn() { return sn; }
    public void setSn(int sn) { this.sn = sn; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTotalFee() { return totalFee; }
    public void setTotalFee(double totalFee) { this.totalFee = totalFee; }

    public String getAccount() { return account; }
    public void setAccount(String account) { this.account = account; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}
