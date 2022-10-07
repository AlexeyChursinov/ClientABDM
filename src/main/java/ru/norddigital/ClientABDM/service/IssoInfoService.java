package ru.norddigital.ClientABDM.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.SoapSender;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;
import ru.norddigital.ClientABDM.soap.responseData.IssoInfoResponseData;

@Service
public class IssoInfoService {

    @Value("${GetIssoInfo_endpointURI}")
    private String endpoint;

    @Value("${IssoInfo_SoapAction}")
    private String soapAction;

    private Document responseSOAP;

    public void sendRequest(IssoInfo IssoInfo) {
        responseSOAP = SoapSender.sendRequestAndGetResponse(endpoint, soapAction, IssoInfo);
    }

    public void getResponse() {
        IssoInfoResponseData.getResponseData(responseSOAP);
    }

}