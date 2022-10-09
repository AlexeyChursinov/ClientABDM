package ru.norddigital.ClientABDM.soap;

import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;
import ru.norddigital.ClientABDM.utils.UtilsXML;

import javax.xml.soap.SOAPConnection;
import javax.xml.soap.SOAPConnectionFactory;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayOutputStream;

public class SoapSender {

    public static Document sendRequestAndGetResponse(String soapEndpointUrl, String soapAction, ISoapOperations soapOperation) {
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

            System.out.println("Response SOAP Message:\n" + responseMsg);
            System.out.println("\n");

        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }

        Document document = UtilsXML.convertStringToXMLDocument(responseMsg);

        return document;
    }

}
