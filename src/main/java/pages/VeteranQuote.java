package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.GeneralUtility;



public class VeteranQuote extends GeneralUtility {

    public VeteranQuote(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Save your quote']")
    WebElement btn_Save;

    @FindBy(name="cover_conf_check")
    WebElement btn_CoverCheckbox;

    @FindBy(xpath = "//*[@id='formDiv']/form/table[1]/tbody/tr[1]/td[2]")
    WebElement quoteValueElement;

    @FindBy(xpath="//*[@id='formDiv']/form/table[2]/tbody/tr[3]/td[2]/span")
    WebElement annualPremium;

    @FindBy(xpath="//*[@id=\"formDiv\"]/form/table[2]/tbody/tr[7]/td[2]/span")
    WebElement monthlyPremium;

    @FindBy(xpath="//a[@title='TAKE OUT COVER']")
    WebElement yesContinue;




    public void clickCoverCheckBox() {

        waitForElementToBeClickable(btn_CoverCheckbox).click();
    }

    public void selectSaveQuote() {
        waitForElementToBeClickable(btn_Save).click();

    }

    public String printQuoteReference() {

        String quoteText = quoteValueElement.getText().trim();
        System.out.println("Quote Reference: " + quoteText);
        return quoteText;

    }


    public String getPremiumValue() {

        String premiumText = annualPremium.getText().trim();

        // Remove the currency symbol and parse the numeric part as a double
        String numericPart = premiumText.replace("£", "").trim();

        // Convert the numeric part to a double
        double premiumValue = Double.parseDouble(numericPart);
        System.out.println("Annual Premium: " + premiumValue);
        return numericPart;
    }

    public String getMonthlyPremiumValue() {

        String premiumText = monthlyPremium.getText().trim();

        // Remove the currency symbol and parse the numeric part as a double
        String numericPart = premiumText.replace("£", "").trim();

        // Convert the numeric part to a double
        double premiumValue = Double.parseDouble(numericPart);
        System.out.println("Monthly Premium: " + premiumValue);

        return numericPart;



    }
    public void selectYesContinue() {
        waitForElementToBeClickable(yesContinue).click();
    }

}
