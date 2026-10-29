
package com.socialmmo.player;

import com.socialmmo.player.dto.CreatePlayerRequest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Transactional
    public Player createPlayer(CreatePlayerRequest request) {
        Player player = new Player(request.steamId(), request.username());

        try {
            return playerRepository.saveAndFlush(player);
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(
                HttpStatus.CONFLICT,
                "Steam ID or username already exists",
                ex
            );
        }
    }

    @Transactional(readOnly = true)
    public Player getPlayer(String id) {
        return playerRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Player not found"
            ));
    }

    @Transactional(readOnly = true)
    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }
}

