package com.example.demo.controller.office;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Hotel;
import com.example.demo.entity.Office;
import com.example.demo.service.BuroService;
import com.example.demo.service.HotelService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping (value = "/office/add")
public class AddOffice {
    private final OfficeService officeService;
    private final BuroService buroService;
    @Autowired
    public AddOffice(OfficeService officeService, BuroService buroService) {
        this.officeService = officeService;
        this.buroService = buroService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("office", new Office());
        model.addAttribute("buros", findAll());
        return "addOffice";
    }

    private List<Buro> findAll(){
        return buroService.findAll();
    }

    @PostMapping
    public String saveNew(Office office){
        officeService.save(office);
        return "redirect:/";
    }





}
