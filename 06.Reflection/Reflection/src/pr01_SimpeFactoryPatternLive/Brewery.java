package pr01_SimpeFactoryPatternLive;

import pr01_SimpeFactoryPatternLive.beers.Beer;

import java.lang.reflect.Constructor;

public class Brewery {

    private static final String BEER_PACKAGE = "pr01_SimpeFactoryPatternLive.beers.";

    public Beer brew(String beerType, int quantity) {

        Beer beer = null;

        try {
            Class beerClass = Class.forName(BEER_PACKAGE + beerType);
            Constructor ctor = beerClass.getConstructor(int.class);
            beer = (Beer) ctor.newInstance(quantity);

        } catch (ReflectiveOperationException e) {
            throw new RuntimeException("Invalid beer type!");
        }

        return beer;
    }
}
