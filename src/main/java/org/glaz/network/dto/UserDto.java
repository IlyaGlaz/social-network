package org.glaz.network.dto;

import lombok.Value;
import org.glaz.network.database.entity.enums.MessagesPermission;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Value
public class UserDto {

    String country;
    String city;
    LocalDate birthDate;
    String about;
    String photo;
    String lastname;
//    Token token;
    LocalDateTime regDate;
    Boolean isBlocked;
//    Boolean isDeleted;
    MessagesPermission messagesPermission;
    LocalDateTime lastOnlineTime;
    String phone;
    Long id;
    String firstname;
    String username;
}
