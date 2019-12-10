package com.example.demo.controller.buro;

import com.example.demo.entity.Buro;
import com.example.demo.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping (value = "/buro/{id}/update")
public class UpdateBuro {
    private final BuroService buroService;
    @Autowired
    public UpdateBuro(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("buro", getBuro(id).orElse(new Buro()));
        return "addBuro";
    }

    private Optional<Buro> getBuro(Integer id){
        return buroService.findById(id);
    }

    @PostMapping
    public String update( Buro buro, Errors errors){
        if (errors.hasErrors()) return "addBuro";
        buroService.save(buro);
        return "redirect:/";
    }
}
