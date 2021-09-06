package lesson01;

public class Model {

    private String value;

    public Model(){
    }

    public String addStringOurValue(String valueString) {
        return this.value += " " + valueString;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}