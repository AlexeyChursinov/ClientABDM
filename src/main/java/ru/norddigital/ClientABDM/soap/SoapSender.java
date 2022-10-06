package ru.norddigital.ClientABDM.soap;

import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.operations.SoapBodyOperations;
import ru.norddigital.ClientABDM.utils.UtilsXML;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;

public class SoapSender {

    public static String callSoapWebService(String soapEndpointUrl, String soapAction, SoapBodyOperations soapOperation) {
        String responseMsg = "";
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapResponse = soapConnection.call(SoapCreator.createSOAPRequest(soapAction, soapOperation), soapEndpointUrl);

            //SOAPMessage to String
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            soapResponse.writeTo(out);
            responseMsg = new String(out.toByteArray());

            soapConnection.close();

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }

        return responseMsg;
    }

    public static Document sendRequestAndGetResponse(String soapEndpointUrl, String soapAction, SoapBodyOperations soapOperation) {

        String responseSOAP = callSoapWebService(soapEndpointUrl, soapAction, soapOperation);
        System.out.println("Response SOAP Message:\n" + responseSOAP);
        System.out.print("==========");
        System.out.println("\n");

        Document document = UtilsXML.convertStringToXMLDocument(responseSOAP);

        return document;
    }

}
