package org.glaz.network.dto;

import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.glaz.network.database.entity.enums.UserType;
import org.glaz.network.validation.group.CreateAction;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Value
@FieldNameConstants
public class UserCreateEditDto {

    @Size(min = 3, max = 64)
    String firstname;

    @Size(min = 3, max = 64)
    String lastname;

    LocalDate birthDate;

    @Email
    String username;

    @NotBlank(groups = CreateAction.class)
    String rawPassword;

    UserType userType;

    MultipartFile photo;
}
