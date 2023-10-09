package com.berhan.controller;

import com.berhan.repository.entity.ComputerSpec;
import com.berhan.repository.entity.User;
import com.berhan.service.ComputerSpecService;
import com.berhan.service.UserService;
import com.berhan.utility.Constants;

import java.util.List;
import java.util.Optional;

public class ComputerSpecController {
   ComputerSpecService computerSpecService;
    Constants constants;

    public ComputerSpecController() {
        this.computerSpecService = new ComputerSpecService();
    }
    public ComputerSpec save(ComputerSpec computerSpec){
        return computerSpecService.save(computerSpec);
    }
    public List<ComputerSpec> findAll(){
        return computerSpecService.findAll();
    }
    public Optional<ComputerSpec> findById(Long id){
        return computerSpecService.findById(id);
    }
    public ComputerSpec computerSpecOlustur(String ram,Long computerid,String ekranKarti,Double fiyat){
        ComputerSpec computerSpec = ComputerSpec.builder()
                .ram(ram)
                .baseEntity(new Constants().getBaseEntity())
                .computerid(computerid)
                .ekranKartı(ekranKarti)
                .fiyat(fiyat)
                .build();
        save(computerSpec);
        return computerSpec;
    }
}
