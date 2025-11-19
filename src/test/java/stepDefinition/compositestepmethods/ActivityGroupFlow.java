package stepDefinition.compositestepmethods;
import org.openqa.selenium.WebDriver;
import base.BaseTest;
import pages.ActivityGroup;



public class ActivityGroupFlow extends ActivityGroup {

    ActivityGroup groupSelect = new ActivityGroup(driver);



    public ActivityGroupFlow(WebDriver driver) {

        super(driver);


    }

    public void selectActivityGroup(String activityGroup) {
        groupSelect.selectActivityGroup(BaseTest.getData().get("ActivityGroup"));

    }

    public void clickActivityNextPage(){
        PolicyHolderFlow policyHolderFlow = new PolicyHolderFlow(driver);

        policyHolderFlow.clickNextButton();

    }


}

