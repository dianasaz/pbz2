package com.example.demo.controller.buro;

import com.example.demo.service.BuroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/buro/{id}/delete")
public class DeleteBuro {
    private final BuroService buroService;
    @Autowired
    public DeleteBuro(BuroService buroService) {
        this.buroService = buroService;
    }

    @GetMapping
    public String deleteProduct(@PathVariable Integer id) {
        buroService.deleteById(id);
        return "redirect:/watch/buro";
    }


}
