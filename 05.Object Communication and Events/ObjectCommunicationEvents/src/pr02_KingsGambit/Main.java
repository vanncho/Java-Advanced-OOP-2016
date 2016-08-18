package pr02_KingsGambit;

import pr02_KingsGambit.interfaces.Unit;
import pr02_KingsGambit.models.Data;
import pr02_KingsGambit.models.Footman;
import pr02_KingsGambit.models.King;
import pr02_KingsGambit.models.RoyalGuard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Data data = new Data();
        Unit royalUnit = null;

        int n = 3;
        for (int i = 0; i < n; i++) {
            String[] names = reader.readLine().split("[\\s]+");

            switch (i) {
                case 0:
                    royalUnit = new King(names[0]);
                    data.addUnitToData(royalUnit);
                    break;
                case 1:
                    for (String name : names) {
                        royalUnit = new RoyalGuard(name);
                        data.addUnitToData(royalUnit);
                    }
                    break;
                case 2:
                    for (String name : names) {
                        royalUnit = new Footman(name);
                        data.addUnitToData(royalUnit);
                    }
                    break;
            }
        }

        while (true) {

            String[] line = reader.readLine().split("[\\s]+");

            if (line[0].equals("End")) {
                break;
            }

            if (royalUnit != null) {

                switch (line[0]) {
                    case "Kill":
                        //royalUnit.removeUnit(line[1], data);
                        royalUnit.handleKill(line[1], data);
                        break;
                    case "Attack":
                        royalUnit.attack(data);
                        break;
                }
            }
        }
    }
}
