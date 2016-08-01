package pr10;

import pr10.interfaces.Archangel;
import pr10.interfaces.Character;
import pr10.interfaces.Demon;
import pr10.models.ArchangelImpl;
import pr10.models.DemonImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] characterTokens = reader.readLine().split(" | ");
        String username = characterTokens[0];
        String characterType = characterTokens[2];
        int level = Integer.valueOf(characterTokens[6]);


        switch (characterType) {

            case "Demon":
                double energyPoints = Double.valueOf(characterTokens[4]);
                Demon<Double> demon = new DemonImpl<>(username, characterType, energyPoints, level);

                System.out.printf("\"%s\" | \"%s\" -> %s%n", demon.getUsername(), demon.getEnergy(), demon.getCharacterType());
                System.out.printf("%.1f", demon.getCalculateSpecial());

                break;
            case "Archangel":
                int manaPoints = Integer.valueOf(characterTokens[4]);
                Archangel<Integer> archangel = new ArchangelImpl<>(username, characterType, manaPoints, level);

                System.out.printf("\"%s\" | \"%s\" -> %s%n", archangel.getUsername(), archangel.getMana(), archangel.getCharacterType());
                System.out.printf("%d", archangel.getCalculateSpecial());

                break;
        }
    }
}
