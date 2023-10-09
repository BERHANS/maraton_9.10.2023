package com.berhan.service;

import com.berhan.repository.LikeRepository;
import com.berhan.repository.UserRepository;
import com.berhan.repository.entity.Like;
import com.berhan.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class LikeService {
    LikeRepository likeRepository;
    public LikeService(){
        this.likeRepository = new LikeRepository();
    }

    public Like save(Like like){
        return likeRepository.save(like);

    }
    public List<Like> findAll(){
        return likeRepository.findAll();
    }
    public Optional<Like> findById(Long id){
        return likeRepository.findById(id);
    }
}
