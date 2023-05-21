package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPage extends LoginPage {
    public RegisterPage (WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='givenName']")
    protected WebElement givenNameInput;
    @FindBy(xpath = "//input[@name='familyName']")
    protected WebElement familyNameInput;
    @FindBy(id = "next-button")
    protected WebElement nextBtn;
    @FindBy(xpath = "//option[@value='M']")
    protected WebElement maleGender;
    @FindBy(id = "birthdateDay-field")
    protected WebElement birthDateDayInput;
    @FindBy(id = "birthdateYear-field")
    protected WebElement birthDateYearInput;
    @FindBy(id = "birthdateMonth-field")
    protected WebElement birthDateMonthCheckBox;
    @FindBy(xpath = "//option[@value='3']")
    protected WebElement marchMonthCheckBox;
    @FindBy(id = "address1")
    protected WebElement addressInput;
    @FindBy(xpath = "//input[@name='phoneNumber']")
    protected WebElement phoneInput;
    @FindBy(id = "relationship_type")
    protected WebElement relationshipTypeSelect;
    @FindBy(xpath = "//option[@data-val='Doctor']")
    protected WebElement doctorRelationshipType;
    @FindBy(id = "submit")
    protected WebElement confirmBtn;
    public void verifyTitle(){
        Assert.assertTrue(driver.getTitle().equals("OpenMRS Electronic Medical Record"));
    }
    public void enterGivenName(String givenName){
        givenNameInput.sendKeys(givenName);
    }
    public void enterFamilyName(String familyName){
        familyNameInput.sendKeys(familyName);
    }
    public void clickOnNextBtn(){
        nextBtn.click();
    }
    public void selectMaleGender(){
        maleGender.click();
    }
    public void enterBirthDay(String birthDay){
        birthDateDayInput.sendKeys(birthDay);
    }
    public void enterBirthYear(String birthYear){
        birthDateYearInput.sendKeys(birthYear);
    }
    public void selectBirthMonth(){
        birthDateMonthCheckBox.click();
        marchMonthCheckBox.click();
            }
    public void enterAddress(String address){
        addressInput.sendKeys(address);
    }
    public void enterPhone(String phoneNumber){
        phoneInput.sendKeys(phoneNumber);
    }
    public void selectRelationshipType(){
        relationshipTypeSelect.click();
        doctorRelationshipType.click();
    }
    public void clickOnConfirmBtn(){
        Assert.assertTrue(confirmBtn.isEnabled());
        confirmBtn.click();
    }


}
