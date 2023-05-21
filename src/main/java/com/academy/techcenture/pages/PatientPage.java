package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PatientPage extends LoginPage{
    public PatientPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='float-sm-right']/span")
    protected WebElement patientId;
    @FindBy(xpath = "//span[@class='PersonName-givenName']")
    protected WebElement patientGivenName;
    @FindBy(xpath = "//span[@class='PersonName-familyName']")
    protected WebElement patientFamilyName;
    @FindBy(xpath = "//div[@class='gender-age col-auto']/span[1]")
    protected WebElement patientGender;
    @FindBy(xpath = "//div[@class='gender-age col-auto']/span[2]")
    protected WebElement patientDob;
    public void verifyTitle(){
       Assert.assertTrue(driver.getTitle().equals("OpenMRS Electronic Medical Record"));
    }
    public void verifyPatientGivenName(String actualGivenName){
        String givenName = patientGivenName.getText();
        Assert.assertEquals("Given name is incorrect", givenName, actualGivenName);
    }
    public void verifyPatientFamilyName(String actualFamilyName){
        String familyName = patientFamilyName.getText();
        Assert.assertEquals("Family name is incorrect", familyName, actualFamilyName);
    }
    public void verifyPatientGender(String actualGender){
        String gender = patientGender.getText().trim();
        Assert.assertEquals("Gender is incorrect", gender, actualGender);
    }
    public void verifyDob(String day, String month, String year){
        String dob = patientDob.getText();
        String patientDob = day + "." + month + "." + year;
        boolean containsActualDob = dob.contains(patientDob);
        Assert.assertTrue("DOB is incorrect", containsActualDob);
    }
    public void verifyPatientId(){
        Assert.assertTrue(patientId.isDisplayed());
    }

}
