package com.hrm.xml.stax;

import com.hrm.xml.User;
import com.hrm.xml.UserRepository;
import com.hrm.xml.UserRepositoryInMemory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class StAXDemo {
    private static final UserRepository repo = new UserRepositoryInMemory();
    private static final StAXSerializer xmlWriter = new StAXSerializer();
    private static final StAXDeserializer xmlReader = new StAXDeserializer();

    public static void main(String[] args) throws IOException {
        //write
        try (OutputStream out = new FileOutputStream("out/users-stax.xml")) {
            List<User> users = repo.getAll();
            xmlWriter.serialize(users, out);
        }

//        //read
        try (InputStream in = new FileInputStream("src/main/resources/users-data.xml")) {
            List<User> users = xmlReader.deserialize(in);
            users.forEach(System.out::println);
        }

    }

}
