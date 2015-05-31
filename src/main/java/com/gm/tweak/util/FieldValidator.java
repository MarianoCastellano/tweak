package com.gm.tweak.util;

public class FieldValidator {

	public static void notNull(Object object, String field) {
		if (object == null) {
			String message = "Field null: ".concat(field);
			throw new IllegalArgumentException(message);
		}
	}
}