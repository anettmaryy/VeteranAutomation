package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HistoryPage {


    public WebDriver driver;

    public HistoryPage(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='HQ1No']/parent::div")
    WebElement H1No;

    @FindBy(xpath = "//input[@id='HQ2No']/parent::div")
    WebElement H2No;

    @FindBy(xpath = "//input[@id='HQ3No']/parent::div")
    WebElement H3No;

    @FindBy(xpath = "//input[@id='HQ4No']/parent::div")
    WebElement H4No;

    @FindBy(xpath = "//input[@id='HQ5No']/parent::div")
    WebElement H5No;

    @FindBy(xpath = "//input[@id='HQ6No']/parent::div")
    WebElement H6No;

    @FindBy(xpath = "//input[@id='declaration']")
    WebElement btn_checkbox;

    @FindBy(xpath = "//a[@title='NEXT']")
    WebElement btn_clickNext;


    public void selectH1No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H1No));
        H1No.click();
    }

    public void selectH2No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H2No));
        H2No.click();

    }

    public void selectH3No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H3No));
        H3No.click();

    }

    public void selectH4No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H4No));
        H4No.click();

    }

    public void selectH5No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H5No));
        H5No.click();

    }
    public void selectH6No() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(H6No));
        H6No.click();

    }





    public void selectAgreeCheckbox() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btn_checkbox));
        btn_checkbox.click();

    }



    public void selectAllNoAndAcknowledge() {
        selectH1No();
        selectH2No();
        selectH3No();
        selectH4No();
        selectH5No();
        selectAgreeCheckbox();
    }


    public void selectAllNoAndAcknowledgeSaddleAndHorseTrailer() {
        selectH1No();
        selectH2No();
        selectH3No();
        selectH4No();
        selectH5No();
        selectH6No();
        selectAgreeCheckbox();

    }

    public void selectNextClickButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.elementToBeClickable(btn_clickNext));
        btn_clickNext.click();

    }







}
