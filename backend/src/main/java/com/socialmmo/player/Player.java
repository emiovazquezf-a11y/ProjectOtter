package com.socialmmo.player;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "players")
public class Player {
    @Id
    @Column(length = 36, nullable = false)
    private String id;

    @Column(name = "steam_id", length = 32, nullable = false, unique = true)
    private String steamId;

    @Column(length = 32, nullable = false, unique = true)
    private String username;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private LocalDateTime createdAt;

    protected Player() {}

    public Player(String steamId, String username) {
        this.id = UUID.randomUUID().toString();
        this.steamId = steamId;
        this.username = username;
    }

    public String getId() { return id; }
    public String getSteamId() { return steamId; }
    public String getUsername() { return username; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
