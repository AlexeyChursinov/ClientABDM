package ru.norddigital.ClientABDM.utils;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;

import javax.xml.soap.MessageFactory;
import javax.xml.soap.MimeHeaders;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class SoapParser {

    private static Node getFirstElement(SOAPMessage message) throws SOAPException {
        final NodeList childNodes = message.getSOAPBody().getChildNodes();
        Node firstElement = null;
        for (int i = 0; i < childNodes.getLength(); i++) {
            if (childNodes.item(i) instanceof Element) {
                firstElement = childNodes.item(i);
                break;
            }
        }
        return firstElement;
    }

    private static SOAPMessage getSoapMessage(String xml) throws SOAPException, IOException {
        MessageFactory factory = MessageFactory.newInstance();
        final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(xml.getBytes(StandardCharsets.UTF_8));
        return factory.createMessage(new MimeHeaders(), byteArrayInputStream);
    }

    public static Node getSoapBody(String xml) {
        try {
            SOAPMessage message = getSoapMessage(xml);
            return getFirstElement(message);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String parseFaultString(Node rootNode, String errorResponseMessage) {
        if (rootNode.getNodeName().equals("s:Fault")) {
            NodeList nodeFaultChilds = rootNode.getChildNodes();
            for (int i = 0; i < nodeFaultChilds.getLength(); i++) {

                if (nodeFaultChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if ("faultstring".equals(nodeFaultChilds.item(i).getNodeName())) {
                    errorResponseMessage = nodeFaultChilds.item(i).getTextContent();
                    System.out.println("faultstring = " + errorResponseMessage);
                }
            }
        }
        return errorResponseMessage;
    }
}
