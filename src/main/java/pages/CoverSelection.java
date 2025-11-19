package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.Select;

import utilities.GeneralUtility;





public class CoverSelection extends GeneralUtility  {


    public WebDriver driver;

    public CoverSelection(WebDriver driver)
    {
        super(driver);
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    @FindBy(name="death_theft_and_straying")
    WebElement drp_PlanToSelect;

    @FindBy(name="third_party_liability")
    WebElement drp_TPL;

    @FindBy(name="personal_accident")
    WebElement drp_PA;

    @FindBy(name="vets_fees")
    WebElement drp_VF;

    @FindBy(name="disposal")
    WebElement drp_Disposal;

    @FindBy(id="saddlery_and_tack_value")
    WebElement drp_SaddleTack;

    @FindBy(name="trailer_horse_drawn_vehicle_value")
    WebElement drp_HorseTrailer;

    @FindBy(name="type_of_veh")
    WebElement drp_TypeOfVehicle;

    @FindBy(name="make_of_veh")
    WebElement txt_MakeOfVehicle;

    @FindBy(name="model_of_veh")
    WebElement txt_ModelOfVehicle;

    @FindBy(name="price_paid_veh")
    WebElement txt_PricePaidVehicle;

    @FindBy(name="sum_insure_veh")
    WebElement txt_SumInsuredVehicle;



    @FindBy(xpath = "//a[@title='GET QUOTE']")
    WebElement btn_Next;



    public void basicCover(String DTS, String TPL, String PA) {

        Select selectPlan = new Select(drp_PlanToSelect);
        selectPlan.selectByVisibleText(DTS);

        Select selectTPL = new Select(drp_TPL);
        selectTPL.selectByVisibleText(TPL);

        Select selectPA = new Select(drp_PA);
        selectPA.selectByVisibleText(PA);
    }






    public void optionalCover1(String VF) {

        Select selectVF = new Select(drp_VF);
        selectVF.selectByVisibleText(VF);

    }

    public void optionalCover2(String disposal) {

        Select selectDisposal = new Select(drp_Disposal);
        selectDisposal.selectByValue(disposal);
    }
    public void optionalCover3(String saddleTack) {
        Select selectSaddleTack = new Select(drp_SaddleTack);
        selectSaddleTack.selectByVisibleText(saddleTack);
    }

    public void optionalCover4(String horseTrailer,String typeOfVehicle, String makeOfVehicle, String modelOfVehicle,String pricePaidVehicle,String sumInsuredVehicle) {


        Select selectHorseTrailer = new Select(drp_HorseTrailer);
        selectHorseTrailer.selectByVisibleText(horseTrailer);

        Select selectTypeOfVehicle = new Select(drp_TypeOfVehicle);
        selectTypeOfVehicle.selectByVisibleText(typeOfVehicle);

        waitForElementToBeVisible(txt_MakeOfVehicle).sendKeys(makeOfVehicle);
        waitForElementToBeVisible(txt_ModelOfVehicle).sendKeys(modelOfVehicle);
        waitForElementToBeVisible(txt_PricePaidVehicle).sendKeys(pricePaidVehicle);
        waitForElementToBeVisible(txt_SumInsuredVehicle).sendKeys(sumInsuredVehicle);





    }



    public void selectNextButton() {

        waitForElementToBeClickable(btn_Next).click();




    }


}

