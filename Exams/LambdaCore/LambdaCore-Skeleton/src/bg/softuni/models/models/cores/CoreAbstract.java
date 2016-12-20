package bg.softuni.models.models.cores;

import bg.softuni.models.collections.LStack;
import bg.softuni.models.enums.CorePressureType;
import bg.softuni.models.interfaces.Core;
import bg.softuni.models.interfaces.Fragment;
import bg.softuni.models.interfaces.FragmentStack;

public abstract class CoreAbstract implements Core {

    private String name;
    private int durability;
    private FragmentStack<Fragment> fragmentsToCore;
    private int corePressure;
    private CorePressureType corePressureType;
    private boolean shouldAttach;

    protected CoreAbstract(String name, int durability) {
        this.setName(name);
        this.setDurability(durability);
        this.fragmentsToCore = new LStack<>();
        this.setCorePressure(0);
        this.setCorePressureType(CorePressureType.NORMAL);
    }

    private void setShouldAttach(boolean shouldAttach) {
        this.shouldAttach = shouldAttach;
    }

    private void setCorePressureType(CorePressureType corePressureType) {
        this.corePressureType = corePressureType;
    }

    private int getCorePressure() {
        return corePressure;
    }

    private void setCorePressure(int corePressure) {
        this.corePressure = corePressure;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setDurability(int durability) {
        this.durability = durability;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getDurability() {
        return this.durability;
    }

    @Override
    public void attachFragment(Fragment fragment) {

        int fragmentPressure = fragment.getPressureAffection();
        String fragmentType = fragment.getType().name().toUpperCase();

        switch (fragmentType) {

            case"NUCLEAR":
                this.setCorePressure(this.getCorePressure() + fragmentPressure);
                this.setDurability(this.getDurability() - fragmentPressure);
                this.setCorePressureType(CorePressureType.CRITICAL);

                if (this.getDurability() < 0) {
                    this.setCorePressure(this.getCorePressure() - fragmentPressure);
                    this.setDurability(this.getDurability() + fragmentPressure);
                    this.shouldAttach = false;
                    this.setCorePressureType(CorePressureType.NORMAL);
                }

                this.shouldAttach = true;

                break;
            case "COOLING":
                this.setCorePressure(this.getCorePressure() - fragmentPressure);
                this.shouldAttach = true;
                this.setCorePressureType(CorePressureType.NORMAL);

                break;
        }

        if (this.shouldAttach) {
            this.fragmentsToCore.push(fragment);
        }
    }

    @Override
    public Fragment detachFragment() {
        Fragment fragment = this.fragmentsToCore.pop();

        int fragmentPressure = fragment.getPressureAffection();
        String fragmentType = fragment.getType().name().toUpperCase();

        switch (fragmentType) {

            case"NUCLEAR":
                this.setCorePressure(this.getCorePressure() - fragmentPressure);
                break;
            case "COOLING":
                this.setCorePressure(this.getCorePressure() + fragmentPressure);
                break;
        }

        return fragment;
    }

    @Override
    public FragmentStack<Fragment> getAllFragments() {
        return this.fragmentsToCore;
    }

    @Override
    public String toString() {

        return "Core " + this.getName() + ":" + System.lineSeparator() +
                "####Durability: " + this.getDurability() + System.lineSeparator() +
                "####Status: " + this.corePressureType + System.lineSeparator();
    }

//    private void checkCorePressureStatus(int fragmentPressure) {
//
//        if (this.getCorePressure() <= 0) {
//            this.setCorePressureType(CorePressureType.NORMAL);
//            this.setShouldAttach(true);
//            return;
//        }
//
//        if (this.getCorePressure() > 0) {
//            this.setCorePressureType(CorePressureType.CRITICAL);
//
//            if (this.getDurability() - fragmentPressure < 0) {
//                this.setCorePressureType(CorePressureType.NORMAL);
//                this.setCorePressure(this.getCorePressure() + fragmentPressure);
//                this.setShouldAttach(false);
//            } else {
//                this.setDurability(this.getDurability() - fragmentPressure);
//                this.setShouldAttach(true);
//            }
//        }
//    }

    @Override
    public boolean shouldAddTheFragment() {
        return this.shouldAttach;
    }
}
