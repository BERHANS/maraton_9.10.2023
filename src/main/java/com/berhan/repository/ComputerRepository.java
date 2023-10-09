package com.berhan.repository;

import com.berhan.repository.entity.Computer;
import com.berhan.utility.MyFactoryRepository;

public class ComputerRepository extends MyFactoryRepository<Computer,Long> {
    public ComputerRepository() {
        super(new Computer());
    }
}
