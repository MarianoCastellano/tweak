package com.gm.tweak.domain.game;

import com.gm.tweak.domain.game.event.AddCoinPlayerEvent;
import com.gm.tweak.domain.game.event.DomainEvent;
import com.gm.tweak.domain.game.event.PlayerWonDomainEvent;

public class Game {

	private GameId gameId;
	private Player gameCreator;
	private Drawing drawing;

	public Game(GameId gameId, Drawing drawing, Player gameCreator) {
		this.gameId = gameId;
		this.drawing = drawing;
		this.gameCreator = gameCreator;
	}

	public void tryWord(Player diviner, Word word) {
		boolean playerWon = drawing.getWord().equals(word);
		if (playerWon) {
			DomainEvent domainEvent = new PlayerWonDomainEvent();
			domainEvent.attach(new AddCoinPlayerEvent());
			domainEvent.attach(new UpdateStatsPlayerEvent());
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