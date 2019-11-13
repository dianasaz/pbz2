package com.example.demo.controller.office;

import com.example.demo.entity.Buro;
import com.example.demo.entity.Office;
import com.example.demo.service.BuroService;
import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping (value = "/office/add")
public class AddOffice {
    private final OfficeService officeService;
    private final BuroService buroService;
    @Autowired
    public AddOffice(OfficeService officeService, BuroService buroService) {
        this.officeService = officeService;
        this.buroService = buroService;
    }

    @GetMapping
    public String add(Model model){
        model.addAttribute("office", new Office());
        model.addAttribute("buros", findAll());
        return "addOffice";
    }

    private List<Buro> findAll(){
        return buroService.findAll();
    }

    private Optional<Buro> findBuro(Integer id){
        return buroService.findById(id);
    }

    @PostMapping
    public String saveNew(Office office){
        //findBuro(office.getBuro().getId()).ifPresent(office::setBuro);
        officeService.save(office);
        return "redirect:/";
    }





}
