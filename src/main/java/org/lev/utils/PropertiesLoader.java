package org.lev.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesLoader {

    private static Properties configuration = new Properties();

    public static String getProperty(String key){
        return configuration.getProperty(key);
    }

    public static Properties loadBotProperties(String fromFile) {
        InputStream inputStream = PropertiesLoader.class
                .getClassLoader()
                .getResourceAsStream(fromFile);
        try{
            configuration.load(inputStream);
            inputStream.close();
        }catch (IOException e){
            System.err.println("Problem with properties loader");
        }
        return configuration;
    }

}
