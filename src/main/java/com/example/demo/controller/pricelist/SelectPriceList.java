package com.example.demo.controller.pricelist;

import com.example.demo.entity.Office;
import com.example.demo.entity.PriceList;
import com.example.demo.service.OfficeService;
import com.example.demo.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/select/priceList")
public class SelectPriceList {
    private final PriceListService priceListService;
    private final OfficeService officeService;

    @Autowired
    public SelectPriceList(PriceListService priceListService, OfficeService officeService) {
        this.priceListService = priceListService;
        this.officeService = officeService;
    }

    @GetMapping
    public String selectOffice(Model model) {
        List<Office> offices = officeService.findAll();
        model.addAttribute("offices", offices);
        return "selectPriceList";
    }

    @PostMapping
    public String getPriceList(Integer office_id, Model model, String date) {
        DateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        Date d;
        try {
            d = format.parse(date);
        } catch (ParseException e) {
            return "redirect:/";
        }
        Optional<PriceList> pl = priceListService.findLastByOfficeAndDate(office_id, d);
        if (pl.isPresent()) {
            model.addAttribute("priceList", pl.get());
            return "watchPriceList";
        } else return "redirect:/";
    }
}
