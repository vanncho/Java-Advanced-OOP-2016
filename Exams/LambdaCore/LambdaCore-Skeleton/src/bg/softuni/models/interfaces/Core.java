package bg.softuni.models.interfaces;

public interface Core {

    String getName();

    int getDurability();

    void attachFragment(Fragment fragment);

    Fragment detachFragment();

    FragmentStack<Fragment> getAllFragments();

    boolean shouldAddTheFragment();
}
