package com.revature.projectzero.security;

public class SecureUtils {
	private SecureUtils() {}
	
	private static String[] usedKeyWords= {
		"SELECT",
		"CREATE",
		"ALTER",
		"DROP",
		"TRUNCATE",
		"RENAME",
		"UPDATE",
		"INSERT",
		"DELETE",
		"GRANT",
		"REVOKE",
		"FROM",
		"TO",
		"INTO",
		"BY",
		"GROUP",
		"ORDER",
		"REPLACE",
		"AND",
		"OR",
		"PROCEDURE",
		"FUNCTION",
		"WHERE",
		"ON",
		"HAVING"
	};
	
	public static String sanitiseString(String s) {
		return s;
	}
}
