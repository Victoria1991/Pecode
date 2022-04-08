package ui.registration.data;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class RegistrationInvalidData {

    private String name;
    private String nameError;
    private String password;
    private String passwordError;

    public static RegistrationInvalidData[] getData(String filename) throws IOException {
        return new ObjectMapper().readValue(new File(filename), RegistrationInvalidData[].class);
    }

    public String getName() {
        return name;
    }

    public String getNameError() {
        return nameError;
    }


    public String getPassword() {
        return password;
    }

    public String getPasswordError() {
        return passwordError;
    }

}
