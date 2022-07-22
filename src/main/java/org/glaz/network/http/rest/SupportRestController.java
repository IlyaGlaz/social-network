package org.glaz.network.http.rest;

import lombok.RequiredArgsConstructor;
import org.glaz.network.dto.SupportReadDto;
import org.glaz.network.dto.SupportWriteDto;
import org.glaz.network.service.SupportService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class SupportRestController {

    private final SupportService supportService;

    @PostMapping("/support")
    @ResponseStatus(HttpStatus.CREATED)
    public SupportReadDto create(@RequestBody SupportWriteDto support) {
        return supportService.create(support);
    }
}
