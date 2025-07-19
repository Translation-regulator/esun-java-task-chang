package com.esunbank.backend.model;

public class LikeRequest {
    private String userId;
    private int productId;
    private int orderQuantity;

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getOrderQuantity() { return orderQuantity; }
    public void setOrderQuantity(int orderQuantity) { this.orderQuantity = orderQuantity; }
}