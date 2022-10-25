package com.hrm.xml.validation;

import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.IOException;

public class ValidationDemo {
    public static void main(String[] args) throws IOException, SAXException {
        SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        Schema schema = factory.newSchema(new StreamSource("src/main/resources/users-schema.xsd"));
        Validator validator = schema.newValidator();
        validator.validate(new StreamSource("src/main/resources/users-data.xml"));
        System.out.println("Document is valid");
    }
}
