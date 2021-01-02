package commonLibs.utils;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtilities {
    public static Properties readProperties(String fileName) throws Exception{
        fileName = fileName.trim();
        InputStream filereader =new FileInputStream(fileName);
        Properties properties = new Properties();
        properties.load(filereader);
        return properties;

    }
}
