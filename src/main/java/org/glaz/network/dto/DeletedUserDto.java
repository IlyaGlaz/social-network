package org.glaz.network.dto;

import lombok.Value;

@Value
public class DeletedUserDto implements BaseUserReadDto {

    Long id;
    String firstname;
    String lastname;
    String about;
}
