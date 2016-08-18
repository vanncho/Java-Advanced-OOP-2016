package pr00_LiveDemo;

import pr00_LiveDemo.interfaces.MyList;
import pr00_LiveDemo.models.CustomList;

import javax.naming.OperationNotSupportedException;

public class Main {
    public static void main(String[] args) throws OperationNotSupportedException {

        MyList<Integer> list = new CustomList<>(1, 2, 3);

        for (Integer ints : list) {
            System.out.println(ints);
        }
    }
}
