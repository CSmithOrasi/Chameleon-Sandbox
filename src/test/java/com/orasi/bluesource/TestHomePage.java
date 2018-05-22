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
        TestHelper.login(getEnvironmentURLRepository().getString("BLUESOURCE_QA"), "company.admin", "abcdefg");
        this.homePage = new HomePage();
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
}
