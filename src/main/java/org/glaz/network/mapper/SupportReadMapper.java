package org.glaz.network.mapper;

import org.glaz.network.database.entity.Support;
import org.glaz.network.dto.SupportReadDto;
import org.springframework.stereotype.Component;


@Component
public class SupportReadMapper implements Mapper<Support, SupportReadDto> {

    public SupportReadDto map(Support object) {
        return new SupportReadDto("OK");
    }
}
