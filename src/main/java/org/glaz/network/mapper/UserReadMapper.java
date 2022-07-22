package org.glaz.network.mapper;

import org.glaz.network.database.entity.User;
import org.glaz.network.dto.UserReadDto;
import org.springframework.stereotype.Component;

@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    @Override
    public UserReadDto map(User object) {
        return new UserReadDto(
                object.getId(),
                object.getFirstname(),
                object.getLastname(),
                object.getBirthDate(),
                object.getUsername(),
                object.getUserType(),
                object.getAbout()
        );
    }
}
