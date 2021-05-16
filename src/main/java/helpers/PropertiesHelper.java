package helpers;

import org.apache.commons.lang3.StringUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertiesHelper {
    static Properties prop = new Properties();

    //Get value from properties file by key
    public String getPropertyValueByKey(String key) throws Exception {
        String propFilePath = System.getProperty("user.dir") + "/src/main/resources/config.properties";
        FileInputStream fis = new FileInputStream(propFilePath);
        prop.load(fis);

        String value = prop.get(key).toString();

        if (StringUtils.isEmpty(value)) {
            throw new Exception("Value is not specified for key: " + key + " in properties file.");
        }
        return value;
    }
}
