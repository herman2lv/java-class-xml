package com.hrm.xml.jaxb;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.hrm.xml.User;
import com.hrm.xml.UserRepository;
import com.hrm.xml.UserRepositoryInMemory;

public class JAXBDemo {
    private static UserRepository repository = new UserRepositoryInMemory();
    
    public static void main(String[] args) throws Exception {
        read();
        write();
    }

    private static void write() throws JAXBException, IOException, FileNotFoundException {
        try (OutputStream out = new FileOutputStream("out/users-jaxb.xml")) {
            JAXBContext content = JAXBContext.newInstance(Users.class);
            Marshaller marshaller = content.createMarshaller();
            
            List<User> users = repository.getAll();
            Users usersJAXB = new Users(users);
            
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(usersJAXB, out);
        }
    }

    private static void read() throws JAXBException, IOException, FileNotFoundException {
        try (InputStream in = new FileInputStream("src/main/resources/users-data.xml")) {
            JAXBContext content = JAXBContext.newInstance(Users.class);
            Unmarshaller unmarshaller = content.createUnmarshaller();
            Users usersJAXB = (Users) unmarshaller.unmarshal(in);
            List<User> users = usersJAXB.getUsers();
            users.forEach(System.out::println);
        }
    }

}
