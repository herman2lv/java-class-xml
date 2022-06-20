package com.hrm.xml.sax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.hrm.xml.Data;

public class SimpleSAXDemo {
    private static final SimpleSAXUserHandler handler = new SimpleSAXUserHandler();
    
    public static void main(String[] args) throws Exception {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        
        
        InputStream in = new ByteArrayInputStream(Data.simpleUsersXml.getBytes());
        parser.parse(in, handler);
    }

}
