package ru.norddigital.ClientABDM.soap.responseData;

import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.norddigital.ClientABDM.soap.operations.IssoInfo;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;
import ru.norddigital.ClientABDM.utils.SoapParser;
import ru.norddigital.ClientABDM.utils.UtilsXML;

@Component
public class IssoInfoResponseData implements IResponseData {

    @Override
    public void getResponseData(Document soapDucument, ISoapOperations soapOperation) {

        String errorResponseMessage = null;

        IssoInfo issoInfo;
        issoInfo = (IssoInfo) soapOperation;

        String response = UtilsXML.documentToString(soapDucument);
        Node rootNode = SoapParser.getSoapBody(response);
//        System.out.println("Root Element: " + rootNode.getNodeName());

        if (rootNode.getNodeName().equals("s:Fault")) {
            NodeList nodeFaultChilds = rootNode.getChildNodes();
            for (int i = 0; i < nodeFaultChilds.getLength(); i++) {

                if (nodeFaultChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                    continue;
                }

                if ("faultstring".equals(nodeFaultChilds.item(i).getNodeName())) {
                    errorResponseMessage = nodeFaultChilds.item(i).getTextContent();
                    System.out.println("faultstring = " + errorResponseMessage);
                    issoInfo.setErrorResponseMessage(errorResponseMessage);
                }
            }
        }

        Node rootNodeChild = rootNode.getFirstChild();
//        System.out.println("Child Root Element: " + rootNodeChild.getNodeName());

        NodeList nodeChilds = rootNodeChild.getChildNodes();

        String barrierName,
                buildOrg,
                buildYear,
                city,
                description,
                dist,
                examOrg,
                id,
                id2,
                issoSuperType,
                issoType,
                kak,
                kn3,
                knk,
                length,
                location,
                obst,
                operOrg,
                plan,
                proOrg,
                raiting,
                raitingDate,
                region,
                road,
                roadKategory,
                strain,
                upr,
                width = null;

        for (int i = 0; i < nodeChilds.getLength(); i++) {

            if (nodeChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

//            System.out.println("Child Element: " + nodeChilds.item(i).getNodeName());

            switch (nodeChilds.item(i).getNodeName()) {
                case "a:BarrierName": {
                    barrierName = nodeChilds.item(i).getTextContent();
                    System.out.println("BarrierName = " + barrierName);
                    issoInfo.setBarrierName(barrierName);
                    break;
                }
                case "a:BuildOrg": {
                    buildOrg = nodeChilds.item(i).getTextContent();
                    System.out.println("BuildOrg = " + buildOrg);
                    issoInfo.setBuildOrg(buildOrg);
                    break;
                }
                case "a:BuildYear": {
                    buildYear = nodeChilds.item(i).getTextContent();
                    System.out.println("BuildYear = " + buildYear);
                    issoInfo.setBuildYear(buildYear);
                    break;
                }
                case "a:City": {
                    city = nodeChilds.item(i).getTextContent();
                    System.out.println("City = " + city);
                    issoInfo.setCity(city);
                    break;
                }
                case "a:Description": {
                    description = nodeChilds.item(i).getTextContent();
                    System.out.println("Description = " + description);
                    issoInfo.setDescription(description);
                    break;
                }
                case "a:Dist": {
                    dist = nodeChilds.item(i).getTextContent();
                    System.out.println("Dist = " + dist);
                    issoInfo.setDist(dist);
                    break;
                }
                case "a:ExamOrg": {
                    examOrg = nodeChilds.item(i).getTextContent();
                    System.out.println("ExamOrg = " + examOrg);
                    issoInfo.setExamOrg(examOrg);
                    break;
                }
                case "a:ID": {
                    id = nodeChilds.item(i).getTextContent();
                    System.out.println("ID = " + id);
                    issoInfo.setId(id);
                    break;
                }
                case "a:ID2": {
                    id2 = nodeChilds.item(i).getTextContent();
                    System.out.println("ID2 = " + id2);
                    issoInfo.setId2(id2);
                    break;
                }
                case "a:IssoSuperType": {
                    issoSuperType = nodeChilds.item(i).getTextContent();
                    System.out.println("IssoSuperType = " + issoSuperType);
                    issoInfo.setIssoSuperType(issoSuperType);
                    break;
                }
                case "a:IssoType": {
                    issoType = nodeChilds.item(i).getTextContent();
                    System.out.println("IssoType = " + issoType);
                    issoInfo.setIssoType(issoType);
                    break;
                }
                case "a:Kak": {
                    kak = nodeChilds.item(i).getTextContent();
                    System.out.println("Kak = " + kak);
                    issoInfo.setKak(kak);
                    break;
                }
                case "a:Kn3": {
                    kn3 = nodeChilds.item(i).getTextContent();
                    System.out.println("Kn3 = " + kn3);
                    issoInfo.setKn3(kn3);
                    break;
                }
                case "a:Knk": {
                    knk = nodeChilds.item(i).getTextContent();
                    System.out.println("Knk = " + knk);
                    issoInfo.setKnk(knk);
                    break;
                }
                case "a:Length": {
                    length = nodeChilds.item(i).getTextContent();
                    System.out.println("Length = " + length);
                    issoInfo.setLength(length);
                    break;
                }
                case "a:Location": {
                    location = nodeChilds.item(i).getTextContent();
                    System.out.println("Location = " + location);
                    issoInfo.setLocation(location);
                    break;
                }
                case "a:Obst": {
                    obst = nodeChilds.item(i).getTextContent();
                    System.out.println("Obst = " + obst);
                    issoInfo.setObst(obst);
                    break;
                }
                case "a:OperOrg": {
                    operOrg = nodeChilds.item(i).getTextContent();
                    System.out.println("OperOrg = " + operOrg);
                    issoInfo.setOperOrg(operOrg);
                    break;
                }
                case "a:Plan": {
                    plan = nodeChilds.item(i).getTextContent();
                    System.out.println("Plan = " + plan);
                    issoInfo.setPlan(plan);
                    break;
                }
                case "a:ProOrg": {
                    proOrg = nodeChilds.item(i).getTextContent();
                    System.out.println("ProOrg = " + proOrg);
                    issoInfo.setProOrg(proOrg);
                    break;
                }
                case "a:Raiting": {
                    raiting = nodeChilds.item(i).getTextContent();
                    System.out.println("Raiting = " + raiting);
                    issoInfo.setRaiting(raiting);
                    break;
                }
                case "a:RaitingDate": {
                    raitingDate = nodeChilds.item(i).getTextContent();
                    System.out.println("RaitingDate = " + raitingDate);
                    issoInfo.setRaitingDate(raitingDate);
                    break;
                }
                case "a:Region": {
                    region = nodeChilds.item(i).getTextContent();
                    System.out.println("Region = " + region);
                    issoInfo.setRegion(region);
                    break;
                }
                case "a:Road": {
                    road = nodeChilds.item(i).getTextContent();
                    System.out.println("Road = " + road);
                    issoInfo.setRoad(road);
                    break;
                }
                case "a:RoadKategory": {
                    roadKategory = nodeChilds.item(i).getTextContent();
                    System.out.println("RoadKategory = " + roadKategory);
                    issoInfo.setRoadKategory(roadKategory);
                    break;
                }
                case "a:Strain": {
                    strain = nodeChilds.item(i).getTextContent();
                    System.out.println("Strain = " + strain);
                    issoInfo.setStrain(strain);
                    break;
                }
                case "a:Upr": {
                    upr = nodeChilds.item(i).getTextContent();
                    System.out.println("Upr = " + upr);
                    issoInfo.setUpr(upr);
                    break;
                }
                case "a:Width": {
                    width = nodeChilds.item(i).getTextContent();
                    System.out.println("Width = " + width);
                    issoInfo.setWidth(width);
                    break;
                }
            }
        }
    }
}
