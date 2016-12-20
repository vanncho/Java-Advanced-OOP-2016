package bg.softuni.models.models.fragments;

import bg.softuni.models.enums.FragmentType;

public class CoolingFragment extends FragmentAbstract {

    private static final int PRESSURE_MULTIPLIER = 3;

    public CoolingFragment(String name, int pressureAffection, FragmentType fragmentType) {
        super(name, pressureAffection, FragmentType.COOLING);
    }

    @Override
    protected void setPressureAffection(int value) {
        super.setPressureAffection(value * PRESSURE_MULTIPLIER);
    }
}
