package com.example.demo.controller.tour;

import com.example.demo.service.OfficeService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/tour/{id}/delete")
public class DeleteTour {
    private final TourService tourService;
    @Autowired
    public DeleteTour(TourService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String deleteOffice(@PathVariable Integer id) {
        tourService.deleteById(id);
        return "redirect:/watch/tour";
    }


}
