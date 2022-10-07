package ru.norddigital.ClientABDM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;

@Controller
public class PageController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/getIssoInfo")
    public String getIssoInfo(@ModelAttribute("issoInfo") IssoInfo issoInfo) {
        return "getIssoInfo";
    }

}
