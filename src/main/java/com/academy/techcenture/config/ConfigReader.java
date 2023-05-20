package com.academy.techcenture.config;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private static Properties properties;
    private static final String propertyFilePath = "src/main/resources/config.properties";

    /**
     * Encapsulate the constructor so it cannot be instantiated
     */
    private ConfigReader(){ }

    static {
        try{
            FileInputStream inputStream = new FileInputStream(propertyFilePath);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static String getProperty(String keyName){
        return properties.getProperty(keyName);
    }

    public static void setProperty(String key, String value){
        //save the data into file
        properties.setProperty(key, value);
    }
}
