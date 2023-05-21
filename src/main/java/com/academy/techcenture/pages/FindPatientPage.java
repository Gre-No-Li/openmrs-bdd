package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class FindPatientPage extends LoginPage{
    public FindPatientPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div/h2")
    protected WebElement findPatientHeader;
    @FindBy(id = "patient-search")
    protected WebElement patientSearchInput;
    @FindBy(xpath = "//tr/td[5]")
    protected WebElement patientDob;
    public void verifyTitle(){
        wait.until(ExpectedConditions.titleIs("OpenMRS Electronic Medical Record"));
        Assert.assertTrue(driver.getTitle().equals("OpenMRS Electronic Medical Record"));
        String patientHeaderText = findPatientHeader.getText().trim();
        Assert.assertEquals("Header is incorrect", "Find Patient Record", patientHeaderText);
    }
    public void enterIdInSearchInput(String patientIdTxt){
        patientSearchInput.sendKeys(patientIdTxt);
    }
    public void verifyDob(String day, String month, String year){
        String dob = patientDob.getText();
        String patientDob = day + " " + month + " " + year;
        boolean containsActualDob = dob.contains(patientDob);
        Assert.assertTrue("DOB is incorrect", containsActualDob);
    }

}
