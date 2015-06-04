package com.gm.tweak.domain.game;

import java.util.ArrayList;
import java.util.List;

public class PlayerDiviner {

	private PlayerId playerId;
	private Long coins;
	private List<String> triedWords;

	public PlayerDiviner(PlayerId playerId) {
		this.playerId = playerId;
		this.coins = new Long(10);
		triedWords = new ArrayList<String>();
	}

	public void tryWord(String triedWord, Game game) {
		this.triedWords.add(triedWord);

	}

	public void addCoins(Long coinsEarned) {
		this.coins += coinsEarned;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}
}