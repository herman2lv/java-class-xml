package com.hrm.xml.stax;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.namespace.QName;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

import com.hrm.xml.User;
import com.hrm.xml.User.Role;

public class StAXDeserializer {
    public List<User> deserialize(InputStream in) {
        try {
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
                    case "user" -> user = processUser(start, users);
                    case "firstName" -> processFirstName(reader, user);
                    case "lastName" -> processLastName(reader, user);
                    case "age" -> processAge(reader, user);
                    case "role" -> processRole(reader, user);
                    }
                }
            }
            return users;
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        }
    }

    private void processRole(XMLEventReader reader, User user) throws XMLStreamException {
        String rawData = reader.getElementText();
        Role role = Role.valueOf(rawData);
        user.setRole(role);
    }

    private void processAge(XMLEventReader reader, User user) throws XMLStreamException {
        String rawData = reader.getElementText();
        user.setAge(Byte.valueOf(rawData));
    }

    private void processLastName(XMLEventReader reader, User user) throws XMLStreamException {
        user.setLastName(reader.getElementText());
    }

    private void processFirstName(XMLEventReader reader, User user) throws XMLStreamException {
        user.setFirstName(reader.getElementText());
    }

    private User processUser(StartElement start, List<User> users) {
        User user = new User();
        user.setId(Long.parseLong(start.getAttributeByName(new QName("id")).getValue()));
        users.add(user);
        return user;
    }
}
