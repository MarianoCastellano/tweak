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

		boolean playerGuessTheWord = triedWord.equals(game.getDrawing().getName());
		if (playerGuessTheWord) {
			addCoins(game.getDrawing().getValue());
			game.addEvent(new PlayerGuessTheDrawingEvent(this, game));
		}
	}

	private void addCoins(Long coinsEarned) {
		this.coins += coinsEarned;
	}

	public Long getCoins() {
		return coins;
	}

	public List<String> getTriedWords() {
		return triedWords;
	}

	public PlayerId getPlayerId() {
		return playerId;
	}
}