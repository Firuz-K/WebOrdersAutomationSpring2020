package com.weborders.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {

    private static Properties properties = new Properties();

    static {



        try {
            FileInputStream file = new FileInputStream("configuration.properties");
            properties.load(file);

        }catch (IOException e){
            e.printStackTrace();
            throw new RuntimeException("Unable to find configuration.properties");
        }

    }

    public static String getProperty(String keyWord){
        return properties.getProperty(keyWord);
    }






}
