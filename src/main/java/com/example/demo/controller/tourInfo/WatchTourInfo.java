package com.example.demo.controller.tourInfo;

import com.example.demo.entity.Office;
import com.example.demo.entity.Tour;
import com.example.demo.entity.TourInfo;
import com.example.demo.service.OfficeService;
import com.example.demo.service.TourInfoService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/tourInfo")
public class WatchTourInfo {
    private final TourInfoService tourInfoService;
    @Autowired
    public WatchTourInfo(TourInfoService tourInfoService) {
        this.tourInfoService = tourInfoService;
    }

    @GetMapping
    public String watchTour(Model model){
        List<TourInfo> tours = tourInfoService.findAll();
        model.addAttribute("tours", tours);
        return "watchTourInfo";
    }
}
