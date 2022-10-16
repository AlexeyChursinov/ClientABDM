package ru.norddigital.ClientABDM.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.SoapSender;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;
import ru.norddigital.ClientABDM.soap.responseData.IResponseData;

@Service
public class OperationsService {
    @Value("${GetIssoInfo_endpointURI}")
    private String endpoint;

    private Document soapDocument;

    public void sendRequest(ISoapOperations soapOperation, String soapAction) {
        soapDocument = SoapSender.sendRequestAndGetResponse(endpoint, soapAction, soapOperation);
    }

    public void getResponse(ISoapOperations soapOperation, IResponseData responseData) {
        responseData.getResponseData(soapDocument, soapOperation);
    }
}
