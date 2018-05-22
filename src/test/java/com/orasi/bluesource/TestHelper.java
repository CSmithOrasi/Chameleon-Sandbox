package com.orasi.bluesource;

import com.orasi.DriverManager;

public class TestHelper {
	public static void login(String url, String username, String password) {
        DriverManager.getDriver().get(url);
        LoginPage loginpage = new LoginPage();

        loginpage.login(username, password);
	}
}
