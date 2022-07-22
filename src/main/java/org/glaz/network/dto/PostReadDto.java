package org.glaz.network.dto;

import lombok.Value;
import org.glaz.network.database.entity.Comment;

import java.time.LocalDateTime;
import java.util.List;

@Value
public class PostReadDto {

    Boolean isBlocked;
    List<Comment> comments;
//    Boolean hasMyLike;
    UserDto author;
    Long id;
    LocalDateTime time;
    String title;
    String postText;
    Integer likes;
    List<String> tags;
}
