package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import utilities.GeneralUtility;

public class HorseDetails extends GeneralUtility {

    public HorseDetails(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@id='onetrust-accept-btn-handler']")
    WebElement btn_acceptCookies;

    @FindBy(xpath = "//input[@id='ass_confirm']")
    WebElement btn_checkbox;

    @FindBy(id = "name_of_horse")
    WebElement txt_horseDetails;

    @FindBy(id = "txt_age_of_horse1")
    WebElement drpdown_age;

    @FindBy(id = "horse_breed")
    WebElement drpdown_breed;

    @FindBy(xpath = "//select[@name='horse_sex']")
    WebElement drpdown_sex;

    @FindBy(xpath = "//select[@name='height1']")
    WebElement drpdown_height;

    @FindBy(xpath = "//select[@id='colour']")
    WebElement drpdown_colour;

    @FindBy(xpath = "//input[@id='horseOwned']")
    WebElement ownedRadioButton;

    @FindBy(xpath = "//input[@id='horseOnLoan' and @value='on_loan']")
    WebElement onLoanRadioButton;

    @FindBy(id = "horse_DOP_day")
    WebElement dayDropdown;

    @FindBy(name = "horse_DOP_month")
    WebElement monthDropdown;

    @FindBy(name = "horse_DOP_year")
    WebElement yearDropdown;

    @FindBy(id = "price_paid")
    WebElement txt_purchasePrice;

    @FindBy(id = "insured_amount")
    WebElement txt_sumInsured;

    @FindBy(linkText = "Next")
    WebElement nextButton;

    public void acceptCookies() {

        waitForElementToBeClickable(btn_acceptCookies).click();
    }

    public void clickCheckBox() {

        waitForElementToBeClickable(btn_checkbox).click();
    }

    public void getHorseName(String name) {
        txt_horseDetails.sendKeys(name);
    }

    public void selectHorseDetails(String age, String breed, String sex, String height, String colour) {
        Select horseAge = new Select(waitForElementToBeVisible(drpdown_age));
        horseAge.selectByVisibleText(age);

        Select horseBreed = new Select(waitForElementToBeVisible(drpdown_breed));
        horseBreed.selectByVisibleText(breed);

        Select horseSex = new Select(waitForElementToBeVisible(drpdown_sex));
        horseSex.selectByVisibleText(sex);

        Select horseHeight = new Select(drpdown_height);
        horseHeight.selectByVisibleText(height);

        Select horseColour = new Select(waitForElementToBeVisible(drpdown_colour));
        horseColour.selectByVisibleText(colour);
    }

    public void selectRadioButton(String plan) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        switch (plan.toLowerCase()) {
            case "owned":
                if (!ownedRadioButton.isSelected()) {
                    executor.executeScript("arguments[0].click();", ownedRadioButton);
                }
                break;
            case "on_loan":
                if (!onLoanRadioButton.isSelected()) {
                    executor.executeScript("arguments[0].click();", onLoanRadioButton);
                }
                break;
            default:
                throw new IllegalArgumentException("Invalid plan value: " + plan);
        }
    }

    public void selectPurchaseDate(String date) {
        String[] dateOfPurchase = date.split("-");
        String day = dateOfPurchase[0];
        String month = dateOfPurchase[1];
        String year = dateOfPurchase[2];

        Select purchaseDay = new Select(dayDropdown);
        purchaseDay.selectByVisibleText(day);

        Select purchaseMonth = new Select(monthDropdown);
        purchaseMonth.selectByVisibleText(month);

        Select purchaseYear = new Select(yearDropdown);
        purchaseYear.selectByVisibleText(year);
    }

    public void getPurchasePrice(String purchasePrice) {
        txt_purchasePrice.sendKeys(purchasePrice);
    }

    public void getSumInsured(String sumInsured) {
        txt_sumInsured.sendKeys(sumInsured);
    }

    public void clickNextButton() {

        waitForElementToBeClickable(nextButton).click();
    }
}
