package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.web.OrasiDriver;
import com.orasi.web.webelements.Listbox;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;
import org.openqa.selenium.support.FindBy;

public class HomePage {
    private OrasiDriver driver;
    @FindBy(xpath = "//nav") private Listbox nav;
    @FindBy(xpath = "//input[@id=\"search-bar\"]") private Textbox searchBar;
    @FindBy(xpath = "//*[@id=\"resource-content\"]/div[1]/table") private Webtable tblEmployee;

    public HomePage(OrasiDriver driver) {
        this.driver = driver;
        ElementFactory.initElements(DriverManager.getDriver(), this);
    }

    public void enterSearchBarText(String text) {
        this.searchBar.sendKeys(text);
    }

    public String getFirstEmployeeName() {
        return this.tblEmployee.getCell(2,1).getText() + " " +
                this.tblEmployee.getCell(2,2).getText();
    }
}
