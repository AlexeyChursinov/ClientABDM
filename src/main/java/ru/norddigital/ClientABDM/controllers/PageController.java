package ru.norddigital.ClientABDM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/getIssoInfo")
    public String getIssoInfo() {
        return "getIssoInfo";
    }

}
