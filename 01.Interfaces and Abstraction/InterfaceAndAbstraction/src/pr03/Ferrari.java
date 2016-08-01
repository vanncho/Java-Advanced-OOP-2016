package pr03;

public class Ferrari implements Car {
    private static final String MODEL = "488-Spider";
    private String driver;

    public Ferrari(String driver) {
        this.driver = driver;
    }

    public String getDriver() {
        return this.driver;
    }

    public String getModel() {
        return this.MODEL;
    }

    @Override
    public String useBrakes() {
        return "Brakes!";
    }

    @Override
    public String pushGas() {
        return "Zadu6avam sA!";
    }
}
