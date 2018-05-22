package com.orasi.bluesource;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orasi.DriverManager;
import com.orasi.DriverManagerFactory;
import com.orasi.DriverType;
import com.orasi.web.WebBaseTest;

public class TestAccountsPage extends WebBaseTest {
    private AccountsPage accountsPage;

    @BeforeMethod
    public void setup() {
    	String url = getEnvironmentURLRepository().getString("BLUESOURCE_QA");
        DriverManagerFactory.getManager(DriverType.CHROME).initalizeDriver();
        TestHelper.login(url, "company.admin", "abcdefg");
        DriverManager.getDriver().get(url + "/accounts");
        this.accountsPage = new AccountsPage();
    }

    @AfterMethod
    public void close(){
        DriverManager.quitDriver();
    }

    @Test
    public void addAccount() {
    	Assert.assertTrue(this.accountsPage.addAccount());
    }
}
