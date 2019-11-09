package com.example.demo.controller.tourInfo;

import com.example.demo.entity.Hotel;
import com.example.demo.entity.Tour;
import com.example.demo.entity.TourInfo;
import com.example.demo.entity.Transport;
import com.example.demo.service.HotelService;
import com.example.demo.service.TourInfoService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/tourInfo/add")
public class AddTourInfo {
    private final TourService tourService;
    private final TourInfoService tourInfoService;
    private final HotelService hotelService;
    @Autowired
    public AddTourInfo(TourInfoService tourInfoService, TourService tourService, HotelService hotelService) {
        this.tourInfoService = tourInfoService;
        this.tourService = tourService;
        this.hotelService = hotelService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("tourInfo", new TourInfo());
        model.addAttribute("hotels", findAll());
        model.addAttribute("tours", findAllTours());
        model.addAttribute("transport", findTransport());
        return "addTourInfo";
    }

    private List<Hotel> findAll(){
        return hotelService.findAll();
    }

    private List<Tour> findAllTours(){
        return tourService.findAll();
    }


    private Optional<Hotel> findHotel(Integer id){
        return hotelService.findById(id);
    }

    private Transport[] findTransport(){
        return Transport.values();
    }

    private Optional<Tour> findTour(Integer id){
        return tourService.findById(id);
    }

    @PostMapping
    public String saveNew(TourInfo tour){
        findTour(tour.getTour().getId()).ifPresent(tour::setTour);
        findHotel(tour.getHotel().getId()).ifPresent(tour::setHotel);
        tour.setActualPrice(tour.getPrice());
        tourInfoService.save(tour);
        return "redirect:/";
    }
}

