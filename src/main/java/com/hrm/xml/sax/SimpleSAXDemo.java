package com.hrm.xml.sax;

import com.hrm.xml.Data;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class SimpleSAXDemo {
    private static final SimpleSAXUserHandler handler = new SimpleSAXUserHandler();

    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();


        InputStream in = new ByteArrayInputStream(Data.simpleUsersXml.getBytes());
        parser.parse(in, handler);
    }

}
