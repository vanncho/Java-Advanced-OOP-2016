package pr02_KingsGambit.interfaces;

import pr02_KingsGambit.models.Data;

public interface Unit extends Attackable, Killable, AttemptToKill, KillUnitListener {

    String getName();

    String getResponseMessage();

    void respondToAttack(Data data);

    void attack(Data data);
}
