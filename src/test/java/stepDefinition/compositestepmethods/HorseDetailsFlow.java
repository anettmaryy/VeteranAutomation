package stepDefinition.compositestepmethods;

import org.openqa.selenium.WebDriver;
import pages.HorseDetails;
import base.BaseTest;

public class HorseDetailsFlow extends HorseDetails {

    HorseDetails HorseDetailsPage = new HorseDetails(driver);



    public HorseDetailsFlow(WebDriver driver) {

        super(driver);


    }

    public void enterHorseDetails(){
        HorseDetailsPage.getHorseName(BaseTest.getData().get("HorseName"));
        HorseDetailsPage.selectHorseDetails(BaseTest.getData().get("HorseAge"),BaseTest.getData().get("HorseBreed"), BaseTest.getData().get("HorseSex"),BaseTest.getData().get("HorseHeight"), BaseTest.getData().get("HorseColour"));
        HorseDetailsPage.selectRadioButton(BaseTest.getData().get("OwnedorLoan"));
        HorseDetailsPage.selectPurchaseDate(BaseTest.getData().get("DateOfPurchase"));
        HorseDetailsPage.getPurchasePrice(BaseTest.getData().get("PurchasePrice"));
        HorseDetailsPage.getSumInsured(BaseTest.getData().get("SumInsured"));


    }

    public void clickHorseNext(){
        HorseDetailsPage.clickNextButton();

    }

}
