package org.glaz.network.integration.service;

import lombok.RequiredArgsConstructor;
import org.glaz.network.database.entity.enums.UserType;
import org.glaz.network.dto.UserCreateEditDto;
import org.glaz.network.dto.UserReadDto;
import org.glaz.network.integration.IntegrationTestBase;
import org.glaz.network.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase {

    private static final Long USER_1 = 1L;

    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> maybeUser = userService.findById(USER_1);
        assertTrue(maybeUser.isPresent());
        maybeUser.ifPresent(user -> assertEquals("ivan@gmail.com", user.getUsername()));
    }

    @Test
    void create() {
        UserCreateEditDto userDto = new UserCreateEditDto(
                "Test",
                "Test",
                LocalDate.now(),
                "test@gmail.com",
                "111",
                UserType.ADMIN,
                new MockMultipartFile("avatar1.jpg", (byte[]) null)
        );
        UserReadDto actualResult = userService.create(userDto);

        assertEquals(userDto.getFirstname(), actualResult.getFirstname());
        assertEquals(userDto.getLastname(), actualResult.getLastname());
        assertEquals(userDto.getBirthDate(), actualResult.getBirthDate());
        assertEquals(userDto.getUsername(), actualResult.getUsername());
        assertSame(userDto.getUserType(), actualResult.getUserType());
    }

    @Test
    void update() {
        UserCreateEditDto userDto = new UserCreateEditDto(
                "Test",
                "Test",
                LocalDate.now(),
                "test@gmail.com",
                "111",
                UserType.ADMIN,
                new MockMultipartFile("avatar1.jpg", (byte[]) null)
        );

        Optional<UserReadDto> actualResult = userService.update(USER_1, userDto);

        assertTrue(actualResult.isPresent());
        actualResult.ifPresent(user -> {
            assertEquals(userDto.getFirstname(), user.getFirstname());
            assertEquals(userDto.getLastname(), user.getLastname());
            assertEquals(userDto.getBirthDate(), user.getBirthDate());
            assertEquals(userDto.getUsername(), user.getUsername());
            assertSame(userDto.getUserType(), user.getUserType());
        });
    }

    @Test
    void delete() {
        assertFalse(userService.delete(-124L));
        assertTrue(userService.delete(USER_1));
    }
}
