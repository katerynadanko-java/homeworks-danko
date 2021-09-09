package lesson05.registrationForm.company.view;

import java.util.Locale;
import java.util.ResourceBundle;

import static lesson05.registrationForm.company.view.TextConstant.INPUT_STRING_DATA;
import static lesson05.registrationForm.company.view.TextConstant.WRONG_INPUT_DATA;

/**
 * Created by student on 03.09.2021.
 */
public class View {

    // Resource Bundle Installation's
    private static String MESSAGES_BUNDLE_NAME = "form";
    public static final ResourceBundle bundle =
            ResourceBundle.getBundle(
                    MESSAGES_BUNDLE_NAME,
                    //new Locale("ua", "UA"));  // Ukrainian
                    new Locale("en"));        // English

    //Utilities methods
    /**
     *
     * @param message
     */
    private void printMessage(String message){
        System.out.println(message);
    }
    /**
     *
     * @param message
     * @return
     */
    private String concatenationString(String... message){
        StringBuilder concatString = new StringBuilder();
        for(String v : message) {concatString.append(v);}
        return new String(concatString);
    }

    /**
     *
     * @param message
     */
    public void printStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }

    public void printWrongStringInput(String message) {
        printMessage(concatenationString(
                bundle.getString(WRONG_INPUT_DATA),
                bundle.getString(INPUT_STRING_DATA),
                bundle.getString(message)));
    }


}
