package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;

public class HomePage extends LoginPage{
    public HomePage (WebDriver driver){super(driver);
    }
       @FindBy(xpath = "//i[@class='icon-search']")
    protected WebElement findPatientRecordBtn;
    @FindBy(id = "org-openmrs-module-coreapps-activeVisitsHomepageLink-org-openmrs-module-coreapps-activeVisitsHomepageLink-extension")
    protected WebElement activeVisitsBtn;
    @FindBy(xpath = "//i[@class='icon-vitals']")
    protected WebElement captureVitalsBtn;
    @FindBy(xpath = "//i[@class='icon-user']")
    protected WebElement registerAPatientBtn;
    @FindBy(id = "appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")
    protected WebElement appointmentShedulingBtn;
    @FindBy(xpath = "//i[@class='icon-list-alt']")
    protected WebElement reportsBtn;
    @FindBy(xpath = "//i[@class='icon-hdd']")
    protected WebElement dataManagementBtn;
    @FindBy(xpath = "//i[@class='icon-tasks']")
    protected WebElement configureMetadataBtn;
    @FindBy(xpath = "//i[@class='icon-cogs']")
    protected WebElement systemAdministrationBtn;
    @FindBy(xpath = "//h4[contains(text(),'Logged in as Super User')]")
    protected WebElement superUserAdminHeader;
    public void verifyTitle(){
        wait.until(ExpectedConditions.titleIs("Home"));
        Assert.assertTrue(driver.getTitle().equals("Home"));
    }
    public void verifyAdminTitle() {
        Assert.assertTrue(superUserAdminHeader.isDisplayed());
    }
    public void verifyFunctionalities(){
        Assert.assertTrue(findPatientRecordBtn.isDisplayed());
        Assert.assertTrue(findPatientRecordBtn.isEnabled());
        Assert.assertTrue(activeVisitsBtn.isDisplayed());
        Assert.assertTrue(activeVisitsBtn.isEnabled());
        Assert.assertTrue(captureVitalsBtn.isDisplayed());
        Assert.assertTrue(captureVitalsBtn.isEnabled());
        Assert.assertTrue(registerAPatientBtn.isDisplayed());
        Assert.assertTrue(registerAPatientBtn.isEnabled());
        Assert.assertTrue(appointmentShedulingBtn.isDisplayed());
        Assert.assertTrue(appointmentShedulingBtn.isEnabled());
        Assert.assertTrue(reportsBtn.isDisplayed());
        Assert.assertTrue(reportsBtn.isEnabled());
        Assert.assertTrue(dataManagementBtn.isDisplayed());
        Assert.assertTrue(dataManagementBtn.isEnabled());
        Assert.assertTrue(configureMetadataBtn.isDisplayed());
        Assert.assertTrue(configureMetadataBtn.isEnabled());
        Assert.assertTrue(systemAdministrationBtn.isDisplayed());
        Assert.assertTrue(systemAdministrationBtn.isEnabled());
    }

}
