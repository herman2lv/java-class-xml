package com.hrm.xml;

import java.util.List;

public interface UserRepository {
    User getById(Long id);

    List<User> getAll();

}
