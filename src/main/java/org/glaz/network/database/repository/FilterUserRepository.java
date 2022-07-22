package org.glaz.network.database.repository;

import org.glaz.network.database.entity.User;
import org.glaz.network.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
