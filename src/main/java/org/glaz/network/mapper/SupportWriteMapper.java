package org.glaz.network.mapper;

import org.glaz.network.database.entity.Support;
import org.glaz.network.dto.SupportWriteDto;
import org.springframework.stereotype.Component;


@Component
public class SupportWriteMapper implements Mapper<SupportWriteDto, Support> {

    public Support map(SupportWriteDto object) {
        Support support = new Support();
        support.setFirstname(object.getFirstname());
        support.setLastname(object.getLastname());
        support.setEmail(object.getEmail());
        support.setMassage(object.getMessage());

        return support;
    }
}
