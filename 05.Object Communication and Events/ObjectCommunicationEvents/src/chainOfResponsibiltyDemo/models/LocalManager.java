package chainOfResponsibiltyDemo.models;

public class LocalManager extends BankEmployee {

    @Override
    String getRole() {
        return "Local Manager";
    }

    @Override
    int getAllowable() {
        return 50000;
    }
}
