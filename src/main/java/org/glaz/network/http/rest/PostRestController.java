package org.glaz.network.http.rest;

import lombok.RequiredArgsConstructor;
import org.glaz.network.dto.PostReadDto;
import org.glaz.network.dto.PostWriteDto;
import org.glaz.network.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PostRestController {

    private final PostService postService;

    @PostMapping("/users/{id}/wall")
    @ResponseStatus(HttpStatus.CREATED)
    public PostReadDto create(@RequestBody PostWriteDto post,
                              @AuthenticationPrincipal UserDetails userDetails) {
        return postService.create(post, userDetails.getUsername());
    }
}
