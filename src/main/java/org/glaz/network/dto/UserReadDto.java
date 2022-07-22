package org.glaz.network.dto;

import lombok.Value;
import org.glaz.network.database.entity.enums.UserType;

import java.time.LocalDate;

@Value
public class UserReadDto implements BaseUserReadDto {

    Long id;
    String firstname;
    String lastname;
    LocalDate birthDate;
    String username;
    UserType userType;
    String about;
}
