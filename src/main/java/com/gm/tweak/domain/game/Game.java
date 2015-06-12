package com.gm.tweak.domain.game;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private GameId gameId;
	private Player gameCreator;
	private Drawing drawing;

	private List<PlayerEvent> domainEvents;

	public Game(GameId gameId, Drawing drawing, Player gameCreator) {
		this.gameId = gameId;
		this.drawing = drawing;
		this.gameCreator = gameCreator;
		domainEvents = new ArrayList<PlayerEvent>();
	}

	public Boolean tryWord(Player diviner, Word word) {
		boolean playerWon = drawing.getWord().equals(word);
		if (playerWon) {
			domainEvents.add(new PlayerWonDomainEvent(diviner));
		}else {
			drawing.raisePrice();
		}
		return playerWon;
	}

	public List<PlayerEvent> getDomainEvents() {
		return domainEvents;
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