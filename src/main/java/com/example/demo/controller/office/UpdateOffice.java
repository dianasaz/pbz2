package com.example.demo.controller.office;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;
import com.example.demo.service.BuroService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/office/{id}/update")
public class UpdateOffice {
    private final OfficeService officeService;
    private final BuroService buroService;

    @Autowired
    public UpdateOffice(OfficeService officeService, BuroService buroService) {
        this.officeService = officeService;
        this.buroService = buroService;
    }

    @GetMapping
    public String add(Model model, @PathVariable Integer id){
        model.addAttribute("office", getOffice(id).orElse(new Office()));
        model.addAttribute("buros", findAll());
        return "addOffice";
    }

    private List<Buro> findAll(){
        return buroService.findAll();
    }

    private Optional<Office> getOffice(Integer id){
        return officeService.findById(id);
    }

    @PostMapping
    public String update( Office office, Errors errors){
        if (errors.hasErrors()) return "addOffice";
        officeService.save(office);
        return "redirect:/";
    }
}


