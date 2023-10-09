package com.berhan.repository;

import com.berhan.repository.entity.Photo;
import com.berhan.utility.MyFactoryRepository;

public class PhotoRepository extends MyFactoryRepository<Photo,Long> {

    public PhotoRepository() {
        super(new Photo());
    }
}
