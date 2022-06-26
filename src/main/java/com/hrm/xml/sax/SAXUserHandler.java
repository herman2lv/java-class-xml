package com.hrm.xml.sax;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import com.hrm.xml.User;
import com.hrm.xml.User.Role;

public class SAXUserHandler extends DefaultHandler {

    private List<User> users;
    private User user;
    private String element;
    private StringBuilder text;

    public List<User> deserialize(InputStream is) {
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            parser.parse(is, this);
            return users;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        users = new ArrayList<>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        element = qName;
        switch (element) {
        case "users":
            break;
        case "user":
            user = new User();
            users.add(user);
            String rawId = attributes.getValue("id");
            Long id = Long.parseLong(rawId);
            user.setId(id);
            break;
        default:
            text = new StringBuilder();
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (text != null) {
            text.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String content = text.toString();
        switch (element) {
        case "firstName":
            user.setFirstName(content);
            break;
        case "lastName":
            user.setLastName(content);
            break;
        case "age":
            Byte age = Byte.parseByte(content);
            user.setAge(age);
            break;
        case "role":
            Role role = Role.valueOf(content);
            user.setRole(role);
            break;
        }
        element = "";
    }

    @Override
    public void endDocument() throws SAXException {
    }

    @Override
    public void warning(SAXParseException e) throws SAXException {
        System.out.println("WARNING: " + e.getMessage());
    }

    @Override
    public void error(SAXParseException e) throws SAXException {
        System.out.println("ERROR: " + e.getMessage());
    }

    @Override
    public void fatalError(SAXParseException e) throws SAXException {
        System.out.println("FATAL: " + e.getMessage());
    }
}
