package model;

import java.lang.reflect.Field;

public enum Rating {
	G("G"),
	PG("PG"),
	PG_13("PG-13"),
	R("R"),
	NC_17("NC-17");
	
	Rating(final String value) {
		try {
			final Field nameField = this.getClass().getSuperclass().getDeclaredField("name");
			nameField.setAccessible(true);
			nameField.set(this, value);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
