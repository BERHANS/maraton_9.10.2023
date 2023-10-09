package com.berhan.service;

import com.berhan.repository.ComputerSpecRepository;
import com.berhan.repository.UserRepository;
import com.berhan.repository.entity.ComputerSpec;
import com.berhan.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class ComputerSpecService {
    ComputerSpecRepository computerSpecRepository;
    public ComputerSpecService(){
        this.computerSpecRepository = new ComputerSpecRepository();
    }

    public ComputerSpec save(ComputerSpec computerSpec){
        return computerSpecRepository.save(computerSpec);

    }
    public List<ComputerSpec> findAll(){
        return computerSpecRepository.findAll();
    }
    public Optional<ComputerSpec> findById(Long id){
        return computerSpecRepository.findById(id);
    }
}
