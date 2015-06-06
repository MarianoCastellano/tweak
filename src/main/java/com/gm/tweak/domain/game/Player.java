package com.gm.tweak.domain.game;

public class Player {

	private PlayerId playerId;
	private Long coins;

	public Player(PlayerId playerId) {
		this.playerId = playerId;
		this.coins = new Long(10);
	}

	public void addCoins(Long coinsEarned) {
		this.coins += coinsEarned;
	}

	public Long getCoins() {
		return coins;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Player other = (Player) obj;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		return true;
	}

}