package org.glaz.network.service;

import lombok.RequiredArgsConstructor;
import org.glaz.network.database.repository.PostRepository;
import org.glaz.network.database.repository.UserRepository;
import org.glaz.network.dto.PostReadDto;
import org.glaz.network.dto.PostWriteDto;
import org.glaz.network.mapper.PostWriteMapper;
import org.glaz.network.mapper.PostReadMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PostService {

    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final PostWriteMapper postWriteMapper;
    private final PostReadMapper postReadMapper;

    @Transactional
    public PostReadDto create(PostWriteDto postWriteDto, String username) {
        return userRepository.findByUsername(username)
                .map(entity -> postWriteMapper.mapWith(postWriteDto, entity))
                .map(postRepository::saveAndFlush)
                .map(postReadMapper::map)
                .orElseThrow();
    }
}
