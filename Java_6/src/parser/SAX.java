package parser;

import book.*;
import booklet.*;
import edition.*;
import library.*;
import magazine.*;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import static java.lang.Integer.parseInt;

public class SAX extends DefaultHandler {
    Library ed = new Library();
    Book bk;
    Booklet bklt;
    Magazine mgzn;

    String thisElement = "";
    //начинает метод работать когда начинаем парсить
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }
    // срабатывает когда находится тег(элемент)
    //значения пространства имен, локальное имя, составное имя, объект класса атрибут(возвращает сведения об атрибутах тега)
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        switch (thisElement){
            case "library":{
                ed = new Library();
                ed.setName(atts.getValue("name0"));
            }break;
            case "book":{
                switch(atts.getValue("type")){
                    case "science":{
                        ed.AddEdition(new Book(atts.getValue("name2"), atts.getValue("author2"), parseInt(atts.getValue("year2")), parseInt(atts.getValue("number_of_pages2"), 10), parseInt(atts.getValue("cost2"), 10), parseInt(atts.getValue("UDK"), 10), atts.getValue("publ"), Type.SCIENCE));
                    }break;
                    case "belletre":{
                        ed.AddEdition(new Book(atts.getValue("name2"), atts.getValue("author2"), parseInt(atts.getValue("year2")), parseInt(atts.getValue("number_of_pages2"), 10), parseInt(atts.getValue("cost2"), 10), parseInt(atts.getValue("UDK"), 10), atts.getValue("publ"), Type.BELLETRE));
                    }break;
                    case "phantasy":{
                        ed.AddEdition(new Book(atts.getValue("name2"), atts.getValue("author2"), parseInt(atts.getValue("year2")), parseInt(atts.getValue("number_of_pages2"), 10), parseInt(atts.getValue("cost2"), 10), parseInt(atts.getValue("UDK"), 10), atts.getValue("publ"), Type.PHANTASY));
                    }break;
                    case "sience_fiction":{
                        ed.AddEdition(new Book(atts.getValue("name2"), atts.getValue("author2"), parseInt(atts.getValue("year2")), parseInt(atts.getValue("number_of_pages2"), 10), parseInt(atts.getValue("cost2"), 10), parseInt(atts.getValue("UDK"), 10), atts.getValue("publ"), Type.SCIENCE_FICTION));
                    }break;
                    default:{
                    }
                  }

            }break;
            case "booklet":{
                ed.AddEdition(new Booklet(atts.getValue("name1"), atts.getValue("author1"), parseInt(atts.getValue("year1")), parseInt(atts.getValue("number_of_pages1"), 10), parseInt(atts.getValue("cost1"), 10)));
        }break;
            case "magazine":{
                ed.AddEdition(new Magazine(atts.getValue("name3"), atts.getValue("author3"), parseInt(atts.getValue("year3")), parseInt(atts.getValue("number_of_pages3"), 10), parseInt(atts.getValue("cost3"), 10), parseInt(atts.getValue("circulation"), 10)));
            }break;
            default:{
            }
        }
    }
    //когда закончили читать элемент
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        thisElement = "";
    }
     // противоположность start - закончили парсить весь документ
    @Override
    public void endDocument() {
        System.out.println("end parsing");
    }

    public Library getResult() {
        return ed;
    }

    //набор символов, от start до length то что внутри тега
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {

    }
}
