package ru.norddigital.ClientABDM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.norddigital.ClientABDM.service.IssoInfoService;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;

@Controller
public class OperationsController {

    IssoInfoService issoInfoService;

    @Autowired
    public OperationsController(IssoInfoService issoInfoService) {
        this.issoInfoService = issoInfoService;
    }

    @PostMapping("/getIssoInfo")
    public String sendRequest(@ModelAttribute("issoInfo") IssoInfo issoInfo) {

        issoInfoService.sendRequest(issoInfo);
        issoInfoService.getResponse(issoInfo);

        return "getIssoInfo";
    }

}
