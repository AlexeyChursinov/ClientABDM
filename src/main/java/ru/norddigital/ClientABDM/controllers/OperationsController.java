package ru.norddigital.ClientABDM.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ru.norddigital.ClientABDM.service.OperationsService;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;
import ru.norddigital.ClientABDM.soap.operations.IssoList;
import ru.norddigital.ClientABDM.soap.responseData.IssoInfoResponseData;
import ru.norddigital.ClientABDM.soap.responseData.IssoListResponseData;

@Controller
public class OperationsController {

    @Value("${IssoInfo_SoapAction}")
    private String soapActionIssoInfo;

    @Value("${IssoList_SoapAction}")
    private String soapActionIssoList;

    private final OperationsService operationsService;
    private final IssoInfoResponseData issoInfoResponseData;
    private final IssoListResponseData issoListResponseData;

    @Autowired
    public OperationsController(OperationsService operationsService, IssoInfoResponseData issoInfoResponseData, IssoListResponseData issoListResponseData) {
        this.operationsService = operationsService;
        this.issoInfoResponseData = issoInfoResponseData;
        this.issoListResponseData = issoListResponseData;
    }

    @PostMapping("/getIssoInfo")
    public String sendRequest(@ModelAttribute("issoInfo") IssoInfo issoInfo) {

        operationsService.sendRequest(issoInfo, soapActionIssoInfo);
        operationsService.getResponse(issoInfo, issoInfoResponseData);

        return "getIssoInfo";
    }

    @PostMapping("/getIssoList")
    public String sendRequest(@ModelAttribute("issoList") IssoList issoList) {

        operationsService.sendRequest(issoList, soapActionIssoList);
        operationsService.getResponse(issoList, issoListResponseData);

        return "getIssoList";
    }

}
