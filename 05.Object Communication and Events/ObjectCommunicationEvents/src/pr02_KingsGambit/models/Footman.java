package pr02_KingsGambit.models;

import pr02_KingsGambit.interfaces.AttemptToKill;

public class Footman extends AbstractUnit implements AttemptToKill {

    private int killAttempts;

    public Footman(String name) {
        super(name);
        this.setKillAttempts(0);
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

    @Override
    public String getResponseMessage() {
        return String.format("Footman %s is panicking!%n", this.getName());
    }
}
