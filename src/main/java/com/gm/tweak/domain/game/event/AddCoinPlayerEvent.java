package com.gm.tweak.domain.game.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public class AddCoinPlayerEvent implements PlayerEvent {

	@Override
	public void update(Game game, Player diviner) {
		Long coinsReward = game.getDrawing().getPrice().getValue();
		diviner.addCoins(coinsReward);
		game.getGameCreator().addCoins(coinsReward);
	}

}