package com.berhan.service;

import com.berhan.repository.PostRepository;
import com.berhan.repository.entity.Post;


import java.util.List;
import java.util.Optional;

public class PostService {
    PostRepository postRepository;
    public PostService(){
        this.postRepository = new PostRepository();
    }

    public Post save(Post post){
        return postRepository.save(post);

    }
    public List<Post> findAll(){
        return postRepository.findAll();
    }
    public Optional<Post> findById(Long id){
        return postRepository.findById(id);
    }
}
