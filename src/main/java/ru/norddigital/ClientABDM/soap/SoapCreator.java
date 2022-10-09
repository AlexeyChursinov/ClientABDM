package ru.norddigital.ClientABDM.soap;

import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;

import javax.xml.soap.*;

public class SoapCreator {

    public static void createSoapEnvelope(SOAPMessage soapMessage, ISoapOperations soapOperation) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String namespace = "tem";
        String namespaceURI = "http://tempuri.org/";

        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(namespace, namespaceURI);

        soapOperation.createSoapBody(envelope, namespace);

    }

    public static SOAPMessage createSOAPRequest(String soapAction, ISoapOperations soapOperation) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage, soapOperation);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

}
