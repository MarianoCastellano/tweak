package com.gm.tweak.application.service;

import java.util.List;

import com.gm.tweak.domain.game.Drawing;
import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.GameId;
import com.gm.tweak.domain.game.Player;
import com.gm.tweak.domain.game.Word;
import com.gm.tweak.exception.GameCreationException;

public interface DefaultGameService {

	Game create(Drawing drawing, Player gameCreator) throws GameCreationException;

	void tryWord(GameId gameId, Player diviner, Word word);

	List<Game> findAllGames();
}
