package com.berhan.controller;

import com.berhan.repository.entity.Post;
import com.berhan.repository.entity.User;
import com.berhan.service.PostService;
import com.berhan.service.UserService;
import com.berhan.utility.Constants;
import com.berhan.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class PostController {
    PostService postService;
    Constants constants;
    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();

    public PostController() {
        this.postService = new PostService();
    }
    public Post save(Post post){
        return postService.save(post);
    }
    public List<Post> findAll(){
        return postService.findAll();
    }
    public Optional<Post> findById(Long id){
        return postService.findById(id);
    }
    public Post postOlustur(Long userid,String text){
        Post post = Post.builder()
                .baseEntity(new Constants().getBaseEntity())
                .userid(userid)
                .text(text)
                .build();
        save(post);
        return post;
    }
    public List<Post> kullanicininPostları(Long userid){
        String sql = " SELECT * FROM tbl_post WHERE userid=:x";
        TypedQuery<Post> query = (TypedQuery<Post>) entityManager.createNativeQuery(sql, Post.class);
        query.setParameter("x",userid);
        List<Post> posts = query.getResultList();
        return posts;
    }
}
