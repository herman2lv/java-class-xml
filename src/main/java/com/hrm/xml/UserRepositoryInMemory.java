package com.hrm.xml;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hrm.xml.User.Role;

public class UserRepositoryInMemory implements UserRepository {

    private static final Map<Long, User> data = new HashMap<>();
    static {
        data.put(1L, new User(1L, "Mike", "Johnson", 23, Role.ADMIN));
        data.put(2L, new User(2L, "Nick", "Nixon", 55, Role.ADMIN));
        data.put(3L, new User(3L, "Tim", "Carter", 47, Role.MANAGER));
        data.put(4L, new User(4L, "Jake", "Manchester", 19, Role.MANAGER));
        data.put(5L, new User(5L, "Linda", "White", 18, Role.MANAGER));
        data.put(6L, new User(6L, "Mark", "Smith", 35, Role.USER));
        data.put(7L, new User(7L, "Andrew", "Redstone", 27, Role.USER));
        data.put(8L, new User(8L, "Mary", "Black", 29, Role.USER));
        data.put(9L, new User(9L, "Sirena", "Webber", 31, Role.USER));
        data.put(10L, new User(10L, "Richard", "Trotskiy", 23, Role.USER));
        data.put(11L, new User(11L, "Elizabeth", "Hesse", 44, Role.USER));
        data.put(12L, new User(12L, "Ursula", "Mischel", 51, Role.USER));
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
