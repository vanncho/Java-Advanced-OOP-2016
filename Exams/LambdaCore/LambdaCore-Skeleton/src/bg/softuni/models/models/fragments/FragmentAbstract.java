package bg.softuni.models.models.fragments;

import bg.softuni.models.enums.FragmentType;
import bg.softuni.models.interfaces.Fragment;

public abstract class FragmentAbstract implements Fragment {

    private String name;
    private FragmentType type;
    private int pressureAffection;

    public FragmentAbstract(String name, int pressureAffection, FragmentType type) {
        this.setName(name);
        this.setPressureAffection(pressureAffection);
        this.setType(type);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String value) {
        this.name = value;
    }

    @Override
    public FragmentType getType() {
        return this.type;
    }

    private void setType(FragmentType value) {
        this.type = value;
    }

    @Override
    public int getPressureAffection () {
        return this.pressureAffection;
    }

    protected void setPressureAffection (int value) {
        this.pressureAffection = value;
    }
}
