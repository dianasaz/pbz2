package com.example.demo.controller.locality;

import com.example.demo.service.LocalityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/locality/{id}/delete")
public class DeleteLocality {
    private final LocalityService localityService;
    @Autowired
    public DeleteLocality(LocalityService localityService) {
        this.localityService = localityService;
    }

    @GetMapping
    public String deleteLocality(@PathVariable Integer id) {
        localityService.deleteById(id);
        return "redirect:/watch/locality";
    }


}
