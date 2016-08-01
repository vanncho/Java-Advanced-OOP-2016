package pr09.models;

import pr09.interfaces.AddRemoveCollection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class AddRemoveCollectionImpl implements AddRemoveCollection {
    private ArrayList<String> myAddRemoveCollection;

    public AddRemoveCollectionImpl() {
        this.myAddRemoveCollection = new ArrayList<String>(100);
    }

    @Override
    public String myRemove() {
        String toReturn =  myAddRemoveCollection.get(this.myAddRemoveCollection.size() - 1);
        this.myAddRemoveCollection.remove(this.myAddRemoveCollection.size() - 1);
        return toReturn;
    }

    @Override
    public int myAdd(String element) {
        this.myAddRemoveCollection.add(0, element);
        return 0;
    }
}
