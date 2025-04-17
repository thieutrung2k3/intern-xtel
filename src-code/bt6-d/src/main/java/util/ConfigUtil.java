package util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class ConfigUtil {
    public static Map<String, String> readConfigFile(){
        Properties properties = new Properties();
        try(InputStream fileInputStream = ConfigUtil.class.getClassLoader().getResourceAsStream("config.properties")){
            properties.load(fileInputStream);

            Map<String, String> configMap = new HashMap<>();

            for(String key : properties.stringPropertyNames()){
                //Luu property va key trong file config vao map
                configMap.put(key, properties.getProperty(key));
            }
            return configMap;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
