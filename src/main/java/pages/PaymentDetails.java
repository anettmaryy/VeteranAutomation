package pages;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.*;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


public class PaymentDetails {


    public WebDriver driver;



    public PaymentDetails(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@name='account_name1']")
    WebElement txt_accountHolderName;

    @FindBy(xpath = "//input[@name='accountno']")
    WebElement txt_accountNumber;

    @FindBy(xpath = "//input[@id='sortcode1']")
    WebElement txt_sortCode1;

    @FindBy(xpath = "//input[@id='sortcode2']")
    WebElement txt_sortCode2;

    @FindBy(xpath = "//input[@id='sortcode3']")
    WebElement txt_sortCode3;

    @FindBy(xpath = "//a[@title='NEXT STEP']")
    WebElement Next_Step;

    @FindBy(xpath = "//input[@id='txtCardHoldersName']")
    WebElement txt_ccholdername;

    @FindBy(xpath = "//input[@name='CCBillADD' and @id='CCBillADD' and @value='on']")
    WebElement btn_yesAddress;

    @FindBy(xpath = "//input[@name='CCBillADD' and @id='CCBillADD' and @value='off']")
    WebElement btn_noAddress;

    @FindBy(xpath = "//input[@id='txtCardPostcode']")
    WebElement txt_billingAddress;

    @FindBy(id="btnFindAddress")
    WebElement search_billingAddress;

    @FindBy(xpath = "//select[@id='address']")
    WebElement select_billingAddress;

    @FindBy(xpath = "//a[@title='Use Address']")
    WebElement useAddress;



    @FindBy(id="expiryMonth")
    WebElement ccExpiryMonth;

    @FindBy(id="expiryYear")
    WebElement ccExpiryYear;


    @FindBy(id="btnSubmit")
    WebElement ccPayNow;




    public void directMonthlyAnnually(String name, String accountNumber, String sortcode, ExtentTest node) {

            txt_accountHolderName.sendKeys(name);
            txt_accountNumber.sendKeys(accountNumber);

            String[] sortCodeParts = sortcode.split("-");

            txt_sortCode1.sendKeys(sortCodeParts[0]);
            txt_sortCode2.sendKeys(sortCodeParts[1]);
            txt_sortCode3.sendKeys(sortCodeParts[2]);


            utilities.ReportManager.log(Status.PASS, "Payment Details entered", driver, node);
            Next_Step.click();
        }

    public void enterCardHolderName(String Name){

        txt_ccholdername.clear();

        txt_ccholdername.sendKeys(Name);

    }


    public void selectYes() {

        btn_yesAddress.click();
    }

     public void selectNoFillAddressandProceed(String postCode, String Address) throws InterruptedException {

        btn_noAddress.click();
        txt_billingAddress.sendKeys(postCode);
         Thread.sleep(1000);

         Actions actions = new Actions(driver);
         actions.moveToElement(search_billingAddress).click().perform();
         Thread.sleep(1000);
         Select addressDD = new Select(select_billingAddress);
         Thread.sleep(1000);
         addressDD.selectByVisibleText(Address);
         Thread.sleep(1000);
         useAddress.click();
    }


    public void copsFill(String cardNo, String monthExpiry, String yearExpiry, String pin) throws InterruptedException {


        Thread.sleep(5000);
        WebElement iframe = driver.findElement(By.id("YourPayment"));
        driver.switchTo().frame(iframe);

        Thread.sleep(1000);
        WebElement cardNumberInput = driver.findElement(By.id("cardNumber"));
        cardNumberInput.clear();
        cardNumberInput.sendKeys(cardNo);

        Thread.sleep(1000);
        ccExpiryMonth.sendKeys(monthExpiry);
        Thread.sleep(1000);
        ccExpiryYear.sendKeys(yearExpiry);
        Thread.sleep(1000);
        WebElement codeInput = driver.findElement(By.id("csc"));
        Thread.sleep(1000);
        codeInput.sendKeys(pin);


    }
    public void payNow() throws InterruptedException {
        Thread.sleep(1000);
        ccPayNow.click();
    }


    }














