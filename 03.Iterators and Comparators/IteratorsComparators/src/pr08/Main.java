package pr08;

import pr08.interfaces.Clinic;
import pr08.interfaces.Pet;
import pr08.models.ClinicImpl;
import pr08.models.PetImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());

        Map<String, Clinic> clinicsCollection = new HashMap<>();
        Map<String, Pet> petsCollection = new HashMap<>();
        Pet currentPet = null;
        Clinic currentClinic = null;

        for (int i = 0; i < lines; i++) {
            String[] lineTokens = reader.readLine().split("[\\s]+");

            switch (lineTokens[0]) {
                case "Create":

                    if (lineTokens[1].equals("Pet")) {

                        currentPet = new PetImpl(lineTokens[2], Integer.valueOf(lineTokens[3]), lineTokens[4]);
                        petsCollection.put(lineTokens[2], currentPet);

                    } else {
                        try {

                            currentClinic = new ClinicImpl(Integer.valueOf(lineTokens[3]));
                            clinicsCollection.put(lineTokens[2], currentClinic);

                        } catch (IllegalArgumentException iae) {
                            System.out.println(iae.getMessage());
                        }
                    }
                    break;
                case "Add":

                    try {
                        if (clinicsCollection.containsKey(lineTokens[2])) {
                            currentClinic = clinicsCollection.get(lineTokens[2]);
                            currentPet = petsCollection.get(lineTokens[1]);
                            System.out.println(currentClinic.add(currentPet));
                        } else {
                            throw new IllegalArgumentException("Invalid Operation!");
                        }
                    } catch (IllegalArgumentException iae) {
                        System.out.println(iae.getMessage());
                    }
                    break;
                case "HasEmptyRooms":
                    currentClinic = clinicsCollection.get(lineTokens[1]);
                    System.out.println(currentClinic.hasEmptyRooms());
                    break;
                case "Release":
                    currentClinic = clinicsCollection.get(lineTokens[1]);
                    System.out.println(currentClinic.release());
                    break;
                case "Print":
                    currentClinic = clinicsCollection.get(lineTokens[1]);

                    if (lineTokens.length == 2) {
                        System.out.print(currentClinic.print());
                    } else {
                        System.out.println(currentClinic.print(Integer.valueOf(lineTokens[2])));
                    }
                    break;
            }
        }
    }
}
