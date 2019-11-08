package com.example.demo.controller.hotel;

import com.example.demo.entity.Hotel;
import com.example.demo.service.BuroService;
import com.example.demo.service.HotelService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/hotel/{id}/delete")
public class DeleteHotel {
    private final HotelService hotelService;

    @Autowired
    public DeleteHotel(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @GetMapping
    public String deleteHotel(@PathVariable Integer id) {
        hotelService.deleteById(id);
        return "redirect:/watch/hotel";
    }
}
