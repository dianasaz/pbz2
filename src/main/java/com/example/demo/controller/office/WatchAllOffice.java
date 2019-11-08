package com.example.demo.controller.office;

import com.example.demo.entity.Office;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/office")
public class WatchAllOffice {
    private final OfficeService officeService;
    @Autowired
    public WatchAllOffice(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public String watchBuro(Model model){
        List<Office> offices = officeService.findAll();
        model.addAttribute("offices", offices);
        return "watchOffice";
    }
}
