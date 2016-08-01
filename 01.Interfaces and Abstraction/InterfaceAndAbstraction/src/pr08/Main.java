package pr08;

import pr08.interfaces.Missions;
import pr08.interfaces.Private;
import pr08.interfaces.Repairs;
import pr08.interfaces.Soldier;
import pr08.models.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Soldier> soldiersList = new ArrayList<>();
        Map<Integer, Private> privateMap = new LinkedHashMap<>();

        while (true) {
            String line = reader.readLine();

            if (line.equals("End")) {
                break;
            }

            String[] tokens = line.split("[\\s]+");
            String command = tokens[0];
            int id = Integer.valueOf(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary = 0;
            String corp = null;
            Soldier soldier = null;
            Private privateSoldier = null;

            switch (command) {
                case "Private":
                    salary = Double.valueOf(tokens[4]);
                    privateSoldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiersList.add(privateSoldier);
                    privateMap.put(privateSoldier.getId(), privateSoldier);

                    break;
                case "LeutenantGeneral":
                    salary = Double.valueOf(tokens[4]);

                    List<Private> privates = new ArrayList<>();

                    for (int i = 5; i < tokens.length; i++) {
                        Private currentPrivate = privateMap.get(Integer.valueOf(tokens[i]));
                        privates.add(currentPrivate);
                    }

                    soldier = new LeutenantGeneralImpl(id, firstName, lastName, salary, privates);
                    soldiersList.add(soldier);

                    break;
                case "Engineer":
                    salary = Double.valueOf(tokens[4]);
                    corp = tokens[5];

                    List<Repairs> repairs = new ArrayList<>();

                    for (int i = 6; i < tokens.length; i += 2) {

                        try {
                            Repairs currRepair = new RepairImpl(tokens[i], Integer.valueOf(tokens[i + 1]));
                            repairs.add(currRepair);
                        } catch (IllegalArgumentException iae) {

                        }
                    }

                    try {
                        soldier = new EngineerImpl(id, firstName, lastName, salary, corp, repairs);
                        soldiersList.add(soldier);
                    } catch (IllegalArgumentException iae) {

                    }

                    break;
                case "Commando":
                    salary = Double.valueOf(tokens[4]);
                    corp = tokens[5];

                    List<Missions> missions = new ArrayList<>();

                    for (int i = 6; i < tokens.length; i += 2) {

                        try {
                            Missions currentMission = new MissionImpl(tokens[i], tokens[i + 1]);
                            missions.add(currentMission);
                        } catch (IllegalArgumentException iae) {

                        }
                    }

                    try {
                        soldier = new CommandoImpl(id, firstName, lastName, salary, corp, missions);
                        soldiersList.add(soldier);
                    } catch (IllegalArgumentException iae) {

                    }

                    break;
                case "Spy":
                    int codeNumber = Integer.valueOf(tokens[4]);
                    soldier = new SpyImpl(id, firstName, lastName, codeNumber);

                    soldiersList.add(soldier);
                    break;
            }
        }

        for (Soldier soldier : soldiersList) {
            System.out.println(soldier.toString());
        }
    }
}
