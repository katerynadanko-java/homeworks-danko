package lesson04.com.company;

import lesson04.com.company.controller.Controller;
import lesson04.com.company.model.Model;
import lesson04.com.company.view.View;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Controller controller =
                new Controller(new Model(), new View());
        // Run
        controller.processUser();
    }
}
