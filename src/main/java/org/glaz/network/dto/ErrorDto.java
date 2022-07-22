package org.glaz.network.dto;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class ErrorDto implements BaseUserReadDto{

    String error;
    LocalDateTime time;
}
