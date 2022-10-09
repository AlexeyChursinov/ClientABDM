package ru.norddigital.ClientABDM.soap.responseData;

import org.w3c.dom.Document;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;

public interface IResponseData {
    void getResponseData(Document soapDocument, ISoapOperations soapOperation);
}
