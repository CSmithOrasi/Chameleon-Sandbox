package com.orasi.bluesource;

import com.orasi.DriverManager;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Listbox;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.Webtable;
import com.orasi.web.webelements.impl.internal.ElementFactory;
import org.openqa.selenium.support.FindBy;

public class AccountsPage {
    @FindBy(xpath = "//button[@data-target=\"#modal_1\"]") private Button btnAdd;
    @FindBy(xpath = "//input[@id=\"account_name\"]") private Textbox tbAccountName;
    @FindBy(xpath = "//select[@id='account_industry_id']") private Listbox lstIndustry;
    @FindBy(xpath = "//input[@value=\"Create Account\"]") private Button btnSubmit;
    @FindBy(xpath = "//input[@id=\"search-bar\"]") private Textbox searchBar;
    @FindBy(xpath = "//*[@id=\"resource-content\"]/div[1]/table") private Webtable tblEmployee;

    public AccountsPage() {
        ElementFactory.initElements(DriverManager.getDriver(), this);
    }

    public boolean addAccount() {
    	String accountName = "Fake Account 1";
    	
        this.btnAdd.click();
        this.tbAccountName.sendKeys(accountName);
        this.lstIndustry.select("Other");
        this.btnSubmit.click();
        this.searchBar.sendKeys(accountName);
        
        return this.tblEmployee.getCell(2, 1).getText().contains(accountName);
    }

    
}
