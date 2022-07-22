package org.glaz.network.dto;

import lombok.Value;
import org.glaz.network.database.entity.Tag;

import java.util.List;

@Value
public class PostWriteDto {

    String title;
    String text;
    List<Tag> tags;
}
