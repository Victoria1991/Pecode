package constans;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PathsToFiles {


    private PathsToFiles() {}

    public static String getProperty(String property) {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(BASE_PATH + "paths.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties.getProperty(property);
    }


    public static final String BASE_PATH = "./src/main/resources/";

    public interface LoginContext {
        String LOGIN_INVALID_DATA = BASE_PATH + "registration/RegistrationInvalidData.json";
    }
}
