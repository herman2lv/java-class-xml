package com.hrm.xml.dom;

import com.hrm.xml.Data;
import com.hrm.xml.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class SimpleDOMDemo {
    public static void main(String[] args) throws Exception {
        read();
        write();
    }

    private static void write() throws Exception {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("users");
        document.appendChild(root);

        Element userElm = document.createElement("user");
        root.appendChild(userElm);
        userElm.setAttribute("id", "25");

        Element firstNameElm = document.createElement("firstName");
        userElm.appendChild(firstNameElm);
        firstNameElm.setTextContent("Mike");

        Element lastNameElm = document.createElement("lastName");
        userElm.appendChild(lastNameElm);
        lastNameElm.setTextContent("Willis");

        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer();
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");
        transformer.transform(new DOMSource(document), new StreamResult(System.out));
    }

    private static void read() throws ParserConfigurationException, SAXException, IOException {
        InputStream is = new ByteArrayInputStream(Data.simpleUsersXml.getBytes());

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(is);

        List<User> users = new ArrayList<>();
        Element root = document.getDocumentElement();
//        NodeList nodes = root.getChildNodes();
//        System.out.println(nodes.getLength());
        NodeList nodes = root.getElementsByTagName("user");
        for (int i = 0; i < nodes.getLength(); i++) {
            Element userElm = (Element) nodes.item(i);
            User user = new User();
            users.add(user);

            String rawId = userElm.getAttribute("id");
            Long id = Long.parseLong(rawId);
            user.setId(id);

            Element firstNameElm = (Element) userElm.getElementsByTagName("firstName").item(0);
            String firstName = firstNameElm.getTextContent();
            user.setFirstName(firstName);

            Element lastNameElm = (Element) userElm.getElementsByTagName("lastName").item(0);
            String lastName = lastNameElm.getTextContent();
            user.setFirstName(lastName);
        }
        users.forEach(System.out::println);
    }
}
