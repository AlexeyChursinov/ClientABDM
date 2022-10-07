package ru.norddigital.ClientABDM.soap.responseData;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import ru.norddigital.ClientABDM.utils.SoapParser;
import ru.norddigital.ClientABDM.utils.UtilsXML;


public class IssoInfoResponseData {

    public static void getResponseData(Document responseSOAP) {
        String response = UtilsXML.documentToString(responseSOAP);
        Node rootNode = SoapParser.getSoapBody(response);
        System.out.println("Root Element: " + rootNode.getNodeName());
    }
}
