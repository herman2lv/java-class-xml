package com.hrm.xml.stax;

import com.hrm.xml.User;

import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamWriter;
import java.io.OutputStream;
import java.util.List;

public class StAXSerializer {

    public void serialize(List<User> users, OutputStream out) {
        XMLOutputFactory factory = XMLOutputFactory.newInstance();
        XMLStreamWriter writer = null;
        try {
            writer = factory.createXMLStreamWriter(out);
            writer.writeStartDocument();
            writer.writeStartElement("users");

            for (User user : users) {
                serialize(user, writer);
            }

            writer.writeEndElement();
            writer.writeEndDocument();
        } catch (XMLStreamException e) {
            throw new RuntimeException(e);
        } finally {
            close(writer);
        }
    }


    private void serialize(User user, XMLStreamWriter writer) throws XMLStreamException {
        writer.writeStartElement("user");
        writer.writeAttribute("id", user.getId().toString());

        writer.writeStartElement("firstName");
        writer.writeCharacters(user.getFirstName());
        writer.writeEndElement();

        writer.writeStartElement("lastName");
        writer.writeCharacters(user.getLastName());
        writer.writeEndElement();

        writer.writeStartElement("age");
        writer.writeCharacters(user.getAge().toString());
        writer.writeEndElement();

        writer.writeStartElement("role");
        writer.writeCharacters(user.getRole().toString());
        writer.writeEndElement();

        writer.writeEndElement();
    }

    private void close(XMLStreamWriter writer) {
        if (writer != null) {
            try {
                writer.close();
            } catch (XMLStreamException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
