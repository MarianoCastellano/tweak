package com.gm.tweak.domain.game;

public class Game {

	private GameId gameId;
	private Drawing drawing;

	public Game(GameId gameId, Drawing drawing) {
		this.gameId = gameId;
		this.drawing = drawing;
	}

	public Boolean tryWord(Word word) {
		return drawing.getWord().equals(word);
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