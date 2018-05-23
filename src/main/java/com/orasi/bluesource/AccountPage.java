package com.orasi.bluesource;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

import com.orasi.DriverManager;
import com.orasi.web.webelements.Button;
import com.orasi.web.webelements.Textbox;
import com.orasi.web.webelements.impl.internal.ElementFactory;

public class AccountPage {
	@FindBy(xpath = "//button[@data-target=\"#modal_1\"]") private Button btnNewProject;
	@FindBy(xpath = "//input[@id=\"project_name\"]") private Textbox tbProjectName;
	@FindBy(xpath = "//input[@name=\"commit\"]") private Button btnSubmit;
	@FindBy(xpath = "//input[@id=\"project_start_date\"]") private Textbox tbStartDate;
	@FindBy(xpath = "//input[@id=\"project_end_date\"]") private Textbox tbEndDate;
	
    public AccountPage() {
        ElementFactory.initElements(DriverManager.getDriver(), this);
    }
    
    public boolean addProject() {
    	this.btnNewProject.click();
    	this.tbProjectName.sendKeys("Fake Project");
    	this.tbStartDate.sendKeys("06012008");
    	this.tbEndDate.sendKeys("06012009");
    	this.btnSubmit.click();
    	
    	// TODO: Replace placeholder w success condition
    	return !DriverManager.getDriver().findElements(By.linkText("Fake Project")).isEmpty();
    }
}
