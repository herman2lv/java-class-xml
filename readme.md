# Java Class - Training Course

## XML Processing Demo

#### Author: Herman Rabinkin

This repository contains examples which can help to
explain and understand basic Java XML Processing workflow

### Validation Demo  
[_package: validation_](src/main/java/com/hrm/xml/validation/DataRaceDemo.java)

* Example of validation xml documents against schema (XSD) using native to java features
* XSD schema [sample](src/main/resources/user-schema.xsd)
* [Valid](src/main/resources/user-data.xml) document
* [Not-valid](src/main/resources/user-data-not-valid.xml) document

### SAX Demo
[_package: intro_](src/com/hrm/xml/sax/SimpleSAXDemo.java)

* Example of usage of Simple API for XML processing (SAX) for reading xml documents

### StAX Demo
[_package: intro_](src/com/hrm/xml/stax/SimpleStAXDemo.java)

* Example of usage of Streaming API for XML processing (StAX) for reading and creating xml documents

### DOM Demo
[_package: intro_](src/com/hrm/xml/dom/DOMDemo.java)

* Example of usage of Document Object Model (DOM) for reading and writing xml documents
 
### JAXB Demo
[_package: intro_](src/com/hrm/xml/jaxb/JAXBDemo.java)

* Example of usage of Java API for XML Binding (JAXB) for marshaling and unmarshaling objects to XML
* Sample container [class](src/com/hrm/xml/jaxb/Users.java)
* Annotated entity [class](src/com/hrm/xml/User.java)
