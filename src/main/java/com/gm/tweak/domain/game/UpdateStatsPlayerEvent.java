package com.gm.tweak.domain.game;

import com.gm.tweak.domain.game.event.PlayerEvent;

public class UpdateStatsPlayerEvent implements PlayerEvent {

	@Override
	public void update(Game game, Player playerDiviner) {
		Player playerCreator = game.getGameCreator();
		playerCreator.incrementMadeDrawings();
		playerCreator.incrementDrawingsThatWereGuessToMe();
		playerDiviner.incrementDivinedDrawings();
	}

}
