package lesson05.registrationForm.company;

import lesson05.registrationForm.company.controller.Controller;
import lesson05.registrationForm.company.model.Model;
import lesson05.registrationForm.company.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Model(), new View());
        // Run
        controller.processUser();
    }
}
