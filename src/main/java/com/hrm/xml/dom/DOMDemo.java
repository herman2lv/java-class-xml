package com.hrm.xml.dom;

import com.hrm.xml.User;
import com.hrm.xml.UserRepository;
import com.hrm.xml.UserRepositoryInMemory;
import org.w3c.dom.Document;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class DOMDemo {
    private static final DOMReader reader = new DOMReader();
    private static final DOMWriter writer = new DOMWriter();
    private static final UserRepository repository = new UserRepositoryInMemory();

    public static void main(String[] args) throws IOException {
        //read
        try (InputStream in = new FileInputStream("src/main/resources/users-data.xml")) {
            List<User> users = reader.deserialize(in);
            users.forEach(System.out::println);
        }

        //write
        try (OutputStream out = new FileOutputStream("out/users-dom.xml")) {
            List<User> users = repository.getAll();
            Document doc = writer.createDocument(users);
            writer.serialize(doc, out, true);
        }
    }
}
