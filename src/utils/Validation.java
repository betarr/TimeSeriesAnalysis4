package utils;


public class Validation {

	public static boolean isStringNotEmpty(final String value) {
		String text = value.trim();
		if (text != null && !text.equals("")) {
			return true;
		}
		return false;
	}

	public static boolean isValidDouble(String value) {
		try {
			Double.valueOf(value);
		} catch (Exception e) {
			return false;
		}
		return true;
	}
}
