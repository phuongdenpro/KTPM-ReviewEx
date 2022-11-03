package com.example.chuyenbayservice.controller;

import com.example.chuyenbayservice.entity.ChuyenBay;
import com.example.chuyenbayservice.service.ChuyenBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/chuyen-bay")
public class ChuyenBayController {
    @Autowired
    private ChuyenBayService chuyenBayService;
//    private ChuyenBayRepository chuyenBayRepository;
    //Câu 1
    @GetMapping("/chuyen-bay-toi-dad")
    public List<ChuyenBay> toDalat() {
        List<ChuyenBay> listChuyenBay = (List<ChuyenBay>) chuyenBayService.getChuyenBayDen("DAD");
        System.out.println(listChuyenBay);
        return listChuyenBay;
    }
    //Câu 4
    @GetMapping("/chuyen-bay-tu-8000-10000km")
    public List<ChuyenBay> chuyenbaytu8000den10000() {
        List<ChuyenBay> listChuyenBay = (List<ChuyenBay>) chuyenBayService.getChuyenBayTu8000den10000();
        System.out.println(listChuyenBay);
        return listChuyenBay;
    }
    //Câu 5
    @GetMapping("/chuyen-bay-tu-SaiGon-BuonMeThuoc")
    public List<ChuyenBay> chuyenbaytuSaiGondenBuonMeThuoc() {
        List<ChuyenBay> listChuyenBay = (List<ChuyenBay>) chuyenBayService.getChuyenBayTuSaiGondenBuonMeThuoc();
        System.out.println(listChuyenBay);
        return listChuyenBay;
    }

    //Câu 6
    @GetMapping("/so-chuyen-bay-tu-SaiGon")
    public String tinhSoChuyenBayTuSaiGon(){
        return "Số chuyến bay xuất phát từ Sài Gòn: " + chuyenBayService.tinhChuyenBayByGaDiSaiGon();
    }

    }