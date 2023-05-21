package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));
    }
    @FindBy(id = "username")
    protected WebElement usernameInput;
    @FindBy(id = "password")
    protected WebElement passwordInput;
    @FindBy(id = "loginButton")
    protected WebElement loginBtn;
    @FindBy(id = "error-message")
    protected WebElement signinError;
    @FindBy(id = "cantLogin")
    protected WebElement cantloginLink;
    @FindBy(id = "Inpatient Ward")
    protected WebElement inpatientWardlink;

    public void verifyTitle(){
        wait.until(ExpectedConditions.titleIs("Login"));
        Assert.assertTrue(driver.getTitle().equals("Login"));
    }
    public void enterUserName(String userName){
        usernameInput.sendKeys(userName);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickOnInpatientWardLink(){
        Assert.assertTrue(inpatientWardlink.isEnabled());
        inpatientWardlink.click();
    }
    public void clickonloginBtn(){
        Assert.assertTrue(loginBtn.isEnabled());
        loginBtn.click();
    }
    public void enterInvalidPassword(String invalidPassword){
        passwordInput.sendKeys(invalidPassword);
    }
    public void verifyErrorMsg(String errorMsg){
        Assert.assertTrue("Sign in error was not displayed", signinError.isDisplayed());
        Assert.assertTrue("Error message is not correct", signinError.getText().trim().equals(errorMsg));
    }



}
