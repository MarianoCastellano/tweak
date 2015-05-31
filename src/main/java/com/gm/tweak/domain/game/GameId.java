package com.gm.tweak.domain.game;

import com.gm.tweak.util.FieldValidator;

public class GameId {

	private String id;

	public GameId(String gameId) {
		FieldValidator.notNull(gameId, "Game Id");
		this.id = gameId;
	}

	public String getId() {
		return id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		GameId other = (GameId) o;

		return other != null && this.id.equals(other.id);
	}

}