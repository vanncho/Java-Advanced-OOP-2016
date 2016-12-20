package bg.softuni.models.factories;

import bg.softuni.models.constants.Messages;
import bg.softuni.models.enums.FragmentType;
import bg.softuni.models.interfaces.Fragment;
import bg.softuni.models.interfaces.FragmentCreator;

import java.lang.reflect.Constructor;

public class FragmentFactory implements FragmentCreator {

    @Override
    public Fragment create(String fragmentType, String fragmentName, int pressureAffection) {

        Fragment fragment = null;
        //String firstLetter = (fragmentType.name().charAt(0)) + "";
        //String restOfFragmentName = fragmentType.name().substring(1).toLowerCase();
        //String fragmentTypeName = firstLetter + restOfFragmentName;

        try {
            Class fragmentClass = Class.forName(Messages.FRAGMENTS_PACKAGE_PATH + fragmentType + Messages.FRAGMENT_NAME);
            Constructor ctor = fragmentClass.getConstructor(String.class, int.class, FragmentType.class);
            fragment = (Fragment) ctor.newInstance(fragmentName, pressureAffection, FragmentType.valueOf(fragmentType.toUpperCase()));

            return fragment;

        } catch (ReflectiveOperationException e) {
            return null;
        }
    }
}
