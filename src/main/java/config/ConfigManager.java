package config;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class ConfigManager {
    private static Properties properties;
    static{
        try{
            FileInputStream inputStream=new FileInputStream(System.getProperty("user.dir")+"\\main\\resources\\config.properties");
            System.out.println(System.getProperty("user.dir")+"\\main\\resources\\config.properties");
            properties= new Properties();
            properties.load(inputStream);

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String key){
        return properties.getProperty(key);
    }

    public static String getBrowser(){
        return getProperty("browser");
    }

    public static String getURL(){
        return getProperty("baseURL");
    }

    /*public static int getpageLoadTimeout(){
        return getProperty("pageLoadTimeout");
    }

    public static int getimplicitWait(){
        return getProperty("implicitWait");
    }*/

}
