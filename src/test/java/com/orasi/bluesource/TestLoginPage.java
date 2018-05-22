package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.DriverManagerFactory;
import com.orasi.DriverType;
import com.orasi.web.WebBaseTest;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestLoginPage extends WebBaseTest {
    @BeforeMethod
    public void setup() {
        DriverManagerFactory.getManager(DriverType.CHROME).initalizeDriver();
    }

    @AfterMethod
    public void close(){
        DriverManager.quitDriver();
    }

    @Test
    public void login() {
        DriverManager.getDriver().get(getEnvironmentURLRepository().getString("BLUESOURCE_QA"));
        LoginPage loginpage = new LoginPage();

        boolean logInSuccessful = loginpage.login("company.admin", "abcdefg");

        Assert.assertTrue(logInSuccessful);
    }
}
