package stepDefinition.compositestepmethods;

import org.openqa.selenium.WebDriver;
import base.BaseTest;
import pages.PolicyHolderDetails;

public class PolicyHolderFlow extends PolicyHolderDetails {

    PolicyHolderDetails PolicyDetails = new PolicyHolderDetails(driver);


    public PolicyHolderFlow(WebDriver driver) {

        super(driver);


    }

    public void enterPolicyHolderDetails() throws InterruptedException {
        PolicyDetails.enterCustomerName(BaseTest.getData().get("Title"),BaseTest.getData().get("FirstName"),BaseTest.getData().get("SurName") );
        PolicyDetails.enterCustomerDOB(BaseTest.getData().get("DateOfBirth"));
        PolicyDetails.enterCustomerPostCode(BaseTest.getData().get("PostCode"),BaseTest.getData().get("SelectAddress"));
        PolicyDetails.enterCustomerDetails(BaseTest.getData().get("Email"),BaseTest.getData().get("MobileNo"));
        PolicyDetails.clickCheckbox();


    }
    public void clickPolicyNextButton(){
        PolicyDetails.clickNextButton();
    }
}