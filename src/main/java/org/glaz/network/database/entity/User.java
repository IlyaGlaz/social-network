package org.glaz.network.database.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.glaz.network.database.entity.enums.MessagesPermission;
import org.glaz.network.database.entity.enums.UserType;
import org.hibernate.annotations.SQLDelete;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
@SQLDelete(sql = "UPDATE users SET deleted = true WHERE id = ?")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String firstname;

    private String lastname;

    private LocalDateTime regDate;

    private LocalDate birthDate;

    private String phone;

    private String password;

    private String country;

    private String city;

    @Enumerated(EnumType.STRING)
    private UserType userType;

    private String photo;

    private String about;

    private String confirmationCode;

    private Boolean isApproved;

    @Enumerated(EnumType.STRING)
    private MessagesPermission messagesPermission;

    private LocalDateTime lastOnlineTime;

    private Boolean isBlocked;

    private Boolean deleted = Boolean.FALSE;

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<BlockHistory> blockHistories = new ArrayList<>();

    @Builder.Default
    @OneToMany
    private List<Friendship> friendships = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "receiver")
    private List<Message> inMessages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "sender")
    private List<Message> outMessages = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "author")
    private List<Post> posts = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "author")
    private List<Comment> comments = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Likes> likes = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Notification> notifications = new ArrayList<>();

    @Builder.Default
    @OneToMany(mappedBy = "user")
    private List<Support> supports = new ArrayList<>();
}
