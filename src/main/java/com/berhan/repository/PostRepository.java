package com.berhan.repository;

import com.berhan.repository.entity.Post;
import com.berhan.utility.MyFactoryRepository;

public class PostRepository extends MyFactoryRepository<Post,Long> {
    public PostRepository() {
        super(new Post());
    }
}
