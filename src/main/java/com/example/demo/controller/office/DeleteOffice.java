package com.example.demo.controller.office;

import com.example.demo.service.OfficeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping (value = "/office/{id}/delete")
public class DeleteOffice {
    private final OfficeService officeService;
    @Autowired
    public DeleteOffice(OfficeService officeService) {
        this.officeService = officeService;
    }

    @GetMapping
    public String deleteOffice(@PathVariable Integer id) {
        officeService.deleteById(id);
        return "redirect:/watch/office";
    }


}
