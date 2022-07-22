package org.glaz.network.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glaz.network.database.entity.enums.Action;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class BlockHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Post post;
//
//    @ManyToOne(fetch = FetchType.LAZY)
//    private Comment comment;

    @Enumerated(EnumType.STRING)
    private Action action;
}
