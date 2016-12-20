package bg.softuni.models.interfaces;

public interface FragmentStack<Fragment> {

    int size();

    Fragment push(Fragment item);

    Fragment pop();

    Fragment peek();

    Boolean isEmpty();
}
