package bg.softuni.models.collections;

import bg.softuni.models.interfaces.FragmentStack;

import java.util.LinkedList;

public class LStack<Fragment> implements FragmentStack<Fragment> {

    private LinkedList<Fragment> innerList;

    public LStack() {
        this.innerList = new LinkedList<>();
    }

    @Override
    public int size() {
        return this.innerList.size();
    }

    @Override
    public Fragment push(Fragment item) {
        this.innerList.addLast(item);
        return item;
    }

    @Override
    public Fragment pop() {
        Fragment removedItem = this.innerList.removeLast();
        return removedItem;
    }

    @Override
    public Fragment peek() {
        Fragment peekedItem = this.innerList.getFirst();
        return peekedItem;
    }

    @Override
    public Boolean isEmpty() {
        return !this.innerList.isEmpty();
    }
}