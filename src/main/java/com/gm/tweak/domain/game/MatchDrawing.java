package com.gm.tweak.domain.game;

public class MatchDrawing implements Drawing {

	private Player artist;
	private Price price;
	private Board board;

	public MatchDrawing(Player artist, Board board) {
		this.artist = artist;
		this.board = board;
		this.price = new Price(new Long(1));
	}

	@Override
	public Player getArtist() {
		return artist;
	}

	@Override
	public Board getBoard() {
		return board;
	}

	@Override
	public Price getPrice() {
		return price;
	}
}