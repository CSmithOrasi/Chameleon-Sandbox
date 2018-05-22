package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.impl.internal.ElementFactory;
import org.openqa.selenium.support.FindBy;

public class AccountsPage {
    private OrasiDriver driver;
    @FindBy(xpath = "//button[@data-target=\"#modal_1\"]") private Button btnAdd;

    public AccountsPage(OrasiDriver driver) {
        this.driver = driver;
        ElementFactory.initElements(DriverManager.getDriver(), this);
    }

    public void addAccount() {
        this.btnAdd.click();
    }

}
