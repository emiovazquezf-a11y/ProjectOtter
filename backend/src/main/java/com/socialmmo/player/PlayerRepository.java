package com.socialmmo.player;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, String> {
    Optional<Player> findBySteamId(String steamId);
}
