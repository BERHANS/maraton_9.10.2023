package com.berhan.repository;

import com.berhan.repository.entity.Like;
import com.berhan.utility.MyFactoryRepository;

public class LikeRepository extends MyFactoryRepository<Like,Long> {
    public LikeRepository() {
        super(new Like());
    }
}
