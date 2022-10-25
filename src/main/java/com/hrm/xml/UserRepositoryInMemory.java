package com.hrm.xml;

import com.hrm.xml.User.Role;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserRepositoryInMemory implements UserRepository {

    private static final Map<Long, User> data = new HashMap<>();

    static {
        data.put(1L, new User(1L, "Mike", "Johnson", (byte) 23, Role.ADMIN));
        data.put(2L, new User(2L, "Nick", "Nixon", (byte) 55, Role.ADMIN));
        data.put(3L, new User(3L, "Tim", "Carter", (byte) 47, Role.MANAGER));
        data.put(4L, new User(4L, "Jake", "Manchester", (byte) 19, Role.MANAGER));
        data.put(5L, new User(5L, "Linda", "White", (byte) 18, Role.MANAGER));
        data.put(6L, new User(6L, "Mark", "Smith", (byte) 35, Role.USER));
        data.put(7L, new User(7L, "Andrew", "Redstone", (byte) 27, Role.USER));
        data.put(8L, new User(8L, "Mary", "Black", (byte) 29, Role.USER));
        data.put(9L, new User(9L, "Sirena", "Webber", (byte) 31, Role.USER));
        data.put(10L, new User(10L, "Richard", "Trotskiy", (byte) 23, Role.USER));
        data.put(11L, new User(11L, "Elizabeth", "Hesse", (byte) 44, Role.USER));
        data.put(12L, new User(12L, "Ursula", "Mischel", (byte) 51, Role.USER));
    }

    @Override
    public User getById(Long id) {
        return data.get(id);
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<>(data.values());
    }

}
