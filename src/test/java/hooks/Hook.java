package hooks;

import base.BaseTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.Before;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import utilities.ReportManager;




public class Hook extends BaseTest {

    @BeforeAll
    public static void before_all()
    {
        utilities.ReportManager.deleteOldReports();
    }


    @Before(order=1)
    public void setup(Scenario scenario) {
        System.setProperty("webdriver.edge.driver",System.getProperty("user.dir")+"\\drivers\\msedgedriver.exe");
        EdgeOptions options=new EdgeOptions();
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--start-maximized");
        driver=new EdgeDriver(options);
        String Testname=scenario.getName()+"<br><b> Test case id:</b>"+scenario.getSourceTagNames().toString().replaceAll("[\\[\\]@]","");
        utilities.ReportManager.initializeReport(scenario);
        utilities.ReportManager.createTest(Testname);




    }
    @After
    public void teardown(Scenario scenario)
    {

        if(scenario.isFailed())
        {
            ReportManager.test.log(Status.FAIL,"TestCase failed");

        }
        else
        {
            ReportManager.test.log(Status.PASS,"TestCase passed");

        }
        utilities.ReportManager.flushReport();
        driver.quit();
    }
}
