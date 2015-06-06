package com.gm.tweak.domain.game;

public class Game {

	private GameId gameId;
	private Word word;
	private Drawing drawing;

	private Player currentDiviner;

	public Game(GameId gameId, Word word, Drawing drawing) {
		this.gameId = gameId;
		this.word = word;
		this.drawing = drawing;
	}

	public Boolean tryWord(Player player, Word word) throws Exception {
		if (this.drawing.getArtist().getPlayerId().getId().equals("NO_ID")) {
			throw new Exception("drawing not found");
		}
		currentDiviner = player;
		boolean areEquals = this.word.equals(word);
		if (areEquals) {
			Long drawingValue = this.drawing.getPrice().getValue();
			currentDiviner.addCoins(drawingValue);
			drawing.getArtist().addCoins(drawingValue);
		}
		return areEquals;
	}

	public void draw(Player artist, Board board) {
		 MatchDrawing matchDrawing = new MatchDrawing(artist, board);
		 this.drawing = matchDrawing;
	}

	public GameId getGameId() {
		return gameId;
	}

	public Word getWord() {
		return word;
	}

	public Player getCurrentDiviner() {
		return currentDiviner;
	}

	public Player getArtist() {
		return getDrawing().getArtist();
	}

	private Drawing getDrawing() {
		return drawing;
	}
}