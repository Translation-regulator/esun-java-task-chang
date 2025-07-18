package com.esunbank.backend.model;

public class LikeRequest {
    private int productId;
    private String userId;
    private int orderQuantity;

    // getter/setter
    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public int getOrderQuantity() { return orderQuantity; }
    public void setOrderQuantity(int orderQuantity) { this.orderQuantity = orderQuantity; }
}
