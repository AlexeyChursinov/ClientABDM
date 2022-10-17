package ru.norddigital.ClientABDM.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.SoapSender;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;

import static org.junit.jupiter.api.Assertions.*;

class OperationsServiceTest {

    private final String soapAction = "http://tempuri.org/Iais7WcfIntegrationAvtodor/GetIssoInfo";

    @BeforeEach
    void setUp() {
    }

    @Test
    void sendRequest_afterSendRequestSoapDocumentNotNull() {
        String endpoint = "http://10.10.1.13:9993/Ais7IntegrationAvtodor.Avtodor.Iais7WcfIntegrationAvtodor";
        Document soapDocument;
        IssoInfo soapOperation = new IssoInfo();
        soapOperation.setCIssoField("3500086");

        soapDocument = SoapSender.sendRequestAndGetResponse(endpoint, soapAction, soapOperation);
        assertNotNull(soapDocument);
    }

    @Test
    void sendRequest_whenSendRequestWithIncorrectEndpointThenSoapDocumentNull() {
        String endpoint = "http://10.10.1.13:9993/wrongUrl";
        Document soapDocument;
        IssoInfo soapOperation = new IssoInfo();
        soapOperation.setCIssoField("3500086");

        soapDocument = SoapSender.sendRequestAndGetResponse(endpoint, soapAction, soapOperation);
        assertNull(soapDocument);
    }

    @Test
    void getResponse() {
    }
}