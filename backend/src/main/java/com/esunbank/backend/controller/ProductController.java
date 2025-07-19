package com.esunbank.backend.controller;

import com.esunbank.backend.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping
    public List<Product> getAllProducts() {
        String sql = "SELECT no, product_name, price, fee_rate FROM product";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Product p = new Product();
            p.setNo(rs.getInt("no"));
            p.setProductName(rs.getString("product_name"));
            p.setPrice(rs.getDouble("price"));
            p.setFeeRate(rs.getDouble("fee_rate"));
            return p;
        });
    }

    @PostMapping
    public void addProduct(@RequestBody Product req) {
        String sql = "INSERT INTO product (product_name, price, fee_rate) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, req.getProductName(), req.getPrice(), req.getFeeRate());
    }
}