package org.glaz.network.mapper;

import org.glaz.network.database.entity.User;
import org.glaz.network.dto.DeletedUserDto;
import org.springframework.stereotype.Component;

@Component
public class DeletedUserMapper implements Mapper<User, DeletedUserDto> {

    @Override
    public DeletedUserDto map(User object) {
        return new DeletedUserDto(
                object.getId(),
                object.getFirstname(),
                object.getLastname(),
                "User profile has been deleted"
        );
    }
}