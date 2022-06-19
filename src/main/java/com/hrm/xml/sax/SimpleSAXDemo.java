package com.hrm.xml.sax;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import com.hrm.xml.App;

public class SimpleSAXDemo {
    private static final SimpleSAXUserHandler handler = new SimpleSAXUserHandler();
    
    public static void main(String[] args) {
        InputStream in = new ByteArrayInputStream(App.simpleUsersXml.getBytes());
        handler.deserialize(in);
    }

}
