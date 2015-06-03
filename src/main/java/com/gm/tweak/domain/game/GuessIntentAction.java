package com.gm.tweak.domain.game;

public class GuessIntentAction {

	private String riskyWord;
	private Player player;
	private Drawing drawing;

	public GuessIntentAction(Player player, Drawing drawing, String riskyWord) {
		this.player = player;
		this.drawing = drawing;
		this.riskyWord = riskyWord;
	}

	public boolean tryWord() {
		if (riskyWord.equals(drawing.getName())) {
			return true;
		}
		drawing.addValue();
	}

}
