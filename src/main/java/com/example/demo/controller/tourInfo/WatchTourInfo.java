package com.example.demo.controller.tourInfo;

import com.example.demo.entity.Office;
import com.example.demo.entity.PriceList;
import com.example.demo.entity.Tour;
import com.example.demo.entity.TourInfo;
import com.example.demo.service.OfficeService;
import com.example.demo.service.PriceListService;
import com.example.demo.service.TourInfoService;
import com.example.demo.service.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/watch/tourInfo")
public class WatchTourInfo {
    private final TourInfoService tourInfoService;
    private final PriceListService priceListService;
    @Autowired
    public WatchTourInfo(TourInfoService tourInfoService, PriceListService priceListService) {
        this.tourInfoService = tourInfoService;
        this.priceListService = priceListService;
    }

    @GetMapping
    public String watchTour(Model model){
        List<TourInfo> tours = tourInfoService.findAll();
        for (TourInfo t: tours){
            Optional<PriceList> priceListOptional = priceListService.findLastByOfficeAndDate(t.getTour().getOffice().getId(), new Date());
            priceListOptional.ifPresent(n -> t.updateActualPrice(n.getCoefficient()));
        }
        model.addAttribute("tours", tours);
        return "watchTourInfo";
    }
}
