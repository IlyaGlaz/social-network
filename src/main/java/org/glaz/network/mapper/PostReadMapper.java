package org.glaz.network.mapper;

import lombok.RequiredArgsConstructor;
import org.glaz.network.database.entity.Post;
import org.glaz.network.database.entity.Tag;
import org.glaz.network.dto.PostReadDto;
import org.glaz.network.dto.UserDto;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class PostReadMapper implements Mapper<Post, PostReadDto> {

    private final UserMapper userMapper;

    @Override
    public PostReadDto map(Post object) {
        UserDto user = Optional.of(object.getAuthor())
                .map(userMapper::map)
                .orElseThrow();
        return new PostReadDto(
                object.getIsBlocked(),
                object.getComments(),
//                object.getHesMyLike(),
                user,
                object.getId(),
                object.getTime(),
                object.getTitle(),
                object.getPostText(),
                object.getLikes().size(),
                object.getTags().stream()
                        .map(Tag::getName)
                        .collect(Collectors.toList())
        );
    }
}
