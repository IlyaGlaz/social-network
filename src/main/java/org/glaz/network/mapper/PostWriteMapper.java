package org.glaz.network.mapper;

import lombok.RequiredArgsConstructor;
import org.glaz.network.database.entity.Post;
import org.glaz.network.database.entity.User;
import org.glaz.network.database.repository.UserRepository;
import org.glaz.network.dto.PostWriteDto;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostWriteMapper implements Mapper<PostWriteDto, Post> {

    private final UserRepository userRepository;

    @Override
    public Post map(PostWriteDto object) {
        Post post = new Post();
        copy(object, post);

        return post;
    }

    public Post mapWith(PostWriteDto object, User user) {
        Post post = new Post();
        copy(object, post);
        post.setAuthor(user);

        return post;
    }

    private void copy(PostWriteDto object, Post post) {
        post.setTitle(object.getTitle());
        post.setPostText(object.getText());
        post.setTags(object.getTags());
    }
}
