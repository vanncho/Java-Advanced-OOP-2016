package pr01_SimpeFactoryPatternLive;

import pr01_SimpeFactoryPatternLive.beers.Beer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String[] line = reader.readLine().split(" ");

            if (line[0].equals("END")) {
                break;
            }

            String beerName = line[0];
            int liters = Integer.valueOf(line[1]);

            Brewery brewery = new Brewery();
            Beer beer = brewery.brew(beerName, liters);
            System.out.println(beer.getClass().getSimpleName() + " brewed!");
        }
    }
}
