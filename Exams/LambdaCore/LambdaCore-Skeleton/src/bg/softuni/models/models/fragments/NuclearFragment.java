package bg.softuni.models.models.fragments;

import bg.softuni.models.enums.FragmentType;

public class NuclearFragment extends FragmentAbstract{

    private static final int PRESSURE_MULTIPLIER = 2;

    public NuclearFragment(String name, int pressureAffection, FragmentType fragmentType) {
        super(name, pressureAffection, FragmentType.NUCLEAR);
    }

    @Override
    protected void setPressureAffection(int value) {
        super.setPressureAffection(value * PRESSURE_MULTIPLIER);
    }
}
