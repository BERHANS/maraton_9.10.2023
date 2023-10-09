package com.berhan.controller;

import com.berhan.repository.entity.BaseEntity;
import com.berhan.repository.entity.User;
import com.berhan.service.UserService;
import com.berhan.utility.Constants;

import java.util.List;
import java.util.Optional;

public class UserController {

    UserService userService;
    Constants constants;

    public UserController() {
        this.userService = new UserService();
    }
    public User save(User user){
        return userService.save(user);
    }
    public List<User> findAll(){
        return userService.findAll();
    }
    public Optional<User> findById(Long id){
        return userService.findById(id);
    }

    public User createAccount(String name,String email,String phone,String nickname){

        User user = User.builder()
                .name_surname(name)
                .nickName(nickname)
                .email(email)
                .phoneNumber(phone)
                .baseEntity(new Constants().getBaseEntity())
                .build();
        save(user);
        return user;
    }
    public List<User> findByColumnNameAndValue(String cloumnName, String value){
        return userService.findByColumnNameAndValue(cloumnName,value);
    }
    public Optional<User> userDogrulamaSorgusu(String kullaniciAdi){
        return userService.userDogrulamaSorgusu(kullaniciAdi);
    }
}
