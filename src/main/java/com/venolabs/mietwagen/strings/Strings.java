package com.venolabs.mietwagen.strings;

public final class Strings {

	private static String[] strings;

	private Strings() {		
	}
	
	static {
		strings = new Localization().getStrings();
	}
	
	public static final String CLIENT_IS_INDEBITED = strings[0];
	public static final String RENTAL_GRANTED = strings[1];
	public static final String CAR_WILL_BE_DELIVERED_IN = strings[2];
	public static final String CAR_RENT_NOT_REGISTERED = strings[3];
	public static final String CAR_RETURN_SUCESS = strings[4];
	
}
