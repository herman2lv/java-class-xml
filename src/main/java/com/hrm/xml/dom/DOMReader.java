package com.hrm.xml.dom;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.hrm.xml.User;
import com.hrm.xml.User.Role;

public class DOMReader {
    
    public List<User> deserialize(InputStream in) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(in);

            List<User> users = new ArrayList<>();
            Element root = document.getDocumentElement();
//            NodeList nodes = root.getChildNodes();
//            System.out.println(nodes.getLength());
            NodeList nodes = root.getElementsByTagName("user");
            for (int i = 0; i < nodes.getLength(); i++) {
                Element userElm = (Element) nodes.item(i);
                User user = processUserElement(userElm);
                users.add(user);
            }
            
            return users;
        } catch (ParserConfigurationException | SAXException | IOException e) {
            throw new RuntimeException(e);
        }
    }
    
    //Before refactoring
//    private User processUserElement(Element userElm) {
//        User user = new User();
//
//        String rawId = userElm.getAttribute("id");
//        Long id = Long.parseLong(rawId);
//        user.setId(id);
//
//        Element firstNameElm = getElement(userElm, "firstName");
//        String firstName = firstNameElm.getTextContent();
//        user.setFirstName(firstName);
//
//        Element lastNameElm = getElement(userElm, "lastName");
//        String lastName = lastNameElm.getTextContent();
//        user.setFirstName(lastName);
//        
//        Element ageElm = getElement(userElm, "age");
//        String rawAge = ageElm.getTextContent();
//        Integer age = Integer.parseInt(rawAge);
//        user.setAge(age);
//        
//        Element roleElm = getElement(userElm, "role");
//        String rawRole = roleElm.getTextContent();
//        Role role = Role.valueOf(rawRole);
//        user.setRole(role);
//        
//        return user;
//    }
    
    private Element getElement(Element parent, String tag) {
        return (Element) parent.getElementsByTagName(tag).item(0);
    }

    //After refactoring
    private User processUserElement(Element userElm) {
        User user = new User();
        user.setId(getId(userElm));
        user.setFirstName(getFirstName(userElm));
        user.setFirstName(getLastName(userElm));
        user.setAge(getAge(userElm));
        user.setRole(getRole(userElm));
        return user;
    }

    private Role getRole(Element userElm) {
        Element roleElm = getElement(userElm, "role");
        String rawRole = roleElm.getTextContent();
        Role role = Role.valueOf(rawRole);
        return role;
    }

    private Integer getAge(Element userElm) {
        Element ageElm = getElement(userElm, "age");
        String rawAge = ageElm.getTextContent();
        Integer age = Integer.parseInt(rawAge);
        return age;
    }

    private String getLastName(Element userElm) {
        Element lastNameElm = getElement(userElm, "lastName");
        String lastName = lastNameElm.getTextContent();
        return lastName;
    }

    private String getFirstName(Element userElm) {
        Element firstNameElm = getElement(userElm, "firstName");
        String firstName = firstNameElm.getTextContent();
        return firstName;
    }

    private Long getId(Element userElm) {
        String rawId = userElm.getAttribute("id");
        Long id = Long.parseLong(rawId);
        return id;
    }

}
