package com.esunbank.backend.service;

import com.esunbank.backend.model.LikeRequest;
import com.esunbank.backend.model.LikeResponse;
import com.esunbank.backend.repository.LikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    @Autowired
    private LikeRepository likeRepository;

    public void addLike(LikeRequest req) {
        likeRepository.insertLike(req);
    }

    public List<LikeResponse> getLikes() {
        return likeRepository.getAllLikes();
    }

    public void deleteLike(int sn) {
        likeRepository.deleteLike(sn);
    }

    public void updateLike(LikeResponse req) {
        likeRepository.updateLike(req);
    }
}
