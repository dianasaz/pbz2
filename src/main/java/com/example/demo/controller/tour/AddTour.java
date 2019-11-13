package com.example.demo.controller.tour;

import com.example.demo.entity.*;
import com.example.demo.service.LocalityService;
import com.example.demo.service.OfficeService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = "/tour/add")
public class AddTour {
    private final OfficeService officeService;
    private final TourService tourService;
    private final LocalityService localityService;

    @Autowired
    public AddTour(OfficeService officeService, TourService tourService, LocalityService localityService) {
        this.officeService = officeService;
        this.tourService = tourService;
        this.localityService = localityService;
    }

    @GetMapping
    public String add(Model model) {
        model.addAttribute("tour", new Tour());
        model.addAttribute("types", findAll());
        model.addAttribute("offices", findAllOffices());
        model.addAttribute("localitys", findAllLocalitites());
        return "addTour";
    }

    private List<Locality> findAllLocalitites() {
        return localityService.findAll();
    }

    private TourType[] findAll() {
        return TourType.values();
    }

    private List<Office> findAllOffices() {
        return officeService.findAll();
    }

    private Optional<Office> findOffice(Integer id) {
        return officeService.findById(id);
    }

    @PostMapping
    public String saveNew(Tour tour, Integer[] localitiesId) {
        findOffice(tour.getOffice().getId()).ifPresent(tour::setOffice);
        if (localitiesId == null) {
            tour.setLocalities(new ArrayList<Locality>());
        } else {
            List<Integer> localitiesIdList = new ArrayList<>(Arrays.asList(localitiesId));
            tour.setLocalities(localitiesIdList.stream()
                    .map(localityService::findById)
                    .filter(Optional::isPresent)
                    .map(Optional::get)
                    .collect(Collectors.toList()));
        }
        tourService.save(tour);
        return "redirect:/watch/tour";
    }


}

