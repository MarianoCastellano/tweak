package com.gm.tweak.domain.game;

import com.gm.tweak.domain.user.PlayerStats;
import com.gm.tweak.domain.user.achievements.Achievement;
import com.gm.tweak.domain.user.achievements.Achievements;

public class Player {

	private PlayerId playerId;
	private Double coins;
	private PlayerStats playerStats;
	private Achievements achievements;

	public Player(PlayerId playerId, PlayerStats playerStats) {
		this.playerId = playerId;
		this.coins = new Double(30);
		this.playerStats = playerStats;
		this.achievements = new Achievements();
	}

	public void addCoins(Double coinsEarned) {
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

	public void substractCoins() {
		this.coins -= 0.1;
	}

	public Double getCoins() {
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

}