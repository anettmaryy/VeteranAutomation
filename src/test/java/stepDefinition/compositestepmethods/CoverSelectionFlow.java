package stepDefinition.compositestepmethods;
import org.openqa.selenium.WebDriver;
import base.BaseTest;
import pages.CoverSelection;


public class CoverSelectionFlow extends CoverSelection {


    CoverSelection coverSelectionPage = new CoverSelection(driver);



    public CoverSelectionFlow(WebDriver driver) {
        super(driver);

    }

    public void selectBasicCover() {
        // Select the mandatory basic cover
        coverSelectionPage.basicCover(BaseTest.getData().get("DeathFromInjury"), BaseTest.getData().get("TPL"), BaseTest.getData().get("PA"));


    }

    public void selectOptionalCover(String option) {
        switch(option.toLowerCase()) {
            case "not opting":
                break;
            case "vf":
                coverSelectionPage.optionalCover1(BaseTest.getData().get("VF"));
                break;
            case "disposal":
                coverSelectionPage.optionalCover2(BaseTest.getData().get("Disposal"));
                break;
            case "saddlery&tack":
                coverSelectionPage.optionalCover3(BaseTest.getData().get("Saddlery&Tack"));
                break;
            case "horsetrailer":
                coverSelectionPage.optionalCover4(BaseTest.getData().get("HorseTrailer"), BaseTest.getData().get("TypeOfVehicle"), BaseTest.getData().get("MakeOfVehicle"), BaseTest.getData().get("ModelOfVehicle"), BaseTest.getData().get("PricePaid"), BaseTest.getData().get("VehicleSumInsured"));
                break;
            default:
                System.out.println("Invalid option: " + option);
                break;
        }
    }
    public void clickNext(){

        coverSelectionPage.selectNextButton();
    }


}









