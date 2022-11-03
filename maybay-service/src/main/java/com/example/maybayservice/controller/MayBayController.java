package com.example.maybayservice.controller;

import com.example.maybayservice.entity.MayBay;
import com.example.maybayservice.service.MayBayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController()
@RequestMapping("/may-bay")
public class MayBayController {
    @Autowired
    private MayBayService mayBayService;

    //Câu 2
    @GetMapping("may-bay-hon-10000km")
    public List<MayBay> mayBayHon10000km(){
        List<MayBay> mayBayList = mayBayService.getMayBayHon10000km();
        return mayBayList;
    }
}
