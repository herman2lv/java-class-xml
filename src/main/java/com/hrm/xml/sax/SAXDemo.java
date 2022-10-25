package com.hrm.xml.sax;

import com.hrm.xml.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

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
