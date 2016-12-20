package bg.softuni.models.models.cores;

public class ParaCore extends CoreAbstract {

    private static final int DURABILITY_DIVISOR = 3;

    public ParaCore(String name, int durability) {
        super(name, durability / DURABILITY_DIVISOR);
    }
}
