package com.gm.tweak.application.service;

import com.gm.tweak.domain.game.*;
import com.gm.tweak.domain.game.factory.GameBuilder;
import com.gm.tweak.domain.user.event.PlayerWonDomainEvent;
import com.gm.tweak.exception.GameCreationException;

import java.util.List;

public class GameService {

    private GameRepository gameRepository;

    public GameService(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public Game create(Drawing drawing, Player gameCreator) throws GameCreationException {
        GameId gameId = gameRepository.nextGameId();

        Game game = new GameBuilder().withGameId(gameId).withDrawing(drawing).withPlayerCreator(gameCreator).withDomainEvent(new PlayerWonDomainEvent()).build();

        gameRepository.save(game);

        return game;
    }

    public void tryWord(GameId gameId, Player diviner, Word word) {
        Game game = gameRepository.findById(gameId);
        game.tryWord(diviner, word);
    }

    public List<Game> findAllGames() {
        return gameRepository.findAll();
    }

}