package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ActivityGroup {

    public WebDriver driver;

    public ActivityGroup(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "label[for='activityGroup1']")
    WebElement selectGroup1;

    @FindBy(css = "label[for='activityGroup2']")
    WebElement selectGroup2;

    @FindBy(css = "label[for='activityGroup3']")
    WebElement selectGroup3;

    @FindBy(css = "label[for='activityGroup4']")
    WebElement selectGroup4;

    @FindBy(css = "label[for='activityGroup5']")
    WebElement selectGroup5;

    @FindBy(css = "label[for='activityGroup6']")
    WebElement selectGroup6;



    public void selectActivityGroup(String activityGroup) {
        switch (activityGroup) {
            case "Group 1":
                selectGroup1.click();
                break;
            case "Group 2":
                selectGroup2.click();
                break;
            case "Group 3":
                selectGroup3.click();
                break;
            case "Group 4":
                selectGroup4.click();
                break;
            case "Group 5":
                selectGroup5.click();
                break;
            case "Group 6":
                selectGroup6.click();
                break;
            default:
                throw new IllegalArgumentException("Invalid activity group value: " + activityGroup);
        }
    }








}
