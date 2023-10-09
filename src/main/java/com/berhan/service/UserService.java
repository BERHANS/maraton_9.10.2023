package com.berhan.service;

import com.berhan.repository.UserRepository;
import com.berhan.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService {

    UserRepository userRepository;
    public UserService(){
        this.userRepository = new UserRepository();
    }

    public User save(User user){
        return userRepository.save(user);

    }
    public List<User> findAll(){
        return userRepository.findAll();
    }
    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> userDogrulamaSorgusu(String kullaniciAdi){
        return userRepository.userDogrulamaSorgusu(kullaniciAdi);
    }
    public List<User> findByColumnNameAndValue(String cloumnName, String value){
        return userRepository.findByColumnNameAndValue(cloumnName,value);
    }

}
