package com.gm.tweak.domain.game;

public class Price {

	private Double value;

	public Price(Double price) {
		this.value = price;
	}

	public Double getValue() {
		return value;
	}

	public void incrementValue() {
		this.value++;
	}

	@Override
	public boolean equals(Object obj) {
		return this.value.equals(((Price) obj).getValue());
	}

}
