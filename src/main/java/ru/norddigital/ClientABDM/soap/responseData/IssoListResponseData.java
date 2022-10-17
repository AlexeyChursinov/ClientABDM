package ru.norddigital.ClientABDM.soap.responseData;

import lombok.Data;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import ru.norddigital.ClientABDM.soap.operations.ISoapOperations;
import ru.norddigital.ClientABDM.soap.operations.IssoList;
import ru.norddigital.ClientABDM.utils.SoapParser;
import ru.norddigital.ClientABDM.utils.UtilsXML;

import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class IssoListResponseData implements IResponseData {

    List<IssoList> issoLists;

    @Override
    public void getResponseData(Document soapDocument, ISoapOperations soapOperation) {

        String errorResponseMessage = null;

        IssoList issoList;
        issoList = (IssoList) soapOperation;

        String response = UtilsXML.documentToString(soapDocument);
        Node rootNode = SoapParser.getSoapBody(response);
//        System.out.println("Root Element: " + rootNode.getNodeName());

        issoList.setErrorResponseMessage(SoapParser.parseFaultString(rootNode, null));

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

        issoLists = new ArrayList<>();

        for (int i = 0; i < nodeChilds.getLength(); i++) {

            if (nodeChilds.item(i).getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            NodeList childElements = nodeChilds.item(i).getChildNodes();
            IssoList issoListNode = new IssoList();

            for (int j = 0; j < childElements.getLength(); j++) {


                switch (childElements.item(j).getNodeName()) {
                    case "a:BarrierName": {
                        barrierName = childElements.item(j).getTextContent();
                        System.out.println("BarrierName = " + barrierName);
                        issoListNode.setBarrierName(barrierName);
                        break;
                    }
                    case "a:BuildOrg": {
                        buildOrg = childElements.item(j).getTextContent();
                        System.out.println("BuildOrg = " + buildOrg);
                        issoListNode.setBuildOrg(buildOrg);
                        break;
                    }
                    case "a:BuildYear": {
                        buildYear = childElements.item(j).getTextContent();
                        System.out.println("BuildYear = " + buildYear);
                        issoListNode.setBuildYear(buildYear);
                        break;
                    }
                    case "a:City": {
                        city = childElements.item(j).getTextContent();
                        System.out.println("City = " + city);
                        issoListNode.setCity(city);
                        break;
                    }
                    case "a:Description": {
                        description = childElements.item(j).getTextContent();
                        System.out.println("Description = " + description);
                        issoListNode.setDescription(description);
                        break;
                    }
                    case "a:Dist": {
                        dist = childElements.item(j).getTextContent();
                        System.out.println("Dist = " + dist);
                        issoListNode.setDist(dist);
                        break;
                    }
                    case "a:ExamOrg": {
                        examOrg = childElements.item(j).getTextContent();
                        System.out.println("ExamOrg = " + examOrg);
                        issoListNode.setExamOrg(examOrg);
                        break;
                    }
                    case "a:ID": {
                        id = childElements.item(j).getTextContent();
                        System.out.println("ID = " + id);
                        issoListNode.setId(id);
                        break;
                    }
                    case "a:ID2": {
                        id2 = childElements.item(j).getTextContent();
                        System.out.println("ID2 = " + id2);
                        issoListNode.setId2(id2);
                        break;
                    }
                    case "a:IssoSuperType": {
                        issoSuperType = childElements.item(j).getTextContent();
                        System.out.println("IssoSuperType = " + issoSuperType);
                        issoListNode.setIssoSuperType(issoSuperType);
                        break;
                    }
                    case "a:IssoType": {
                        issoType = childElements.item(j).getTextContent();
                        System.out.println("IssoType = " + issoType);
                        issoListNode.setIssoType(issoType);
                        break;
                    }
                    case "a:Kak": {
                        kak = childElements.item(j).getTextContent();
                        System.out.println("Kak = " + kak);
                        issoListNode.setKak(kak);
                        break;
                    }
                    case "a:Kn3": {
                        kn3 = childElements.item(j).getTextContent();
                        System.out.println("Kn3 = " + kn3);
                        issoListNode.setKn3(kn3);
                        break;
                    }
                    case "a:Knk": {
                        knk = childElements.item(j).getTextContent();
                        System.out.println("Knk = " + knk);
                        issoListNode.setKnk(knk);
                        break;
                    }
                    case "a:Length": {
                        length = childElements.item(j).getTextContent();
                        System.out.println("Length = " + length);
                        issoListNode.setLength(length);
                        break;
                    }
                    case "a:Location": {
                        location = childElements.item(j).getTextContent();
                        System.out.println("Location = " + location);
                        issoListNode.setLocation(location);
                        break;
                    }
                    case "a:Obst": {
                        obst = childElements.item(j).getTextContent();
                        System.out.println("Obst = " + obst);
                        issoListNode.setObst(obst);
                        break;
                    }
                    case "a:OperOrg": {
                        operOrg = childElements.item(j).getTextContent();
                        System.out.println("OperOrg = " + operOrg);
                        issoListNode.setOperOrg(operOrg);
                        break;
                    }
                    case "a:Plan": {
                        plan = childElements.item(j).getTextContent();
                        System.out.println("Plan = " + plan);
                        issoListNode.setPlan(plan);
                        break;
                    }
                    case "a:ProOrg": {
                        proOrg = childElements.item(j).getTextContent();
                        System.out.println("ProOrg = " + proOrg);
                        issoListNode.setProOrg(proOrg);
                        break;
                    }
                    case "a:Raiting": {
                        raiting = childElements.item(j).getTextContent();
                        System.out.println("Raiting = " + raiting);
                        issoListNode.setRaiting(raiting);
                        break;
                    }
                    case "a:RaitingDate": {
                        raitingDate = childElements.item(j).getTextContent();
                        System.out.println("RaitingDate = " + raitingDate);
                        issoListNode.setRaitingDate(raitingDate);
                        break;
                    }
                    case "a:Region": {
                        region = childElements.item(j).getTextContent();
                        System.out.println("Region = " + region);
                        issoListNode.setRegion(region);
                        break;
                    }
                    case "a:Road": {
                        road = childElements.item(j).getTextContent();
                        System.out.println("Road = " + road);
                        issoListNode.setRoad(road);
                        break;
                    }
                    case "a:RoadKategory": {
                        roadKategory = childElements.item(j).getTextContent();
                        System.out.println("RoadKategory = " + roadKategory);
                        issoListNode.setRoadKategory(roadKategory);
                        break;
                    }
                    case "a:Strain": {
                        strain = childElements.item(j).getTextContent();
                        System.out.println("Strain = " + strain);
                        issoListNode.setStrain(strain);
                        break;
                    }
                    case "a:Upr": {
                        upr = childElements.item(j).getTextContent();
                        System.out.println("Upr = " + upr);
                        issoListNode.setUpr(upr);
                        break;
                    }
                    case "a:Width": {
                        width = childElements.item(j).getTextContent();
                        System.out.println("Width = " + width);
                        issoListNode.setWidth(width);
                        break;
                    }
                }
            }
            issoLists.add(issoListNode);
        }
    }
}
