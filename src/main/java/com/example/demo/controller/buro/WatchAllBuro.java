package com.example.demo.controller.buro;

import com.example.demo.entity.Buro;
import com.example.demo.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/watch/buro")
public class WatchAllBuro {
    private final BuroService buroService;
    @Autowired
    public WatchAllBuro(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping
    public String watchBuro(Model model){
        List<Buro> buros = buroService.findAll();
        model.addAttribute("buros", buros);
        return "watchBuro";
    }
}
