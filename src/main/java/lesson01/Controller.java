package lesson01;

import java.util.Scanner;

public class Controller {
    public static final String POLYMORPHISM = "polymorphism";
    public static final String OVERLOADED = "overloaded";
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void processUser() {
        Scanner sc = new Scanner(System.in);
        this.model.setValue(this.inputFirstValueWithScanner(sc));
        this.model.addStringOurValue(this.inputSecondValueWithScanner(sc));
        this.view.printMessageAndInt(view.OUR_STRING, this.model.getValue());
    }

    public String inputFirstValueWithScanner(Scanner sc) {
        this.view.printMessage(view.INPUT_STRING_DATA_POLYMORPHISM);
        while(!sc.nextLine().equals(POLYMORPHISM)) {
            this.view.printMessage(view.WRONG_INPUT_STRING_DATA + POLYMORPHISM);
        }
        return POLYMORPHISM;
    }

    public String inputSecondValueWithScanner(Scanner sc) {
        this.view.printMessage(view.INPUT_STRING_DATA_OVERLOADED);
        while (!sc.nextLine().equals(OVERLOADED)) {
            this.view.printMessage(view.WRONG_INPUT_STRING_DATA+ OVERLOADED);
        }
        return OVERLOADED;
    }
}
