package ru.norddigital.ClientABDM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.norddigital.ClientABDM.service.OperationsService;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;
import ru.norddigital.ClientABDM.soap.operations.IssoList;

@Controller
public class OperationsController {

    @Value("${IssoInfo_SoapAction}")
    private String soapActionIssoInfo;

    @Value("${IssoList_SoapAction}")
    private String soapActionIssoList;

    OperationsService operationsService;

    @Autowired
    public OperationsController(OperationsService operationsService) {
        this.operationsService = operationsService;
    }

    @PostMapping("/getIssoInfo")
    public String sendRequest(@ModelAttribute("issoInfo") IssoInfo issoInfo) {

        operationsService.sendRequest(issoInfo, soapActionIssoInfo);
        operationsService.getResponse(issoInfo);

        return "getIssoInfo";
    }

    @PostMapping("/getIssoList")
    public String sendRequest(@ModelAttribute("issoList") IssoList issoList) {

        operationsService.sendRequest(issoList, soapActionIssoList);
//        operationsService.getResponse(issoList);

        return "getIssoList";
    }

}
