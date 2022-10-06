package ru.norddigital.ClientABDM.soap;

import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.operations.GetIssoInfo;

public class TestSendSoap {

    public static void main(String[] args) {

        Document responseSOAP = SoapSender.sendRequestAndGetResponse(
                "http://10.10.1.13:9993/Ais7IntegrationAvtodor.Avtodor.Iais7WcfIntegrationAvtodor",
                "http://tempuri.org/Iais7WcfIntegrationAvtodor/GetIssoInfo",
                new GetIssoInfo());

        System.out.println("response = " + responseSOAP);
    }
}
