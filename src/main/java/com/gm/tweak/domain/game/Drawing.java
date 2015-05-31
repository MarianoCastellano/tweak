package com.gm.tweak.domain.game;

public class Drawing {

	private String name;
	private Byte[] image;

	public Drawing(String name, Byte[] image) {
		this.name = name;
		this.image = image;
	}

	public Byte[] getImage() {
		return image;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(final Object object) {
		if (this == object)
			return true;
		if (object == null || getClass() != object.getClass())
			return false;

		final Drawing other = (Drawing) object;
		return other != null && name.equals(other.name) && image.equals(other.image);
	}

	@Override
	public int hashCode() {
		return name.hashCode() + image.hashCode();
	}
}