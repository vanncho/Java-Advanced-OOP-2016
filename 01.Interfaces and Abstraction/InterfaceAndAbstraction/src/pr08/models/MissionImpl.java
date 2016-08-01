package pr08.models;

import pr08.interfaces.Missions;

public class MissionImpl implements Missions {
    private String codeName;
    private String state;

    public MissionImpl(String codeName, String state) {
        this.setCodeName(codeName);
        this.setState(state);
    }

    private void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    private void setState(String state) {

        if (!state.equals("inProgress") && !state.equals("Finished")) {
            throw new IllegalArgumentException("The state is not valid!");
        }

        this.state = state;

    }

    @Override
    public String getCodeName() {
        return this.codeName;
    }

    @Override
    public String getState() {
        return this.state;
    }

    @Override
    public void completeMission() {
        System.out.println("Mission Completed!");
    }

    @Override
    public String toString() {
        return String.format("  Code Name: %s State: %s", this.getCodeName(), this.getState());
    }
}
