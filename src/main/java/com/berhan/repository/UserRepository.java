package com.berhan.repository;

import com.berhan.repository.entity.User;
import com.berhan.utility.HibernateUtility;
import com.berhan.utility.MyFactoryRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.Optional;

public class UserRepository extends MyFactoryRepository<User,Long> {
    public UserRepository() {
        super(new User());
    }
    EntityManager entityManager = HibernateUtility.getSessionFactory().createEntityManager();
    public Optional<User> userDogrulamaSorgusu(String kullaniciAdi){
        String sql = "SELECT * FROM tbl_user WHERE nickName=:kullaniciAdi";
        TypedQuery<User> query = (TypedQuery<User>) entityManager.createNativeQuery(sql, User.class);

        query.setParameter("kullaniciAdi",kullaniciAdi);
        User user= query.getSingleResult();
        return Optional.ofNullable(user);
    }

}
