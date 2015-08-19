package com.gm.tweak.domain.game.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public class AddStatsPlayerEvent implements PlayerEvent {

	@Override
	public void update(Game game, Player playerDiviner) {
		Player playerCreator = game.getPlayerCreator();
		playerCreator.incrementMadeDrawings();
		playerCreator.incrementDrawingsThatWereGuessToMe();
		playerDiviner.incrementDivinedDrawings();
	}

}
