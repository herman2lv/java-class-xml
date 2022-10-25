package com.hrm.xml.stax;

import com.hrm.xml.Data;
import com.hrm.xml.User;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class SimpleStAXDemo {
    public static void main(String[] args) throws XMLStreamException {
        write();
        read();
    }

    private static void write() throws XMLStreamException {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = factory.createXMLStreamWriter(System.out);
        writer.writeStartDocument();
        writer.writeStartElement("users");
        writer.writeStartElement("user");
        writer.writeAttribute("id", "1");
        writer.writeStartElement("firstName");
        writer.writeCharacters("Johny");
        writer.writeEndElement();
        writer.writeStartElement("lastName");
        writer.writeCharacters("Johnnson");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        writer.close();
    }

    private static void read() throws XMLStreamException {
        StringReader in = new StringReader(Data.simpleUsersXml);

        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader reader = factory.createXMLEventReader(in);

        List<User> users = new ArrayList<>();
        User user = null;
        while (reader.hasNext()) {
            XMLEvent event = reader.nextEvent();
            if (event.isStartElement()) {
                StartElement start = event.asStartElement();
                String elementName = start.getName().getLocalPart();
                switch (elementName) {
                    case "user":
                        user = new User();
                        users.add(user);
                        user.setId(Long.parseLong(start.getAttributeByName(new QName("id")).getValue()));
                        break;
                    case "firstName":
                        user.setFirstName(reader.getElementText());
                        break;
                    case "lastName":
                        user.setLastName(reader.getElementText());
                        break;
                }
            }
        }

        users.forEach(System.out::println);

    }

}
