package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.GeneralUtility;



public class PaymentSummary extends GeneralUtility {



    public PaymentSummary(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='charity_donation']")
    WebElement btn_donation;

    @FindBy(xpath = "(//label[@for='paymentMethodDDA'])[2]")
    WebElement DirectDebitAnnual;

    @FindBy(xpath = "(//label[@for='paymentMethodDDM'])[2]")
    WebElement DirectDebitMonthly;


    @FindBy(xpath = "(//label[@for='paymentMethodCC'])[2]")
    WebElement CreditOrDebit;

    @FindBy(xpath = "//a[@title='NEXT STEP']")
    WebElement Next_Click;


    public void selectDonation(String option) {
        if (option.equals("yes")) {
            btn_donation.click();
        } else if (option.equals("no")) {
            System.out.println("Donation not added");
        }
    }






    public void selectPaymentOption(String option)  {
        switch (option) {
            case "DD Annually":
                DirectDebitAnnual.click();
                break;
            case "DD Monthly":
                DirectDebitMonthly.click();
                break;
            case "CC":
                CreditOrDebit.click();
                break;

            default:
                throw new IllegalArgumentException("Invalid activity group value: " + option);
        }


    }

    public void selectClickNextStep()  {

        waitForElementToBeClickable(Next_Click).click();


    }


}
