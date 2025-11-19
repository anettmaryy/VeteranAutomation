package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtility;


public class PolicyHolderDetails extends GeneralUtility {


    public PolicyHolderDetails(WebDriver driver) {
        super(driver);
        //this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(name = "title")
    WebElement drpdown_Title;

    @FindBy(name = "first_name")
    WebElement txt_Name;

    @FindBy(name = "surname")
    WebElement txt_Surname;

    @FindBy(name = "client_dob_Day")
    WebElement dobDayDropdown;

    @FindBy(name = "client_dob_Month")
    WebElement dobMonthDropdown;

    @FindBy(name = "client_dob_Year")
    WebElement dobYearDropdown;

    @FindBy(id = "postcode")
    WebElement txt_Postcode;

    @FindBy(id = "btnFindAddress")
    WebElement searchAddress;

    @FindBy(id = "address")
    WebElement addressDropdown;

    @FindBy(name = "email1")
    WebElement txt_Email;

    @FindBy(name = "daytime_tel")
    WebElement txt_Mobile;

    @FindBy(xpath = "//input[@id='disclaimer_quotefollowup']")
    WebElement button_checkbox;

    @FindBy(xpath = "//a[@title='NEXT']")
    WebElement clickNext;

    public void enterCustomerName(String title, String firstName, String lastName) {
        Select titleDropdown = new Select(drpdown_Title);
        titleDropdown.selectByVisibleText(title);
        txt_Name.sendKeys(firstName);
        txt_Surname.sendKeys(lastName);
    }

    public void enterCustomerDOB(String date) {
        String[] dateOfBirth = date.split("-");
        String day = dateOfBirth[0];
        String month = dateOfBirth[1];
        String year = dateOfBirth[2];

        Select dayDD = new Select(dobDayDropdown);
        dayDD.selectByVisibleText(day);

        Select monthDD = new Select(dobMonthDropdown);
        monthDD.selectByVisibleText(month);

        Select yearDD = new Select(dobYearDropdown);
        yearDD.selectByVisibleText(year);
    }

    public void enterCustomerPostCode(String postCode, String address) throws InterruptedException {
        txt_Postcode.sendKeys(postCode);
        searchAddress.click();
        Thread.sleep(1000);

        Select addressDD = new Select(addressDropdown);
        Thread.sleep(1000);
        addressDD.selectByVisibleText(address);
        Thread.sleep(1000);
    }

    public void enterCustomerDetails(String email, String mobileNumber) {
        txt_Email.sendKeys(email);
        txt_Mobile.sendKeys(mobileNumber);
    }

    public void clickCheckbox() {

        waitForElementToBeClickable(button_checkbox).click();
    }

    public void clickNextButton() {

        waitForElementToBeClickable(clickNext).click();
    }
}
