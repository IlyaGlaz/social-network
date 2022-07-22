package org.glaz.network.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glaz.network.database.entity.enums.FriendshipStatus;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Friendship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime time;

    @Enumerated(EnumType.STRING)
    private FriendshipStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "src_user_id")
    private User srcUser;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dst_user_id")
    private User dstUser;
}
