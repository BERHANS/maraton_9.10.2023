package com.berhan.repository;

import com.berhan.repository.entity.ComputerSpec;
import com.berhan.utility.MyFactoryRepository;

public class ComputerSpecRepository extends MyFactoryRepository<ComputerSpec,Long> {

    public ComputerSpecRepository() {
        super(new ComputerSpec());
    }
}
