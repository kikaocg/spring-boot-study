package com.study.api.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {
	
	public static String createBCrypt(String password) {
		if (password == null) {
			return password;
		}
		return new BCryptPasswordEncoder().encode(password);
	}
	
	public static boolean passwordIsValid(String rawPassword, String encodedPassword) {
		return new BCryptPasswordEncoder().matches(rawPassword, encodedPassword);
	}

}
