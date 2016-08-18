package pr01_EventImplementation;

public class NameChange {
    
    private String changedName;

    public NameChange(String changedName) {
        this.setChangedName(changedName);
    }

    public String getChangedName() {
        return changedName;
    }

    private void setChangedName(String changedName) {
        this.changedName = changedName;
    }
}
