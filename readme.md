# Java Class - Training Course

## XML Processing Demo

#### Author: Herman Rabinkin

This repository contains examples which can help to
explain and understand basic Java XML Processing workflow

### Validation Demo  
[_package: validation_](/src/main/java/com/hrm/xml/validation/ValidationDemo.java)

* Example of validation xml documents against schema (XSD) using native to java features
* XSD schema [sample](/src/main/resources/users-schema.xsd)
* [Valid](/src/main/resources/users-data.xml) document
* [Not-valid](/src/main/resources/users-data-not-valid.xml) document

### SAX Demo
[_package: sax_](/src/main/java/com/hrm/xml/sax/SimpleSAXDemo.java)

* Example of usage of Simple API for XML processing (SAX) for reading xml documents

### StAX Demo
[_package: stax_](/src/main/java/com/hrm/xml/stax/SimpleStAXDemo.java)

* Example of usage of Streaming API for XML processing (StAX) for reading and creating xml documents

### DOM Demo
[_package: dom_](/src/main/java/com/hrm/xml/dom/DOMDemo.java)

* Example of usage of Document Object Model (DOM) for reading and writing xml documents
 
### JAXB Demo
[_package: jaxb_](/src/main/java/com/hrm/xml/jaxb/JAXBDemo.java)

* Example of usage of Java API for XML Binding (JAXB) for marshaling and unmarshaling objects to XML
* Sample container [class](/src/main/java/com/hrm/xml/jaxb/Users.java)
* Annotated entity [class](/src/main/java/com/hrm/xml/User.java)

### Jackson Demo
[_package: jackson_](/src/main/java/com/hrm/json/jackson/JacksonDemo.java)

* Example of usage of Jackson json object mapper for simple case

