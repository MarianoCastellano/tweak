package com.gm.tweak.domain.game;

public class PlayerStats {

	private Long madeDrawings;
	private Long divinedDrawings;
	private Long drawingsThatWereGuessToMe;

	public PlayerStats(Long madeDrawings, Long divinedDrawings, Long drawingsThatWereGuessToMe) {
		this.madeDrawings = madeDrawings;
		this.divinedDrawings = divinedDrawings;
		this.drawingsThatWereGuessToMe = drawingsThatWereGuessToMe;
	}

	public void incrementMadeDrawings() {
		this.madeDrawings++;
	}

	public void incrementDivinedDrawings() {
		this.divinedDrawings++;
	}

	public void incrementDrawingsThatWereGuessToMe() {
		this.drawingsThatWereGuessToMe++;
	}

	public Long getDrawingsThatWereGuessToMe() {
		return drawingsThatWereGuessToMe;
	}

	public Long getMadeDrawingsAmount() {
		return madeDrawings;
	}

	public Long getDivinedDrawingsAmount() {
		return divinedDrawings;
	}

}
