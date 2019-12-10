package com.example.demo.controller.tour;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;
import com.example.demo.entity.Tour;
import com.example.demo.entity.TourType;
import com.example.demo.service.BuroService;
import com.example.demo.service.OfficeService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/tour/{id}/update")
public class UpdateTour {
    private final OfficeService officeService;
    private final TourService tourService;

    @Autowired
    public UpdateTour(OfficeService officeService, TourService tourService) {
        this.officeService = officeService;
        this.tourService = tourService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("tour", getTour(id).orElse(new Tour()));
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

    private Optional<Tour> getTour(Integer id){
        return tourService.findById(id);
    }

    @PostMapping
    public String update( Tour tour, Errors errors){
        if (errors.hasErrors()) return "addTour";
        tourService.save(tour);
        return "redirect:/";
    }
}


