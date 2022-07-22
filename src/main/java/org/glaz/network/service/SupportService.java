package org.glaz.network.service;

import lombok.RequiredArgsConstructor;
import org.glaz.network.database.repository.SupportRepository;
import org.glaz.network.dto.SupportReadDto;
import org.glaz.network.dto.SupportWriteDto;
import org.glaz.network.mapper.SupportReadMapper;
import org.glaz.network.mapper.SupportWriteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SupportService {

    private final SupportRepository supportRepository;
    private final SupportWriteMapper supportWriteMapper;
    private final SupportReadMapper supportReadMapper;

    @Transactional
    public SupportReadDto create(SupportWriteDto supportDto) {
        return Optional.of(supportDto)
                .map(supportWriteMapper::map)
                .map(supportRepository::save)
                .map(supportReadMapper::map)
                .orElseThrow();
    }
}
