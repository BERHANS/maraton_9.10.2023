package com.berhan.service;

import com.berhan.repository.PhotoRepository;
import com.berhan.repository.entity.Photo;


import java.util.List;
import java.util.Optional;

public class PhotoService {
    PhotoRepository photoRepository;
    public PhotoService(){
        this.photoRepository = new PhotoRepository();
    }

    public Photo save(Photo photo){
        return photoRepository.save(photo);

    }
    public List<Photo> findAll(){
        return photoRepository.findAll();
    }
    public Optional<Photo> findById(Long id){
        return photoRepository.findById(id);
    }
}
