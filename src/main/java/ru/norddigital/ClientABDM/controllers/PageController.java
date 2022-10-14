package ru.norddigital.ClientABDM.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;
import ru.norddigital.ClientABDM.soap.operations.IssoList;

@Controller
public class PageController {

    @GetMapping("/")
    public String getMainPage() {
        return "index";
    }

    @GetMapping("/error")
    public String getErrorPage() {
        return "error";
    }

    @GetMapping("/getIssoInfo")
    public String getIssoInfo(@ModelAttribute("issoInfo") IssoInfo issoInfo) {
        return "getIssoInfo";
    }

    @GetMapping("/getIssoList")
    public String getIssoInfoList(@ModelAttribute("issoList") IssoList issoList) {
        return "getIssoList";
    }

}
