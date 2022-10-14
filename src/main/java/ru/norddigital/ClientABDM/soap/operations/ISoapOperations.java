package ru.norddigital.ClientABDM.soap.operations;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

public interface ISoapOperations {
    SOAPBody createSoapBody(SOAPEnvelope envelope, String namespace) throws SOAPException;
}
