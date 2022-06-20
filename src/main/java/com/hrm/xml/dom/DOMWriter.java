package com.hrm.xml.dom;

import java.io.OutputStream;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.hrm.xml.User;

public class DOMWriter {
    public Document createDocument(List<User> users) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();
            Element root = document.createElement("users");
            document.appendChild(root);

            users.forEach((user) -> {
                serializeUser(document, user, root);
            });

            return document;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void serialize(Document document, OutputStream out, boolean prettyFormat) {
        try {
            TransformerFactory tFactory = TransformerFactory.newInstance();
            Transformer transformer = tFactory.newTransformer();
            if (prettyFormat) {
                transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            }
            transformer.transform(new DOMSource(document), new StreamResult(out));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

//    private void serializeUser(Document document, User user, Element root) {
//        Element userElm = document.createElement("user");
//        root.appendChild(userElm);
//        userElm.setAttribute("id", String.valueOf(user.getId()));
//
//        Element firstNameElm = document.createElement("firstName");
//        userElm.appendChild(firstNameElm);
//        firstNameElm.setTextContent(user.getFirstName());
//
//        Element lastNameElm = document.createElement("lastName");
//        userElm.appendChild(lastNameElm);
//        lastNameElm.setTextContent(user.getLastName());
//        
//        Element ageElm = document.createElement("age");
//        userElm.appendChild(ageElm);
//        ageElm.setTextContent(String.valueOf(user.getAge()));
//        
//        Element roleElm = document.createElement("role");
//        userElm.appendChild(roleElm);
//        roleElm.setTextContent(user.getRole().toString());
//    }

    private void serializeUser(Document document, User user, Element root) {
        Element userElm = createUserElement(document, user, root);
        processId(user, userElm);
        processFirstName(document, user, userElm);
        processLastName(document, user, userElm);
        processAge(document, user, userElm);
        processRole(document, user, userElm);
    }

    private void processId(User user, Element userElm) {
        userElm.setAttribute("id", String.valueOf(user.getId()));
    }

    private void processRole(Document document, User user, Element userElm) {
        Element roleElm = document.createElement("role");
        userElm.appendChild(roleElm);
        roleElm.setTextContent(user.getRole().toString());
    }

    private void processAge(Document document, User user, Element userElm) {
        Element ageElm = document.createElement("age");
        userElm.appendChild(ageElm);
        ageElm.setTextContent(String.valueOf(user.getAge()));
    }

    private void processLastName(Document document, User user, Element userElm) {
        Element lastNameElm = document.createElement("lastName");
        userElm.appendChild(lastNameElm);
        lastNameElm.setTextContent(user.getLastName());
    }

    private void processFirstName(Document document, User user, Element userElm) {
        Element firstNameElm = document.createElement("firstName");
        userElm.appendChild(firstNameElm);
        firstNameElm.setTextContent(user.getFirstName());
    }

    private Element createUserElement(Document document, User user, Element root) {
        Element userElm = document.createElement("user");
        root.appendChild(userElm);
        return userElm;
    }
}
