package pr09.models;

import pr09.interfaces.AddCollection;

import java.util.ArrayList;

public class AddCollectionImpl implements AddCollection {
    private ArrayList<String> myAddCollection;
    private int index;

    public AddCollectionImpl() {
        this.myAddCollection = new ArrayList<String>(100);
        this.index = 0;
    }

    @Override
    public int myAdd(String element) {
        int indToReturn = this.index;
        this.index++;

        this.myAddCollection.add(this.myAddCollection.size(), element);

        return indToReturn;
    }
}
