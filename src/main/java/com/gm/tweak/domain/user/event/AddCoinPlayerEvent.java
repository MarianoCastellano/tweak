package com.gm.tweak.domain.user.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public class AddCoinPlayerEvent implements PlayerEvent {

	@Override
	public void update(Game game, Player diviner) {
		Double coinsReward = game.getDrawing().getPrice().getValue();
		diviner.addCoins(coinsReward);
		game.getPlayerCreator().addCoins(coinsReward);
	}

}