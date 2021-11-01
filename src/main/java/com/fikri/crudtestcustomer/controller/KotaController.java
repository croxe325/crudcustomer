package com.fikri.crudtestcustomer.controller;

import com.fikri.crudtestcustomer.model.Kota;
import com.fikri.crudtestcustomer.services.KotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class KotaController {
    private KotaService kotaService;
    @Autowired
    public void setCustomerService(KotaService kotaService) {
        this.kotaService = kotaService;
    }


    @RequestMapping ("/kota")
    public String Kotalist(Model model){
        model.addAttribute("kota",kotaService.listKota() );
        return "kota";
    }
    @RequestMapping(value = "/kota/create", method = RequestMethod.GET)
    public String tampilkanForm(Model model){
        model.addAttribute("kota", new Kota());
        return "formKota";

    }
    @RequestMapping(value = "/kota/create", method = RequestMethod.POST)
    public String simpanDataKota(Model model, Kota kota){
        model.addAttribute("kota",kotaService.saveOrUpdate(kota));
        return "redirect:/kota";
    }
    @RequestMapping(value = "/kota/edit/{id}", method = RequestMethod.GET)
    public String editData(@PathVariable String id, Model model){
        model.addAttribute("kota",kotaService.getIdKota(id));
        return "formKota";
    }
    @RequestMapping(value = "/kota/hapus/{id}")
    public String hapus(@PathVariable String id){
        kotaService.hapus(id);
        return "redirect:/kota";
    }

}
