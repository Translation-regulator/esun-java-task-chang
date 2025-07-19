package com.esunbank.backend.controller;

import com.esunbank.backend.model.LikeRequest;
import com.esunbank.backend.model.LikeResponse;
import com.esunbank.backend.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/likes")
public class LikeController {

    @Autowired
    private LikeService likeService;

    @PostMapping
    public void createLike(@RequestBody LikeRequest req) {
        likeService.addLike(req);
    }

    @GetMapping
    public List<LikeResponse> getAll() {
        return likeService.getLikes();
    }

    @DeleteMapping("/{sn}")
    public void delete(@PathVariable int sn) {
        likeService.deleteLike(sn);
    }

    @PutMapping("/{sn}")
    public void update(@PathVariable int sn, @RequestBody LikeResponse req) {
        req.setSn(sn);  
        likeService.updateLike(req);
    }

}
