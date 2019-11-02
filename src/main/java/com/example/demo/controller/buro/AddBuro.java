package com.example.demo.controller.buro;

import com.example.demo.entity.Buro;
import com.example.demo.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/buro/add")
public class AddBuro {
    private final BuroService buroService;
    @Autowired
    public AddBuro(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("buro", new Buro());
        return "addBuro";
    }

    @PostMapping
    public String saveNew(Buro buro){
        buroService.save(buro);
        return "redirect:/";
    }
}
