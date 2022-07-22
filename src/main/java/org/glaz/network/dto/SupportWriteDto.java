package org.glaz.network.dto;

import lombok.Value;

@Value
public class SupportWriteDto {

    String firstname;
    String lastname;
    String email;
    String message;
}
