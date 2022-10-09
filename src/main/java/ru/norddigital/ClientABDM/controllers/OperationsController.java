package ru.norddigital.ClientABDM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.norddigital.ClientABDM.service.OperationsService;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;

@Controller
public class OperationsController {

    OperationsService operationsService;

    @Autowired
    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @PostMapping("/getIssoInfo")
    public String sendRequest(@ModelAttribute("issoInfo") IssoInfo issoInfo) {

        operationsService.sendRequest(issoInfo);
        operationsService.getResponse(issoInfo);

        return "getIssoInfo";
    }

}
