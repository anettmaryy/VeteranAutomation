package stepDefinition.compositestepmethods;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import pages.PaymentDetails;
import utilities.ReportManager;


import java.time.Duration;

public class PaymentDetailsFlow extends PaymentDetails {


    PaymentDetails paymentFlow = new PaymentDetails(driver);


    public PaymentDetailsFlow(WebDriver driver) {

        super(driver);


    }

    public void directDebit_Annually_Monthly(WebDriver driver, ExtentTest node) {

        paymentFlow.directMonthlyAnnually(BaseTest.getData().get("AccountHolder"), BaseTest.getData().get("AccountNo"), BaseTest.getData().get("SortCode"), node);


    }


    public void enterCardName(){
        paymentFlow.enterCardHolderName(BaseTest.getData().get("AccountHolder"));
    }

    public void credit_debit_Card_Annual(WebDriver driver, ExtentTest node) throws InterruptedException {

        if (BaseTest.getData().get("CardRegistered").equalsIgnoreCase("yes")) {
            paymentFlow.selectYes();
        } else {
            paymentFlow.selectNoFillAddressandProceed(BaseTest.getData().get("CardPostCode"),
                    BaseTest.getData().get("CardAddress"));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        paymentFlow.copsFill(BaseTest.getData().get("CardNumber"), BaseTest.getData().get("ExpiryMonth"),
                BaseTest.getData().get("ExpiryYear"), BaseTest.getData().get("CardSecurityCode"));

        ReportManager.log(Status.PASS, "Payment Details entered", driver, node);
        paymentFlow.payNow();
    }









}
