package com.example.maybayservice.service;

import com.example.maybayservice.entity.MayBay;
import com.example.maybayservice.repository.MayBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MayBayServiceImpl implements MayBayService{
    @Autowired
    private MayBayRepository mayBayRepository;
    @Override
    public List<MayBay> getMayBayHon10000km() {
        List<MayBay> mayBayList =  mayBayRepository.getMayBayHon10000km();
        return mayBayList;
    }
}
