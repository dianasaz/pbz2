package com.example.demo.controller.tourInfo;

import com.example.demo.entity.Hotel;
import com.example.demo.service.TourInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping (value = "/hotel/fivestar")
public class SelectHotel {
    private final TourInfoService tourInfoService;
    @Autowired
    public SelectHotel(TourInfoService tourInfoService) {
        this.tourInfoService = tourInfoService;
    }

    @GetMapping
    public String watch(Model model){
        List<Hotel> hotels = findAll();
        model.addAttribute("hotels",hotels);
        return "watchHotelsFiveStars";
    }

    private List<Hotel> findAll(){
        return tourInfoService.findHotels();
    }
}

