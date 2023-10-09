package com.berhan.controller;

import com.berhan.repository.entity.Photo;
import com.berhan.repository.entity.User;
import com.berhan.service.PhotoService;
import com.berhan.service.UserService;
import com.berhan.utility.Constants;

import java.util.List;
import java.util.Optional;

public class PhotoController {
    PhotoService photoService;
    Constants constants;

    public PhotoController() {
        this.photoService = new PhotoService();
    }
    public Photo save(Photo photo){
        return photoService.save(photo);
    }
    public List<Photo> findAll(){
        return photoService.findAll();
    }
    public Optional<Photo> findById(Long id){
        return photoService.findById(id);
    }
    public Photo photoOlustur(String url,Long id){
        Photo photo = Photo.builder()
                .photoUrl(url)
                .postid(id)
                .baseEntity(new Constants().getBaseEntity())
                .build();
        save(photo);
        return photo;
    }
}
