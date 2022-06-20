package com.hrm.xml.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleSAXUserHandler extends DefaultHandler {
    @Override
    public void startDocument() throws SAXException {
        System.out.println("START Document");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.println("START Element: " + qName);
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("CHARS: " + new String(ch, start, length));
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        System.out.println("END Element: " + qName);
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("END Document");
    }

}
