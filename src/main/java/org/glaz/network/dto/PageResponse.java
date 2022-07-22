package org.glaz.network.dto;

import lombok.Value;
import org.springframework.data.domain.Page;

import java.util.List;

@Value
public class PageResponse<T> {

    Metadata metadata;

    List<T> content;


    public static <T> PageResponse<T> of(Page<T> page) {
        Metadata metadata = new Metadata(page.getNumber(), page.getSize(), page.getTotalElements());
        return new PageResponse<>(metadata, page.getContent());
    }

    @Value
    public static class Metadata {
        int page;
        int size;
        long total;
    }
}
