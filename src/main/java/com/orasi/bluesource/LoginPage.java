package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    private OrasiDriver driver;
    @FindBy(xpath = "//*[@id = \"employee_username\"]") private Textbox usernameTextBox;
    @FindBy(xpath = "//*[@id = \"employee_password\"]") private Textbox passwordTextBox;
    @FindBy(xpath = "//*[@name = \"commit\"]") private Button loginButton;

    public LoginPage(OrasiDriver driver) {
        this.driver = driver;
        ElementFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean login(String username, String password) {
        usernameTextBox.sendKeys(username);
        passwordTextBox.sendKeys(password);
        loginButton.click();

        return driver.findElement(By.xpath("//*[@id=\"all-content\"]/h1")).getText().contains("Welcome,");
    }
}
