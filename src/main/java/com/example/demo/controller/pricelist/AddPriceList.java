package com.example.demo.controller.pricelist;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;
import com.example.demo.entity.PriceList;
import com.example.demo.service.BuroService;
import com.example.demo.service.OfficeService;
import com.example.demo.service.PriceListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/priceList/add")
public class AddPriceList {
    private final OfficeService officeService;
    private final PriceListService priceListService;
    @Autowired
    public AddPriceList(OfficeService officeService, PriceListService priceListService) {
        this.officeService = officeService;
        this.priceListService = priceListService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("priceList", new PriceList());
        model.addAttribute("offices", findAllOffices());
        return "addPriceList";
    }

    private List<Office> findAllOffices(){
        return officeService.findAll();
    }

    private Optional<Office> findOffice(Integer id){
        return officeService.findById(id);
    }

    @PostMapping
    public String saveNew(PriceList priceList){
        findOffice(priceList.getOffice().getId()).ifPresent(priceList::setOffice);
        priceListService.save(priceList);
        return "redirect:/";
    }





}

