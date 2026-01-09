package stepDefinition;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.*;
import stepDefinition.compositestepmethods.*;
import utilities.ExcelUtil;

import java.io.IOException;
import java.time.Duration;

public class VeteranFlow extends BaseTest {

    ExtentTest node;

    public String annualPremium;
    public String monthlyPremium;
    public String quoteReference;
    private Scenario scenario;

    @Before(order = 2)
    public void beforeScenario(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("User launches the Veteran Plan home page")
    public void userLaunchesTheVeteranPlanHomePage() throws InterruptedException, ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("Given"), "User launches the Veteran Plan home page");
        driver.get("https://www-test-petplanequine.allianz.co.uk/quote/veteran-horse-details.asp?pl=B");
        Thread.sleep(1000);
        HorseDetails horseDetails = new HorseDetails(driver);
        horseDetails.acceptCookies();
        utilities.ReportManager.log(Status.PASS, "URL Launched Successfully", driver, node);
    }

    @When("user select checkbox for Horse details")
    public void userSelectsCheckboxForHorseDetails() throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User selects the checkbox");
        HorseDetails horseDetails = new HorseDetails(driver);
        horseDetails.clickCheckBox();
        utilities.ReportManager.log(Status.PASS, "User read the above statements and confirm they apply to my horse and all riders", driver, node);
    }

    @And("user enters the required Horse details from Excel {string}")
    public void entersTheRequiredHorseDetailsFromExcel(String dataId) throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("And"), "User Enters the Horse details");
        testDataSet = dataId;
        BaseTest.setTestData(ExcelUtil.getTestData(dataId));
        HorseDetailsFlow details = new HorseDetailsFlow(driver);
        details.enterHorseDetails();
        utilities.ReportManager.log(Status.PASS, "Captured HorseDetails", driver, node);
        details.clickHorseNext();
    }

    @Then("user will lands on PolicyHolderDetails page")
    public void userLandsOnPolicyHolderDetailsPage() throws ClassNotFoundException {
        try {
            node = utilities.ReportManager.test.createNode(new GherkinKeyword("Then"), "User Lands on Policy Holder Details Page");
            WebElement headerElement = driver.findElement(By.xpath("//*[@id='greenDiv']/div[1]/h2"));
            String headerText = headerElement.getText();
            Assert.assertEquals("Your Details", headerText);
            utilities.ReportManager.log(Status.PASS, "Landed on PolicyHolderDetails page successfully", driver, node);
            System.out.println("Landed on PolicyHolderDetails page successfully");
        } catch (AssertionError e) {
            utilities.ReportManager.log(Status.FAIL, "PolicyHolderDetails page navigation failed: " + e.getMessage(), driver, node);
            throw e;
        }
    }

    @When("user fills policyholder details")
    public void userFillsPolicyholderDetails() throws InterruptedException, ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User Enters the PolicyHolder details");
        PolicyHolderFlow policyDetails = new PolicyHolderFlow(driver);
        policyDetails.enterPolicyHolderDetails();
        utilities.ReportManager.log(Status.PASS, "Captured Policyholder Details", driver, node);
        policyDetails.clickPolicyNextButton();
    }

    @Then("user navigate to activity group page")
    public void navigatesToActivityGroupPage() {
        // Create a WebDriverWait instance with a timeout using Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the header element is visible
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Select your activity group']")));

        // Get the text of the header element
        String headerText = headerElement.getText();

        // Assert that the text is as expected
        Assert.assertEquals("Select your activity group", headerText);

        // Print a success message
        System.out.println("Landed on Activity Group page successfully");

    }

    @When("user selecting activity {string}")
    public void selectsActivityGroup(String activityGroup) throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User Select Activity Group details");
        ActivityGroupFlow selectGroup = new ActivityGroupFlow(driver);
        selectGroup.selectActivityGroup(activityGroup);
        utilities.ReportManager.log(Status.PASS, "Captured Activity Group Details", driver, node);
        selectGroup.clickActivityNextPage();
    }

    @Then("user navigate to cover selection page")
    public void navigatesToCoverSelectionPage() {
        // Create a WebDriverWait instance with a timeout (e.g., 10 seconds)
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

        // Wait until the header element is present and its text is 'Choice of cover'
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Choice of cover']")));

        // Get the text of the header element
        String headerText = headerElement.getText();

        // Assert that the text is as expected
        Assert.assertEquals("Choice of cover", headerText);

        // Print a success message
        System.out.println("Landed cover selection page successfully");
    }

    @When("user selects Basic Cover and {string} Optional Cover")
    public void userSelectsBasicCoverAndOptionalCover(String option) throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User Enters the Cover details");
        CoverSelectionFlow selectCover = new CoverSelectionFlow(driver);
        selectCover.selectBasicCover();
        selectCover.selectOptionalCover(option);
        utilities.ReportManager.log(Status.PASS, "Cover selected successfully", driver, node);
        selectCover.clickNext();
    }

    @Then("user lands on quote page")
    public void userLandsOnQuotePage() {

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(60))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NoSuchElementException.class);
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Your Quote']")));

        String headerText = headerElement.getText();
        Assert.assertEquals("Your Quote", headerText);
        System.out.println("Landed quote page successfully");
    }

    @When("user select declaration and the save quote")
    public void userSelectsSaveQuote() throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "Quote Generated");
        VeteranQuote selectDeclarationAndSaveQuote = new VeteranQuote(driver);
        utilities.ReportManager.log(Status.PASS, "Quote generated successfully", driver, node);
        selectDeclarationAndSaveQuote.clickCoverCheckBox();
        selectDeclarationAndSaveQuote.selectSaveQuote();
    }

    @Then("Quote Reference Number and Quote details are captured")
    public void quoteReferenceNumberAndQuoteDetailsAreCaptured() throws IOException, ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("Then"), "Quote details Captured");
        VeteranQuote captureReferenceAndPremium = new VeteranQuote(driver);
        quoteReference = captureReferenceAndPremium.printQuoteReference();
        annualPremium = captureReferenceAndPremium.getPremiumValue();
        monthlyPremium = captureReferenceAndPremium.getMonthlyPremiumValue();
        String policyNumber = quoteReference;
        String formattedAnnualPremium = "£" + annualPremium;
        String formattedMonthlyPremium = "£" + monthlyPremium;
        utilities.ReportManager.log(Status.PASS, "Quote Created successfully", driver, node);
        String[] data = new String[]{scenario.getName(), policyNumber, formattedAnnualPremium, formattedMonthlyPremium};
        ExcelUtil.writeResult("Quote_TestResult", data);
        node.log(Status.PASS, "Quote Reference:" + policyNumber);
        node.log(Status.PASS, "AnnualPremium:" + formattedAnnualPremium);
        node.log(Status.PASS, "MonthlyPremium:" + formattedMonthlyPremium);
    }

    @When("user agree above details")
    public void userAgreeAboveDetails() throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "Quote details Captured");
        VeteranQuote selectDeclarationAndContinue = new VeteranQuote(driver);
        annualPremium = selectDeclarationAndContinue.getPremiumValue();
        monthlyPremium = selectDeclarationAndContinue.getMonthlyPremiumValue();
        utilities.ReportManager.log(Status.PASS, "Quote Reference generated successfully", driver, node);
        selectDeclarationAndContinue.clickCoverCheckBox();
        selectDeclarationAndContinue.selectYesContinue();
    }

    @Then("user navigate to history page")
    public void userNavigateToHistoryPage() {
        WebElement headerElement = driver.findElement(By.xpath("//h2[text()='History']"));
        String headerText = headerElement.getText();
        Assert.assertEquals("History", headerText);
        System.out.println("Landed history page successfully");
    }

    @When("user answers all underwriting history details as No and acknowledge it")
    public void userAnswersAllUnderwritingHistoryDetailsAsNoAndAcknowledgeIt() {
        HistoryPage selectNoUnderwriting = new HistoryPage(driver);
        selectNoUnderwriting.selectAllNoAndAcknowledge();
        selectNoUnderwriting.selectNextClickButton();
    }

    @When("user answers all underwriting history details as No")
    public void userAnswersAllUnderwritingHistoryDetailsAsNo() {

        HistoryPage selectNoUnderwriting = new HistoryPage(driver);
        selectNoUnderwriting.selectAllNoAndAcknowledgeSaddleAndHorseTrailer();
        selectNoUnderwriting.selectNextClickButton();

    }

    @Then("user lands on Payment Summary")
    public void userLandsOnPaymentSummary() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Payment Summary']")));
        WebElement headerElement = driver.findElement(By.xpath("//h2[text()='Payment Summary']"));
        String headerText = headerElement.getText();
        Assert.assertEquals("Payment Summary", headerText);
        System.out.println("Landed Payment Summary page successfully");
    }

    @When("user select the {string} Payment method")
    public void userSelectThePaymentMethod(String option) {
        PaymentSummaryFlow selectPayment = new PaymentSummaryFlow(driver);
        selectPayment.selectDonation();
        selectPayment.selectPaymentOption(option);
        selectPayment.nextStepClickButton();
    }

    @Then("user lands on Summary")
    public void userLandsOnSummary() {
        // Create a WebDriverWait instance with a timeout using Duration
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Wait until the header element is visible
        WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Summary']")));

        // Get the text of the header element
        String headerText = headerElement.getText();

        // Assert that the text is as expected
        Assert.assertEquals("Summary", headerText);

        // Print a success message
        System.out.println("Landed Summary page successfully");
    }

    @And("review the provided details")
    public void reviewTheProvidedDetails() throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("And"), "User review the provided details");
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
        utilities.ReportManager.log(Status.PASS, "All details reviewed successfully", driver, node);
    }

    @When("user proceeds checkout")
    public void userProceedsCheckout() throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User proceeds checkout");
        try {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,500)");
            utilities.ReportManager.log(Status.PASS, "Checkout completed", driver, node);
            driver.findElement(By.xpath("//a[text()='Checkout']")).click();
        } catch (Exception e) {
            utilities.ReportManager.log(Status.FAIL, "Checkout failed: " + e.getMessage(), driver, node);
        }
    }

    @Then("user lands on Payment section")
    public void userLandsOnPaymentSection() {
        try {
            // Create a WebDriverWait instance with a timeout using Duration
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Wait until the header element is visible
            WebElement headerElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[text()='Payment']")));

            // Get the text of the header element
            String headerText = headerElement.getText();

            // Assert that the text is as expected
            Assert.assertEquals("Payment", headerText);

            // Print a success message
            System.out.println("Landed Payment Summary page successfully");
        } catch (Exception e) {
            // Handle exceptions and provide informative error messages
            System.err.println("Failed to land on Payment Summary page: " + e.getMessage());
            throw new RuntimeException(e);
        }
    }

    @Then("user lands on Payment CreditorDebit section")
    public void userLandsOnPaymentCreditorDebitSection() {

        WebElement headerElement = driver.findElement(By.xpath("//h2[text()='Credit/Debit Card Details']"));
        String headerText = headerElement.getText();
        Assert.assertEquals("Credit/Debit Card Details", headerText);
        System.out.println("Landed Credit/Debit details page successfully");
    }

    @When("user completes the {string} payment successfully")
    public void userCompletesThePaymentSuccessfully(String payment) throws ClassNotFoundException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("When"), "User completes the " + payment + " payment successfully");
        try {
            PaymentDetailsFlow qp = new PaymentDetailsFlow(driver);
            if (payment.contains("Direct")) {
                qp.directDebit_Annually_Monthly(driver, node);
            } else {
                qp.enterCardName();

                qp.credit_debit_Card_Annual(driver, node);
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            utilities.ReportManager.log(Status.FAIL, "Payment failed: " + e.getMessage(), driver, node);
        }
    }



    @Then("Policy details should be displayed")
    public void policyValidation() throws ClassNotFoundException, IOException {
        node = utilities.ReportManager.test.createNode(new GherkinKeyword("Then"), "Policy details Validation");

        try {
            // Use WebDriverWait to wait for the element to be visible
            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(60))
                    .pollingEvery(Duration.ofSeconds(1))
                    .ignoring(NoSuchElementException.class);



            // Wait for the element to be present in the DOM
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id='greenDiv']/div[2]/h2")));

            // Wait for the element to be visible
            WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='greenDiv']/div[2]/h2")));

            System.out.println("Element Visible");



            // Verify the text of the header element
            String paymentHeader = header.getText();
            org.testng.Assert.assertEquals(paymentHeader, "Thank you", "Policy creation failed");

            // Log success and capture policy details
            utilities.ReportManager.log(Status.PASS, "Policy created successfully", driver, node);

            WebElement policyElement = driver.findElement(By.xpath("//p/strong[contains(text(),'Policy Reference')]"));
            String policyNumber = policyElement.getText();

            String formattedAnnualPremium = "£" + annualPremium;
            String formattedMonthlyPremium = "£" + monthlyPremium;
            String[] data = new String[]{scenario.getName(), policyNumber.split("Policy Reference No:")[1], formattedAnnualPremium, formattedMonthlyPremium};

            // Write results to Excel
            ExcelUtil.writeResult("Policy_TestResult", data);

            // Log policy details
            node.log(Status.PASS, policyNumber);
            node.log(Status.PASS, "AnnualPremium: " + formattedAnnualPremium);
            node.log(Status.PASS, "MonthlyPremium: " + formattedMonthlyPremium);

        } catch (Exception | AssertionError e) {
            // Log failure and rethrow the exception
            utilities.ReportManager.log(Status.FAIL, "Policy creation failed: " + e.getMessage(), driver, node);
            throw e;
        }
    }



}
