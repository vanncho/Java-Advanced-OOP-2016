package pr02_KingsGambit.models;

import pr02_KingsGambit.interfaces.Unit;

public abstract class AbstractUnit implements Unit {

    private String name;

    public AbstractUnit(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void respondToAttack(Data data) {

        for (String name : data.getUnits().keySet()) {
            Unit unitToResponse = data.getUnits().get(name);
            System.out.print(unitToResponse.getResponseMessage());
        }
    }

    @Override
    public void removeUnit(String name, Data data) {

        if (data.getUnits().containsKey(name)) {
            Unit unitToRemove = data.getUnits().get(name);
            data.removeUnit(unitToRemove);
        }
    }

    public void attack(Data data) {
        this.respondToAttack(data);
    }

    @Override
    public void handleKill(String name, Data data) {

        Unit unitToRemove = data.getUnits().get(name);
        int kills = unitToRemove.getKillAttempts();
        kills++;

        if (unitToRemove instanceof Footman && kills == 2) {
            this.removeUnit(name, data);

        } else if (unitToRemove instanceof RoyalGuard && kills == 3) {
            this.removeUnit(name, data);
        }

        unitToRemove.updateKillStatus(kills);
    }
}
