package com.academy.techcenture.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.io.PrintWriter;

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
    @FindBy(xpath = "//i[@class='icon-sticky-note']")
    protected WebElement stickyNoteLink;
    @FindBy(xpath = "//textarea[@placeholder='Enter a note']")
    protected WebElement textArea;
    @FindBy(xpath = "//button[@class='btn btn-primary']")
    protected WebElement checkNoteBtn;
    @FindBy(xpath = "//pre[@class='preformatted-note ng-binding']")
    protected WebElement noteText;
    @FindBy(xpath = "//h3[text()='General Actions']")
    protected WebElement generalActionsMenu;
    @FindBy(xpath = "//div[@class='logo']")
    protected WebElement homePageBtn;
    @FindBy(xpath = "//p[contains(text(), 'Created Patient Record:')]")
    protected WebElement successCreatingPatientMsg;
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
    public void clickonStickynotelink(){
        stickyNoteLink.click();
    }
    public void enterTextInNoteArea(){
        textArea.sendKeys("Hello");
    }
    public void clickOnCheckNoteBtn(){
        checkNoteBtn.click();
    }
    public void verifyNoteText(){
        Assert.assertTrue(noteText.isDisplayed());
    }
    public void verifyGeneralActionsMenu(){
        Assert.assertTrue(generalActionsMenu.isDisplayed());
    }
    public void getPatientId() throws IOException {
        String patientIdTxt = patientId.getText().trim();
        System.out.println(patientIdTxt);
        PrintWriter out = new PrintWriter("src/main/resources/patientid.txt");
        out.println(patientIdTxt);
        out.close();
                    }
    public String patientId(){
        String patientIdTxt = patientId.getText().trim();
        return patientIdTxt;
    }
    public void clickOnHomePageBtn(){
        homePageBtn.click();
    }
    public void verifyPatientCreatedMsg(String givenName, String familyName) throws InterruptedException {
        Thread.sleep(5000);
        String patientTxt = successCreatingPatientMsg.getAttribute("textContent");
        String patientNameGivenLeft = patientGivenName.getText();
        System.out.println("Name on left "+ patientNameGivenLeft);
        String patientName = givenName + " " + familyName;
        System.out.println("Patient 1 : " + patientTxt);
        System.out.println("Patient 2 : " + patientName);
        boolean containsCreatedName = patientTxt.contains(patientName);
        Assert.assertTrue("Name is incorrect", containsCreatedName);

    }

}
