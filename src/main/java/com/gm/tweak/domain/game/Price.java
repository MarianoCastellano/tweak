package com.gm.tweak.domain.game;

public class Price {

	private Long value;

	public Price(Long price) {
		this.value = price;
	}

	public Long getValue() {
		return value;
	}

	public void incrementValue() {
		this.value ++;
	}
	
	@Override
	public boolean equals(Object obj) {
		return this.value.equals(((Price) obj).getValue());
	}
	
}
