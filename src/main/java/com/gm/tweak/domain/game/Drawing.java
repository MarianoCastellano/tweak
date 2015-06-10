package com.gm.tweak.domain.game;

public class Drawing {

	private Word word;
	private Price price;
	private Board board;

	public Drawing(PlayerId artistId, Board board, Word word) {
		this.board = board;
		this.price = new Price(new Long(1));
		this.word = word;
	}

	public Board getBoard() {
		return board;
	}

	public Price getPrice() {
		return price;
	}

	public Word getWord() {
		return word;
	}
}