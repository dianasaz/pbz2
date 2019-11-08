package com.example.demo.controller.locality;

import com.example.demo.entity.Locality;
import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping (value = "/locality/{id}/update")
public class UpdateLocality {
    private final LocalityService localityService;
    @Autowired
    public UpdateLocality(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("locality", getLocality(id).orElse(new Locality()));
        return "addLocality";
    }

    private Optional<Locality> getLocality(Integer id){
        return localityService.findById(id);
    }

    @PostMapping
    public String update(Locality locality){
        localityService.save(locality);
        return "redirect:/";
    }
}

