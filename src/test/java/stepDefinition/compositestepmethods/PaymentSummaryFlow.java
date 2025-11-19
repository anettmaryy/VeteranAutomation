package stepDefinition.compositestepmethods;

import base.BaseTest;
import org.openqa.selenium.WebDriver;
import pages.PaymentSummary;

public class PaymentSummaryFlow extends PaymentSummary {

    PaymentSummary PaymentSummaryPage = new PaymentSummary(driver);


    public PaymentSummaryFlow(WebDriver driver) {

        super(driver);


    }

    public void selectDonation(){
        PaymentSummaryPage.selectDonation(BaseTest.getData().get("CharitableTrust"));
    }

    public void selectPaymentOption(String option)  {

        PaymentSummaryPage.selectPaymentOption(BaseTest.getData().get("PaymentOption"));

    }
    public void nextStepClickButton(){
        PaymentSummaryPage.selectClickNextStep();

    }
}