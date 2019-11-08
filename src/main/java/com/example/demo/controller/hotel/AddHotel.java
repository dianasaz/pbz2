package com.example.demo.controller.hotel;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;
import com.example.demo.service.HotelService;
import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/hotel/add")
public class AddHotel {
    private final LocalityService localityService;
    private final HotelService hotelService;
    @Autowired
    public AddHotel(LocalityService localityService, HotelService hotelService) {
        this.localityService = localityService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("hotel", new Hotel());
        model.addAttribute("localitites", findAll());
        return "addHotel";
    }

    private List<Locality> findAll() {
        return localityService.findAll();
    }

    private Optional<Locality> findLocality(Integer id){
        return localityService.findById(id);
    }

    @PostMapping
    public String saveNew(Hotel hotel){
        findLocality(hotel.getLocality().getId()).ifPresent(hotel::setLocality);
        hotelService.save(hotel);
        return "redirect:/";
    }
}

