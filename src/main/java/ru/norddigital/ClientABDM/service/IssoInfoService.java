package ru.norddigital.ClientABDM.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.SoapSender;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;

@Service
public class IssoInfoService {

    @Value("${GetIssoInfo_endpointURI}")
    private String endpoint;

    @Value("${IssoInfo_SoapAction}")
    private String soapAction;

    public void sendRequest(IssoInfo IssoInfo) {
        Document responseSOAP = SoapSender.sendRequestAndGetResponse(endpoint, soapAction, IssoInfo);
    }

}
