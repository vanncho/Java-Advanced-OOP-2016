package pr09.models;

import pr09.interfaces.AddRemoveCollection;
import pr09.interfaces.MyList;

import java.util.ArrayList;;

public class MyListImpl implements MyList, AddRemoveCollection {
    private ArrayList<String> myListCollection;
    private int amountOfElementsInList;
    private int index;

    public MyListImpl() {
        this.myListCollection = new ArrayList<String>(100);
        this.amountOfElementsInList = 0;
    }

    @Override
    public int myUsed() {
        return this.amountOfElementsInList;
    }

    @Override
    public String myRemove() {
        String toReturn =  myListCollection.get(0);
        this.myListCollection.remove(0);
        return toReturn;
    }

    @Override
    public int myAdd(String element) {
        this.myListCollection.add(0, element);
        this.amountOfElementsInList++;
        return 0;
    }
}
