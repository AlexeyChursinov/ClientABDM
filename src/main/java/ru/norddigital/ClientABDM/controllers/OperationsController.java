package ru.norddigital.ClientABDM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OperationsController {

    @RequestMapping("/getIssoInfoSendRequest")
    public String sendRequest(Model model) {


        return "redirect:/getIssoInfo";
    }

}
