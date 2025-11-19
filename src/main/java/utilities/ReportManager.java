package utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;


public class ReportManager
{
    private static ExtentReports extent;
    public static ExtentTest test;
    public static void initializeReport(Scenario scenario)
    {
        String Testid=scenario.getSourceTagNames().toString().replaceAll("[\\[\\]@,]","");
        String timestamp=new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss-SSS").format(new Date());
        String Reportname=System.getProperty("user.dir")+"/target/reports/"+Testid+"_Veteranflow_"+timestamp+".html";

        ExtentSparkReporter spark=new ExtentSparkReporter(Reportname);
        spark.config().setReportName(
                "<h1 style='text-align:center; font-size:20px; color:white; background:transparent; font-weight:bold;'>Veteran Plan Regression Testing Report</h1>"
        );
        spark.config().setDocumentTitle("Veteran Plan Testing");
        spark.config().setTheme(Theme.STANDARD);

        spark.config().setTimelineEnabled(true);
        extent=new ExtentReports();
        extent.attachReporter(spark);
        extent.setSystemInfo("Environment","Test");
        extent.setSystemInfo("Operating System","Windows");
        extent.setSystemInfo("Browser","Edge");
        extent.setSystemInfo("Tester",System.getProperty("user.name"));
        //extent.setReportUsesManualConfiguration(true);
    }

    public static void createTest(String TestName)
    {
        test=extent.createTest("<b>Testcase :</b>"+TestName+"<br> Timestamp:"+new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date()));

    }

    public static void log(Status status, String message, WebDriver driver, ExtentTest stepnode)
    {
        String timestamp=new SimpleDateFormat("yyyyMMdd_HHmmssSSS").format(new Date());
        Path destinationPath= Paths.get(System.getProperty("user.dir")+"/target/reports/screenshots/Veteran"+timestamp+".png");

        if(driver!=null)
        {   String src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

            MediaEntityBuilder media=MediaEntityBuilder.createScreenCaptureFromBase64String(src);
            String imgTag="<img src='data:image/png;base64,"+src+"'width='300' height='200'/>";
            stepnode.log(status,message+"<br>"+imgTag, media.build());


        }
    }

    public static void flushReport()
    {
        if(extent!=null)
        {
            extent.flush();
            System.out.println("Reported Created");
        }
    }

    public static void deleteOldReports()
    {
        File reportDir=new File(System.getProperty("user.dir")+"/target/reports/");
        for(File file: Objects.requireNonNull(reportDir.listFiles()))
        {
            if(file.getName().endsWith(".html"))
            {
                file.delete();
            }
        }

    }
}
