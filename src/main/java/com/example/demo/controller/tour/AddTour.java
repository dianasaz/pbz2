package com.example.demo.controller.tour;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;
import com.example.demo.entity.Tour;
import com.example.demo.entity.TourType;
import com.example.demo.service.OfficeService;
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
@RequestMapping (value = "/tour/add")
public class AddTour {
    private final OfficeService officeService;
    private final TourService tourService;
    @Autowired
    public AddTour(OfficeService officeService, TourService tourService) {
        this.officeService = officeService;
        this.tourService = tourService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("tour", new Tour());
        model.addAttribute("types", findAll());
        model.addAttribute("offices", findAllOffices());
        return "addTour";
    }

    private TourType[] findAll(){
        return TourType.values();
    }

    private List<Office> findAllOffices(){
        return officeService.findAll();
    }


    private Optional<Office> findOffice(Integer id){
        return officeService.findById(id);
    }

    @PostMapping
    public String saveNew(Tour tour){
        findOffice(tour.getOffice().getId()).ifPresent(tour::setOffice);
        tourService.save(tour);
        return "redirect:/";
    }





}

