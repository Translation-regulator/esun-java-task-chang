package com.esunbank.backend.service;

import com.esunbank.backend.model.LikeRequest;
import com.esunbank.backend.model.LikeResponse;
import com.esunbank.backend.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Transactional
    public void addLike(LikeRequest req) {
        likeRepository.insertLike(req);
    }

    public List<LikeResponse> getLikes() {
        return likeRepository.getAllLikes();
    }

    public void deleteLike(int sn) {
        likeRepository.deleteLike(sn);
    }

    @Transactional
    public void updateLike(int sn, int orderQuantity) {
        likeRepository.updateLike(sn, orderQuantity);
    }
}