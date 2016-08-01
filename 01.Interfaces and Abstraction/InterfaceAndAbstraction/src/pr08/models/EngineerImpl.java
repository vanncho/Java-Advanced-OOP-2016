package pr08.models;

import pr08.interfaces.Engineer;
import pr08.interfaces.Repairs;

import java.util.Collection;

public class EngineerImpl extends SpecialisedSoldierImpl implements Engineer {
    private Collection<Repairs> repairsesCollection;

    public EngineerImpl(int id, String firstName, String lastName, double salary, String corp, Collection<Repairs> repairsesCollection) {
        super(id, firstName, lastName, salary, corp);
        this.setRepairsesCollection(repairsesCollection);
    }

    private void setRepairsesCollection(Collection<Repairs> repairsesCollection) {
        this.repairsesCollection = repairsesCollection;
    }

    @Override
    public Collection<Repairs> getRepairsCollection() {
        return this.repairsesCollection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("%nCorps: %s%n", this.getCorp()));
        sb.append("Repairs:");

        for (Repairs repairs : repairsesCollection) {
            sb.append(System.lineSeparator());
            sb.append(repairs);
        }

        return sb.toString();
    }
}
