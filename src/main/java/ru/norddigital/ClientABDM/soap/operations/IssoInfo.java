package ru.norddigital.ClientABDM.soap.operations;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.soap.*;

@EqualsAndHashCode(callSuper = true)
@Data
public class IssoInfo extends IssoOperations implements ISoapOperations {

    private String cIssoField;

    @Override
    public SOAPBody createSoapBody(SOAPEnvelope envelope, String namespace) throws SOAPException {
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetIssoInfo", namespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("cIsso", namespace);
        soapBodyElem1.addTextNode(cIssoField);

        return soapBody;
    }

}
