package com.fikri.crudtestcustomer.controller;

import com.fikri.crudtestcustomer.model.Customer;
import com.fikri.crudtestcustomer.services.CustomerService;
import com.fikri.crudtestcustomer.services.CustomerServiceImpl;
import com.fikri.crudtestcustomer.services.KotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;

@Controller
public class CustomerController implements WebMvcConfigurer {
    private CustomerServiceImpl customerServiceimpl;
    private KotaService kotaService;
    private CustomerService customerService;


    //Mengatur customerController untuk mempunyai 2 service
    @Autowired
    public void setCustomerService(CustomerServiceImpl customerServiceimpl, KotaService kotaService, CustomerService customerService) {
        this.customerServiceimpl = customerServiceimpl;
        this.kotaService = kotaService;
        this.customerService = customerService;

    }

    @RequestMapping ( "/customer" )
    public String Customerlist(Model model) {
        model.addAttribute("customerJoin", customerServiceimpl.getCustJoin());

        return "customer";
    }

    @RequestMapping ( value = "/customer/create", method = RequestMethod.GET )
    public String tampilkanForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("kota", kotaService.listKota());

        return "formCustomer";

    }


    @RequestMapping ( value = "/customer/create", method = RequestMethod.POST )
    public String simpanDataCustomer(@Valid Customer customer, BindingResult bindingResult, Model model) {

        if (bindingResult.hasErrors()) {
            return "formCustomer";
        } else {
            model.addAttribute("customer", customerService.saveOrUpdate(customer));
            model.addAttribute("kota", kotaService.listKota());
            MyThread myThread = new MyThread();
            myThread.start();
            return "redirect:/customer";
        }


    }

    @RequestMapping ( value = "/customer/edit/{id}", method = RequestMethod.GET )
    public String editData(@PathVariable String id, Model model) {
        model.addAttribute("customer", customerService.getIdCustomer(id));
        model.addAttribute("kota", kotaService.listKota());
        return "formCustomer";
    }

    @RequestMapping ( value = "/customer/hapus/{id}" )
    public String hapus(@PathVariable String id) {
        customerService.hapus(id);
        return "redirect:/customer";
    }

}
