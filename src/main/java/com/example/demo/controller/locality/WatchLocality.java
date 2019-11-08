package com.example.demo.controller.locality;

import com.example.demo.entity.Locality;
import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/locality")
public class WatchLocality {
    private final LocalityService localityService;
    @Autowired
    public WatchLocality(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public String watchBuro(Model model){
        List<Locality> localities = localityService.findAll();
        model.addAttribute("localities", localities);
        return "watchLocality";
    }
}
