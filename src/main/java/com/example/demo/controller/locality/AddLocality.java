package com.example.demo.controller.locality;

import com.example.demo.entity.Locality;
import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/locality/add")
public class AddLocality {
    private final LocalityService localityService;
    @Autowired
    public AddLocality(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("locality", new Locality());
        return "addLocality";
    }

    @PostMapping
    public String saveNew(Locality locality){
        localityService.save(locality);
        return "redirect:/";
    }
}
