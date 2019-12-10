package com.example.demo.controller.tourInfo;

import com.example.demo.entity.*;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/tourInfo/{id}/update")
public class UpdateTourInfo {
    private final HotelService hotelService;
    private final TourService tourService;
    private final TourInfoService tourInfoService;

    @Autowired
    public UpdateTourInfo(HotelService hotelService, TourService tourService, TourInfoService tourInfoService) {
        this.hotelService = hotelService;
        this.tourInfoService = tourInfoService;
        this.tourService = tourService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("tourInfo", getTour(id).orElse(new TourInfo()));
        model.addAttribute("hotels", findAll());
        model.addAttribute("tours", findAllTours());
        model.addAttribute("transport", findTransport());
        return "addTourInfo";
    }

    private Transport[] findTransport(){
        return Transport.values();
    }

    private List<Hotel> findAll(){
        return hotelService.findAll();
    }

    private List<Tour> findAllTours(){
        return tourService.findAll();
    }

    private Optional<TourInfo> getTour(Integer id){
        return tourInfoService.findById(id);
    }

    @PostMapping
    public String update( TourInfo tourInfo){
        tourInfoService.save(tourInfo);
        return "redirect:/";
    }
}