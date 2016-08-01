package pr08.models;

import pr08.interfaces.Commando;
import pr08.interfaces.Missions;

import java.util.Collection;

public class CommandoImpl extends SpecialisedSoldierImpl implements Commando {
    private Collection<Missions> missionsCollection;

    public CommandoImpl(int id, String firstName, String lastName, double salary, String corp, Collection<Missions> missionsCollection) {
        super(id, firstName, lastName, salary, corp);
        this.setMissionsCollection(missionsCollection);
    }

    private void setMissionsCollection(Collection<Missions> missionsCollection) {
        this.missionsCollection = missionsCollection;
    }

    @Override
    public Collection<Missions> getMissionsCollection() {
        return this.missionsCollection;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("%nCorps: %s%n", super.getCorp()));
        sb.append("Missions:");

        for (Missions missions : missionsCollection) {
            sb.append(System.lineSeparator());
            sb.append(missions);
        }

        return sb.toString();
    }
}
