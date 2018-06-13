package com.company;

import book.Book;
import book.Type;
import booklet.Booklet;
import com.google.gson.reflect.TypeToken;
import edition.Edition;
import librarian.Librarian;
import library.Library;
import magazine.Magazine;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.xml.sax.SAXException;
import parser.SAX;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.*;
import java.util.*;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import parser.ValidatorSAX;

public class Main {

    static {
        new DOMConfigurator().doConfigure("log/log4j.xml",
                LogManager.getLoggerRepository());
    }

    private static final Logger LOG = Logger.getLogger(Main.class);

    public static void main(String[] args) {
	// write your code here
        try
        {
            //SAX parser - находит самый первый тег -> второй -> ... назад не возвращается
            //проходит один раз
            //способ последовательного чтения xmlфайлов
            //simple api for xml
            LOG.info("Start Sax parsing");
            System.out.println("SAX parsing");
            SAXParserFactory factory = SAXParserFactory.newInstance();//получаем новый экземпляр
            SAXParser parser = factory.newSAXParser();
            SAX sax = new SAX();
            parser.parse(new File("files/info.xml"), sax);
            Library lb = sax.getResult();
            for(Edition ed : lb.GetLibrary())
            {
                System.out.println(ed.toString());
            }

            //XMLtoHTML
            LOG.info("Transform XML to HTML");
            TransformerFactory xstf = TransformerFactory.newInstance();
            Transformer transformer = null;
            //преобразуем xml по схеме xsl
            transformer=xstf.newTransformer(new StreamSource("files/XSL.xsl"));
            //преобразует исходное дерево в дерево результата
            transformer.transform(new StreamSource("files/XMLtoHTML.xml"), new StreamResult("files/info.html"));

            //serialization
            //запись байтов в файл
            FileOutputStream out = new FileOutputStream("files/serializ.xml");
            XMLEncoder xmlEncoder = new XMLEncoder(out);
            xmlEncoder.writeObject(lb.GetLibrary().get(1));
            xmlEncoder.close();

            //DEserialization
            System.out.println("DeSerializ");
            FileInputStream in = new FileInputStream("files/serializ.xml");
            XMLDecoder xmlDecoder = new XMLDecoder(in);
            Booklet bklt = (Booklet) xmlDecoder.readObject();
            xmlDecoder.close();
            System.out.println(bklt.getName() + " " + bklt.getAuthor());

           //json
            System.out.println("toJSON");
            Collection collection = new ArrayList<Booklet>();
            collection.add(lb.GetLibrary().get(1));
            collection.add(lb.GetLibrary().get(1));

            for(Object ed : collection)
            {
                System.out.println(ed.toString());
            }

            GsonBuilder gsonBuilder = new GsonBuilder();
            Gson gson = gsonBuilder.create();
            String string = gson.toJson(collection);



            try (FileWriter fileWriter = new FileWriter("files/toJSON.json")) {
                fileWriter.write(string);
            } catch (IOException ex) {

            }

            FileReader isr = new FileReader("files/toJSON.json");
            Gson gsn = new Gson();
            StringBuilder dt = new StringBuilder();
            int c;
            while ((c = isr.read()) != -1)
            {
                dt.append((char) c);
            }
            ArrayList<Booklet> collect = gsn.fromJson(string.toString(), new TypeToken<List<Booklet>>(){}.getType());
            // System.out.println(collect.get(0).toString());
            for (Booklet b: collect)
            {
                System.out.println(b.toString());
            }


        }
        catch (NullPointerException e) {
            System.out.println(e.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

