package com.hrm.json.jackson;

import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hrm.xml.User;
import com.hrm.xml.UserRepository;
import com.hrm.xml.UserRepositoryInMemory;

public class JacksonDemo {
    private static final UserRepository repository = new UserRepositoryInMemory();
    
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
        String json = "{\"id\":77,\"firstName\":\"Bark\",\"lastName\":\"Barkston\",\"age\":23,\"role\":\"ADMIN\"}";
        System.out.println(json);
        
        User user = repository.getById(1L);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(System.out, user);
        
        User user2 = mapper.readValue(json, User.class);
        System.out.println(user2);
    }
}
