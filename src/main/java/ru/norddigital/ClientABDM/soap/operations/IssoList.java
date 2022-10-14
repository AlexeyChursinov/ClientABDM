package ru.norddigital.ClientABDM.soap.operations;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

@EqualsAndHashCode(callSuper = true)
@Data
public class IssoList extends IssoOperations implements ISoapOperations{

    private String road;
    private String upr;
    private String region;

    @Override
    public SOAPBody createSoapBody(SOAPEnvelope envelope, String namespace) throws SOAPException {
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetIssoList", namespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("Road", namespace);
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("Upr", namespace);
        SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Region", namespace);
        soapBodyElem1.addTextNode(road);
        soapBodyElem2.addTextNode(upr);
        soapBodyElem3.addTextNode(region);

        return soapBody;
    }
}
