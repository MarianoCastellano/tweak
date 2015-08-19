package com.gm.tweak.domain.game;

import com.gm.tweak.domain.game.event.DomainEvent;

public class Game {

	private GameId gameId;
	private Player gameCreator;
	private Drawing drawing;
	private DomainEvent domainEvent;

	public Game(GameId gameId, Drawing drawing, Player gameCreator, DomainEvent domainEvent) {
		this.gameId = gameId;
		this.drawing = drawing;
		this.gameCreator = gameCreator;
		this.domainEvent = domainEvent;
	}

	public void tryWord(Player diviner, Word word) {
		boolean playerWon = drawing.getWord().equals(word);
		if (playerWon) {
			domainEvent.notifyEvents(this, diviner);
		} else {
			drawing.raisePrice();
		}
	}

	public Player getGameCreator() {
		return gameCreator;
	}

	public GameId getGameId() {
		return gameId;
	}

	public Word getWord() {
		return drawing.getWord();
	}

	public Drawing getDrawing() {
		return drawing;
	}
}