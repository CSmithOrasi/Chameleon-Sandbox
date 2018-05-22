package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.DriverManagerFactory;
import com.orasi.DriverType;
import com.orasi.web.WebBaseTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestHomePage extends WebBaseTest {
    private HomePage homePage;

    @BeforeMethod
    public void setup() {
        DriverManagerFactory.getManager(DriverType.CHROME).initalizeDriver();
        this.login();
        this.homePage = new HomePage(DriverManager.getDriver());
    }

    @AfterMethod
    public void close(){
        DriverManager.quitDriver();
    }

    @Test
    public void searchDirectory() {
        homePage.enterSearchBarText("qqqq");

        Assert.assertTrue(homePage.getFirstEmployeeName().equals("qqqq wwww"));
    }

    /**
     * TODO: Refactor to package helper class (?)
     */
    private void login() {
        DriverManager.getDriver().get(getEnvironmentURLRepository().getString("BLUESOURCE_QA"));
        LoginPage loginpage = new LoginPage(DriverManager.getDriver());

        loginpage.login("company.admin", "abcdefg");
    }
}
