package bg.softuni.models.interfaces;

import bg.softuni.models.enums.FragmentType;

public interface Fragment {

    String getName();

    FragmentType getType();

    int getPressureAffection ();
}
