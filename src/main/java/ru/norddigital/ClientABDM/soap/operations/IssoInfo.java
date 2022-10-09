package ru.norddigital.ClientABDM.soap.operations;

import lombok.Data;

import javax.xml.soap.*;

@Data
public class IssoInfo implements ISoapOperations {

    private String cIssoField; //5500934

    private String barrierName;
    private String buildOrg;
    private String buildYear;
    private String city;
    private String description;
    private String dist;
    private String examOrg;
    private String id;
    private String id2;
    private String issoSuperType;
    private String issoType;
    private String kak;
    private String kn3;
    private String knk;
    private String length;
    private String location;
    private String obst;
    private String operOrg;
    private String plan;
    private String proOrg;
    private String raiting;
    private String raitingDate;
    private String region;
    private String road;
    private String roadKategory;
    private String strain;
    private String upr;
    private String width;

    @Override
    public SOAPBody createSoapBody(SOAPEnvelope envelope, String namespace) throws SOAPException {
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("GetIssoInfo", namespace);
        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement("cIsso", namespace);
        soapBodyElem1.addTextNode(cIssoField);

        return soapBody;
    }

}
