package com.gm.tweak.domain.user.event;

import com.gm.tweak.domain.game.Game;
import com.gm.tweak.domain.game.Player;

public interface PlayerEvent {

	void update(Game game, Player diviner);
}