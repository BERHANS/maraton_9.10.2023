package com.berhan.controller;

import com.berhan.repository.entity.Computer;
import com.berhan.repository.entity.User;
import com.berhan.service.ComputerService;
import com.berhan.utility.Constants;

import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class ComputerController {
    ComputerService computerService;
    Constants constants;

    public  ComputerController() {
        this.computerService = new ComputerService();
    }
    public Computer save(Computer computer){
        return computerService.save(computer);
    }
    public List<Computer> findAll(){
        return computerService.findAll();
    }
    public Optional<Computer> findById(Long id){
        return computerService.findById(id);
    }
    public Computer computerOlustur(Long postid,Long userid){
        Computer computer = Computer.builder()
                .baseEntity(new Constants().getBaseEntity())
                .postid(postid)
                .userid(userid)
                .build();
        save(computer);
        return computer;
    }
//    public List<Computer> findAllMyComputers(){
//        String sql="SELECT * FROM tbl_computer WHERE userid=:x";
//        TypedQuery<Computer> query =
//    }
}
