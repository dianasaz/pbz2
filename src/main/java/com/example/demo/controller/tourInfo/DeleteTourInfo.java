package com.example.demo.controller.tourInfo;

import com.example.demo.service.TourInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/tourInfo/{id}/delete")
public class DeleteTourInfo {
    private final TourInfoService tourService;
    @Autowired
    public DeleteTourInfo(TourInfoService tourService) {
        this.tourService = tourService;
    }

    @GetMapping
    public String deleteOffice(@PathVariable Integer id) {
        tourService.deleteById(id);
        return "redirect:/watch/tourInfo";
    }
}
