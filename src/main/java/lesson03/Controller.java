package lesson03;

import java.util.Scanner;

import static lesson03.GlobalConstants.PRIMARY_MAX_BARRIER;
import static lesson03.GlobalConstants.PRIMARY_MIN_BARRIER;
import static lesson03.View.*;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // The Work method
    public void processUser(){
        Scanner sc = new Scanner(System.in);

        model.setPrimaryBarrier(PRIMARY_MIN_BARRIER,
                PRIMARY_MAX_BARRIER);

        model.setSecretValue();
        System.out.println(model.getSecretValue());

        while (model.checkValue(inputIntValueWithScanner(sc)));

        view.printMessage(CONGRATULATION + model.getSecretValue());
        view.printMessage(YOUR_WAY + String.valueOf(model.getYourWay()));
    }

    private int inputIntValueWithScanner(Scanner sc) {
        int res = 0;
        view.printMessage(getInputIntMessage());
        while (true) {
            // check int-value
            while (!sc.hasNextInt()) {
                view.printMessage(WRONG_INPUT_INT_DATA + getInputIntMessage());
                sc.next();
            }
            // check value into diapason
            if ((res = sc.nextInt()) <= model.getMinBarrier() ||
                    res >= model.getMaxBarrier()) {
                view.printMessage(WRONG_INPUT_INT_DATA + getInputIntMessage());
                continue;
            }
            break;
        }
        return res;
    }

    private String getInputIntMessage() {
        return view.concatenationString(
                INPUT_INT_DATA, OPENS_SQUARE_BRACKET,
                String.valueOf(model.getMinBarrier()), SPACE_SING,
                String.valueOf(model.getMaxBarrier()),
                CLOSING_SQUARE_BRACKET, SPACE_SING,
                EQUAL_SING, SPACE_SING );
    }
}
