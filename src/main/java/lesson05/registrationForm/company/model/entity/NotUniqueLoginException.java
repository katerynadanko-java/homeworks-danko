package lesson05.registrationForm.company.model.entity;

/**
 * Created by student on 09.09.2021.
 */
public class NotUniqueLoginException extends Exception {
    private String loginData;

    public String getLoginData() {
        return loginData;
    }

    public NotUniqueLoginException(String message, String loginData) {
        super(message);
        this.loginData = loginData;
    }
}
