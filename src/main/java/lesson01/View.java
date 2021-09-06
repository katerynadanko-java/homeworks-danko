package lesson01;

public class View {

    public static final String INPUT_STRING_DATA_POLYMORPHISM = "What principle can we define as the ability of a message to be displayed in more than one form? ";
    public static final String OUR_STRING = "The answer is = ";
    public static final String WRONG_INPUT_STRING_DATA = "Wrong input! Repeat please! The answer is = ";
    public static final String INPUT_STRING_DATA_OVERLOADED = "Witch method has multiple functions with same name but different parameters? ";


    public View() {
    }

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageAndInt(String message, String value) {
        System.out.println(message + value);
    }
}

