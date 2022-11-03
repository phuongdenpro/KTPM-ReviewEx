package com.example.chuyenbayservice.service;


import com.example.chuyenbayservice.entity.ChuyenBay;
import com.example.chuyenbayservice.repository.ChuyenBayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChuyenBayServiceImpl implements ChuyenBayService{
    @Autowired
    private ChuyenBayRepository chuyenBayRepository;

    @Override
    public List<ChuyenBay> getChuyenBayDen(String gaDen) {
        List<ChuyenBay> chuyenBayList = chuyenBayRepository.getChuyenBayDen(gaDen);
        return chuyenBayList;
    }

    @Override
    public List<ChuyenBay> getChuyenBayTu8000den10000() {
        List<ChuyenBay> chuyenBayList = chuyenBayRepository.getChuyenBayTu8000den10000();
        return chuyenBayList;
    }

    @Override
    public List<ChuyenBay> getChuyenBayTuSaiGondenBuonMeThuoc() {
        List<ChuyenBay> chuyenBayList = chuyenBayRepository.getChuyenBayTuSaiGondenBuonMeThuoc();
        return chuyenBayList;
    }

    @Override
    public int tinhChuyenBayByGaDiSaiGon() {
        List<ChuyenBay> chuyenBayList = chuyenBayRepository.tinhChuyenBayTuSaiGon();
        return chuyenBayList.size();
    }


}
