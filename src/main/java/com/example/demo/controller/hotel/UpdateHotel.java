package com.example.demo.controller.hotel;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Locality;
import com.example.demo.entity.Office;
import com.example.demo.service.BuroService;
import com.example.demo.service.HotelService;
import com.example.demo.service.LocalityService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/hotel/{id}/update")
public class UpdateHotel {
    private final LocalityService localityService;
    private final HotelService hotelService;

    @Autowired
    public UpdateHotel(LocalityService localityService, HotelService hotelService) {
        this.localityService = localityService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("hotel", getHotel(id).orElse(new Hotel()));
        model.addAttribute("localitites", findAll());
        return "addHotel";
    }

    private List<Locality> findAll(){
        return localityService.findAll();
    }

    private Optional<Hotel> getHotel(Integer id){
        return hotelService.findById(id);
    }

    @PostMapping
    public String update(Hotel hotel){
        hotelService.save(hotel);
        return "redirect:/";
    }
}


