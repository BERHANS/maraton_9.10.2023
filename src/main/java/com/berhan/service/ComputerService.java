package com.berhan.service;

import com.berhan.repository.ComputerRepository;
import com.berhan.repository.ComputerSpecRepository;
import com.berhan.repository.entity.Computer;
import com.berhan.repository.entity.User;

import java.util.List;
import java.util.Optional;

public class ComputerService {
    ComputerRepository computerRepository;
    public  ComputerService() {
        this.computerRepository = new ComputerRepository();
    }

    public Computer save(Computer computer){
        return computerRepository.save(computer);

    }
    public List<Computer> findAll(){
        return computerRepository.findAll();
    }
    public Optional<Computer> findById(Long id){
        return computerRepository.findById(id);
    }
}
