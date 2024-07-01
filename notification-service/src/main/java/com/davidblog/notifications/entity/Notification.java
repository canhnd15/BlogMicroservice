package com.davidblog.notifications.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@Entity
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "message")
    private String message;

    @Column(name = "to_user")
    private Long toUserId;

    @Column(name = "from_user")
    private Long fromUserId;

    @Column(name = "created_at")
    private Date createAt;

    @Column(name = "updated_at")
    private Date updatedAt;
}
