package com.berhan.controller;

import com.berhan.repository.entity.Like;
import com.berhan.service.LikeService;
import com.berhan.service.UserService;
import com.berhan.utility.Constants;
import com.berhan.utility.HibernateUtility;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class LikeController {
    LikeService likeService;
    Constants constants;
    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();

    public LikeController() {
        this.likeService = new LikeService();
    }
    public Like save(Like like){
        return likeService.save(like);
    }
    public List<Like> findAll(){
        return likeService.findAll();
    }
    public Optional<Like> findById(Long id){
        return likeService.findById(id);
    }
    public Like likeOlustur(Long postid,Long userid){
        Like like = Like.builder()
                .baseEntity(new Constants().getBaseEntity())
                .postid(postid)
                .userid(userid)
                .build();
        save(like);
        return like;
    }
    public void begenilenPostlariGetir(Long userid){
        String sql = "SELECT * FROM tbl_like WHERE userid=:x";
        TypedQuery<Like> query = (TypedQuery<Like>) entityManager.createNativeQuery(sql, Like.class);
        query.setParameter("x",userid);
        List<Like> likes = query.getResultList();
        likes.forEach(System.out::println);
    }
}
