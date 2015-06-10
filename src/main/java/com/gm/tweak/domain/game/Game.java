package com.gm.tweak.domain.game;

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
			DomainEvents.add(new PlayerWonDomainEvent(diviner));
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