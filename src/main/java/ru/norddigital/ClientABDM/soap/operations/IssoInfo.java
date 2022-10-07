package ru.norddigital.ClientABDM.soap.operations;

import lombok.Data;

import javax.xml.soap.*;

@Data
public class IssoInfo implements SoapBodyOperations{

    private String cIssoField; //5500934

    private String barrierName;

    @Override
    public SOAPBody createSoapBody(SOAPEnvelope envelope, String namespace) throws SOAPException {
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetIssoInfo", namespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("cIsso", namespace);
        soapBodyElem1.addTextNode(cIssoField);

        return soapBody;
    }

}
