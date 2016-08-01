package pr08.models;

import pr08.interfaces.SpecialisedSoldier;

public class SpecialisedSoldierImpl extends PrivateImpl implements SpecialisedSoldier {
    private String corp;

    public SpecialisedSoldierImpl(int id, String firstName, String lastName, double salary, String corp) {
        super(id, firstName, lastName, salary);
        this.setCorp(corp);
    }

    private void setCorp(String corp) {

        if (!corp.equals("Airforces") && !corp.equals("Marines")) {
            throw new IllegalArgumentException("The corp name is not valid");
        }

        this.corp = corp;
    }

    @Override
    public String getCorp() {
        return this.corp;
    }
}
