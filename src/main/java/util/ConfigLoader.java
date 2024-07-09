package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigLoader {
    private Properties properties;
    public  ConfigLoader(String propertyFilePath){
        properties =  new Properties();
        try (FileInputStream inputStream = new FileInputStream(propertyFilePath)){
            properties.load(inputStream);
        }catch (IOException e){

            throw new RuntimeException("File not found at " + propertyFilePath);
        }
    }

    public String GetProperties(String key) {
        return properties.getProperty(key);
    }
}
