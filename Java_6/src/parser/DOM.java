package parser;

import book.*;
import booklet.Booklet;
import edition.Edition;
import library.Library;
import magazine.Magazine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class DOM {
    public Library ed;

    public void startParser(String filePath) throws Exception {
        File xmlFile = new File(filePath);
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder;
        try {
            builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlFile);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++) {//коллекция узов
                Book bk = new Book();
                Type tp = null;
                bk.setAuthor(nodeList.item(i).getAttributes().getNamedItem("author").getNodeValue());
                bk.setName(nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue());
                bk.setYear(parseInt(nodeList.item(i).getAttributes().getNamedItem("year").getNodeValue()));
                bk.setNumber_of_pages(parseInt(nodeList.item(i).getAttributes().getNamedItem("number_of_pages").getNodeValue()));
                bk.seCost(parseInt(nodeList.item(i).getAttributes().getNamedItem("cost").getNodeValue()));
                bk.setUDK(parseInt(nodeList.item(i).getAttributes().getNamedItem("UDK").getNodeValue()));
                //Book.Publisher publ = bk.createPubl(nodeList.item(i).getAttributes().getNamedItem("publ").getNodeValue());
                switch(nodeList.item(i).getAttributes().getNamedItem("type").getNodeValue()){
                    case "sience":{
                        bk.bookType = tp.SCIENCE;
                    }break;
                    case "belletre":{
                        bk.bookType = tp.BELLETRE;
                    }break;
                    case "phantasy":{
                        bk.bookType = tp.PHANTASY;
                    }break;
                    case "sience_fiction":{
                        bk.bookType = tp.SCIENCE_FICTION;
                    }break;
                    default:{
                    }
                }
                ed.AddEdition(bk);
            }
            NodeList ndlst = document.getElementsByTagName("booklet");
            for (int i = 0; i < ndlst.getLength(); i++) {//коллекция узов
                Booklet bklt = new Booklet();
                bklt.setAuthor(nodeList.item(i).getAttributes().getNamedItem("author").getNodeValue());
                bklt.setName(nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue());
                bklt.setYear(parseInt(nodeList.item(i).getAttributes().getNamedItem("year").getNodeValue()));
                bklt.setNumber_of_pages(parseInt(nodeList.item(i).getAttributes().getNamedItem("number_of_pages").getNodeValue()));
                bklt.seCost(parseInt(nodeList.item(i).getAttributes().getNamedItem("cost").getNodeValue()));
                ed.AddEdition(bklt);
            }
            NodeList node = document.getElementsByTagName("magazine");
            for (int i = 0; i < node.getLength(); i++) {//коллекция узов
                Magazine mgzn = new Magazine();
                mgzn.setAuthor(nodeList.item(i).getAttributes().getNamedItem("author").getNodeValue());
                mgzn.setName(nodeList.item(i).getAttributes().getNamedItem("name").getNodeValue());
                mgzn.setYear(parseInt(nodeList.item(i).getAttributes().getNamedItem("year").getNodeValue()));
                mgzn.setNumber_of_pages(parseInt(nodeList.item(i).getAttributes().getNamedItem("number_of_pages").getNodeValue()));
                mgzn.seCost(parseInt(nodeList.item(i).getAttributes().getNamedItem("cost").getNodeValue()));
                mgzn.setCirculation(parseInt(nodeList.item(i).getAttributes().getNamedItem("circulation").getNodeValue()));
                ed.AddEdition(mgzn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}