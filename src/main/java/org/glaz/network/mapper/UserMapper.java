package org.glaz.network.mapper;

import org.glaz.network.database.entity.User;
import org.glaz.network.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<User, UserDto> {

    @Override
    public UserDto map(User object) {
        return new UserDto(
                object.getCountry(),
                object.getCity(),
                object.getBirthDate(),
                object.getAbout(),
                object.getPhoto(),
                object.getLastname(),
//                object.getToken(),
                object.getRegDate(),
                object.getIsBlocked(),
//                object.isDeleted(),
                object.getMessagesPermission(),
                object.getLastOnlineTime(),
                object.getPhone(),
                object.getId(),
                object.getFirstname(),
                object.getUsername()
        );
    }
}
