package pr02_KingsGambit.models;

public class King extends AbstractUnit{

    private int killAttempts;

    public King(String name) {
        super(name);
        this.setKillAttempts(0);
    }

    @Override
    public String getResponseMessage() {
        return String.format("King %s is under attack!%n", this.getName());
    }

    @Override
    public void attack(Data data) {
        this.respondToAttack(data);
    }

    @Override
    public int getKillAttempts() {
        return this.killAttempts;
    }

    @Override
    public void updateKillStatus(int kill) {
        this.setKillAttempts(kill);
    }

    private void setKillAttempts(int killAttempts) {
        this.killAttempts = killAttempts;
    }
}
