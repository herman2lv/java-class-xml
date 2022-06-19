package com.hrm.xml.sax;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import com.hrm.xml.User;

public class SAXDemo {
    private static final SAXUserHandler handler = new SAXUserHandler();
    
    public static void main(String[] args) throws IOException {
        //no write for SAX
        
        //read
        try (InputStream is = new FileInputStream("src/main/resources/users-data.xml")) {
            List<User> users = handler.deserialize(is);
            users.forEach(System.out::println);
        }
    }
}
