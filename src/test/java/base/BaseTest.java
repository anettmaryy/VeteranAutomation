package base;

import org.openqa.selenium.WebDriver;

import java.util.Map;

public class BaseTest {
    public static WebDriver driver;
    public String testDataSet;

    protected static Map<String,String> testData;
    public static void setTestData(Map<String,String> data)
    {
        testData=data;
    }
    public static  Map<String,String> getData()
    {
        return testData;
    }



}
