package com.example.demo.controller.hotel;

import com.example.demo.entity.Hotel;
import com.example.demo.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/hotel")
public class WatchHotel {
    private final HotelService hotelService;
    @Autowired
    public WatchHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String watchHotel(Model model){
        List<Hotel> hotels = hotelService.findAll();
        model.addAttribute("hotels", hotels);
        return "watchHotel";
    }
}
