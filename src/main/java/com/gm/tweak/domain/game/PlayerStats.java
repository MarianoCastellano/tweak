package com.gm.tweak.domain.game;

public class PlayerStats {

	private Long madeDrawings;
	private Long divinedDrawings;

	public PlayerStats(Long madeDrawings, Long divinedDrawings) {
		this.madeDrawings = madeDrawings;
		this.divinedDrawings = divinedDrawings;
	}

	public void incrementMadeDrawings() {
		this.madeDrawings++;
	}

	public void incrementDivinedDrawings() {
		this.divinedDrawings++;
	}

	public Long getMadeDrawingsAmount() {
		return madeDrawings;
	}

	public Long getDivinedDrawingsAmount() {
		return divinedDrawings;
	}

}
