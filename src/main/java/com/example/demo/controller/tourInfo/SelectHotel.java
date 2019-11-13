package com.example.demo.controller.tourInfo;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import com.example.demo.service.TourInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

@Controller
@RequestMapping (value = "/hotel/fivestar")
public class SelectHotel {
    private final TourInfoService tourInfoService;
    private final HotelService hotelService;

    @Autowired
    public SelectHotel(TourInfoService tourInfoService, HotelService hotelService) {
        this.tourInfoService = tourInfoService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String watch(Model model){
        List<Hotel> hotels = findAll();
        model.addAttribute("hotels",hotels);
        return "watchHotelsFiveStars";
    }

    private List<Hotel> findAll(){
        List<Integer> hotelsId = tourInfoService.findIdOfHotelsWithFiveStars();
        List<Hotel> hotels = new ArrayList<>();
        for (Integer id : hotelsId) {
            hotels.add(hotelService.findById(id).get());
        }
        return hotels;
    }
}

