package ru.norddigital.ClientABDM.soap.operations;

import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;

public interface SoapBodyOperations {
    SOAPBody createSoapBody(SOAPEnvelope envelope, String Namespace) throws SOAPException;
}
