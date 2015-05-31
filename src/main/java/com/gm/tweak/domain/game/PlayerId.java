package com.gm.tweak.domain.game;

import com.gm.tweak.util.FieldValidator;

public class PlayerId {

	private String id;

	public PlayerId(String playerId) {
		FieldValidator.notNull(playerId, "Player Id");
		this.id = playerId;
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

		PlayerId other = (PlayerId) o;

		return other != null && this.id.equals(other.id);
	}

}