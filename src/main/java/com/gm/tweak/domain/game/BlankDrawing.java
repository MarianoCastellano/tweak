package com.gm.tweak.domain.game;

public class BlankDrawing implements Drawing {

	@Override
	public Player getArtist() {
		return new Player(new PlayerId("NO_ID"));
	}

	@Override
	public Board getBoard() {
		return new Board();
	}

	@Override
	public Price getPrice() {
		return new Price(0L);
	}

}
