package com.gm.tweak.domain.game.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public interface PlayerEvent {

	void update(Game game, Player diviner);
}