package com.gm.tweak.domain.game;

import com.gm.tweak.domain.user.achievements.Achievement;
import com.gm.tweak.domain.user.achievements.Achievements;
import com.gm.tweak.domain.user.PlayerStats;

public class Player {

	private PlayerId playerId;
	private Long coins;
	private PlayerStats playerStats;
	private Achievements achievements;

	public Player(PlayerId playerId, PlayerStats playerStats) {
		this.playerId = playerId;
		this.coins = new Long(30);
		this.playerStats = playerStats;
		this.achievements = new Achievements();
	}

	public void addCoins(Long coinsEarned) {
		this.coins += coinsEarned;
	}

	public void addAchievement(Achievement achievement) {
		this.achievements.add(achievement);

	}

	public void incrementMadeDrawings() {
		this.playerStats.incrementMadeDrawings();
	}

	public void incrementDivinedDrawings() {
		this.playerStats.incrementDivinedDrawings();
	}

	public void incrementDrawingsThatWereGuessToMe() {
		this.playerStats.incrementDrawingsThatWereGuessToMe();
	}

	public Long getCoins() {
		return coins;
	}

	public Achievements getAchievements() {
		return achievements;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}

	public Long getMadeDrawingsAmount() {
		return this.playerStats.getMadeDrawingsAmount();
	}

	public Long getDivinedDrawingsAmount() {
		return this.playerStats.getDivinedDrawingsAmount();
	}

	public Long getDrawingsThatWereGuessToMe() {
		return this.playerStats.getDrawingsThatWereGuessToMe();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((achievements == null) ? 0 : achievements.hashCode());
		result = prime * result + ((coins == null) ? 0 : coins.hashCode());
		result = prime * result + ((playerId == null) ? 0 : playerId.hashCode());
		result = prime * result + ((playerStats == null) ? 0 : playerStats.hashCode());
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
		if (achievements == null) {
			if (other.achievements != null)
				return false;
		} else if (!achievements.equals(other.achievements))
			return false;
		if (coins == null) {
			if (other.coins != null)
				return false;
		} else if (!coins.equals(other.coins))
			return false;
		if (playerId == null) {
			if (other.playerId != null)
				return false;
		} else if (!playerId.equals(other.playerId))
			return false;
		if (playerStats == null) {
			if (other.playerStats != null)
				return false;
		} else if (!playerStats.equals(other.playerStats))
			return false;
		return true;
	}
}