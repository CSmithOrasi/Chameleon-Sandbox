package com.orasi.bluesource;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.orasi.DriverManager;
import com.orasi.DriverManagerFactory;
import com.orasi.DriverType;
import com.orasi.web.WebBaseTest;

public class TestAccountPage extends WebBaseTest {
	private AccountPage accountPage;

    @BeforeMethod
    public void setup() {
    	String url = getEnvironmentURLRepository().getString("BLUESOURCE_QA");
        DriverManagerFactory.getManager(DriverType.CHROME).initalizeDriver();
        TestHelper.login(url, "company.admin", "abcdefg");
        DriverManager.getDriver().get(url + "/accounts/67");
        this.accountPage = new AccountPage();
    }

    @AfterMethod
    public void close(){
        DriverManager.quitDriver();
    }

    @Test
    public void addProject() {
    	Assert.assertTrue(this.accountPage.addProject());
    	
    }
}
