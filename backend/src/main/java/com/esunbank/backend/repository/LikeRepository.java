package com.esunbank.backend.repository;

import com.esunbank.backend.model.LikeRequest;
import com.esunbank.backend.model.LikeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.List;

@Repository
public class LikeRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public void insertLike(LikeRequest req) {
        jdbcTemplate.execute((Connection conn) -> {
            try (CallableStatement cs = conn.prepareCall("{call insert_like(?, ?, ?)}")) {
                cs.setString(1, req.getUserId());
                cs.setInt(2, req.getProductId());
                cs.setInt(3, req.getOrderQuantity());
                cs.execute();
            }
            return null;
        });
    }

    public List<LikeResponse> getAllLikes() {
        String sql = """
            SELECT 
              l.sn,
              p.product_name,
              p.price,
              p.fee_rate,
              l.order_name,
              l.total_amount,
              l.total_fee,
              u.account,
              u.email
            FROM like_list l
            JOIN product p ON l.product_id = p.no
            JOIN user u ON l.user_id = u.user_id
        """;

        RowMapper<LikeResponse> mapper = (rs, rowNum) -> {
            LikeResponse resp = new LikeResponse();
            resp.setSn(rs.getInt("sn"));
            resp.setProductName(rs.getString("product_name"));
            resp.setPrice(rs.getDouble("price"));
            resp.setFeeRate(rs.getDouble("fee_rate"));
            resp.setOrderQuantity(rs.getInt("order_name"));
            resp.setTotalAmount(rs.getDouble("total_amount"));
            resp.setTotalFee(rs.getDouble("total_fee"));
            resp.setAccount(rs.getString("account"));
            resp.setEmail(rs.getString("email"));
            return resp;
        };

        return jdbcTemplate.query(sql, mapper);
    }

    public void deleteLike(int sn) {
        jdbcTemplate.update("DELETE FROM like_list WHERE sn = ?", sn);
    }

    public void updateLike(int sn, int orderQuantity) {
        jdbcTemplate.update("UPDATE like_list SET order_name = ? WHERE sn = ?", orderQuantity, sn);
    }
}
