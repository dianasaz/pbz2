package com.example.demo.controller.tour;

import com.example.demo.entity.Office;
import com.example.demo.entity.Tour;
import com.example.demo.service.OfficeService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/tour")
public class WatchTour {
    private final TourService tourService;
    @Autowired
    public WatchTour(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String watchTour(Model model){
        List<Tour> tours = tourService.findAll();
        model.addAttribute("tours", tours);
        return "watchTours";
    }
}
