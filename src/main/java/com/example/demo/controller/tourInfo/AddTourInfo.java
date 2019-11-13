package com.example.demo.controller.tourInfo;

import com.example.demo.entity.*;
import com.example.demo.service.HotelService;
import com.example.demo.service.LocalityService;
import com.example.demo.service.TourInfoService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping (value = "/tour/{id}/add/tourinfo")
public class AddTourInfo {
    private final TourService tourService;
    private final TourInfoService tourInfoService;
    private final HotelService hotelService;
    private final LocalityService localityService;
    @Autowired
    public AddTourInfo(TourInfoService tourInfoService, LocalityService localityService, TourService tourService, HotelService hotelService) {
        this.tourInfoService = tourInfoService;
        this.tourService = tourService;
        this.hotelService = hotelService;
        this.localityService = localityService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        TourInfo tourInfo = new TourInfo();
        tourInfo.setTour(findTour(id));
        model.addAttribute("tourInfo", tourInfo);
        model.addAttribute("tour", findTour(id));
        model.addAttribute("hotels", findHotels());
        model.addAttribute("transport", findTransport());
        return "addTourInfo";
    }

    private List<Hotel> findHotels(){
        return hotelService.findAll();
    }

    private Transport[] findTransport(){
        return Transport.values();
    }

    private Tour findTour(Integer id){
        if (tourService.findById(id).isPresent()) return tourService.findById(id).get();
        else return null;
    }

    private Optional<Tour> findTourOptional(Integer id){
        return tourService.findById(id);
    }

    @PostMapping
    public String saveNew(TourInfo tour, Integer[] hotelsId){
        findTourOptional(tour.getTour().getId()).ifPresent(tour::setTour);
        tour.setActualPrice(tour.getPrice());
        if (hotelsId == null) {
            tour.setHotels(new ArrayList<Hotel>());
        } else {
            List<Integer> hotelsIdList = new ArrayList<>(Arrays.asList(hotelsId));
            tour.setHotels(hotelsIdList.stream()
                    .map(hotelService::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList()));
        }
        tourInfoService.save(tour);
        return "redirect:/";
    }
}

