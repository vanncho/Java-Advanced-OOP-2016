package pr10.models;

import pr10.interfaces.Threeuple;

public class ThreeupleImpl<T1, T2, T3> extends TupleImpl<T1, T2> implements Threeuple<T1, T2, T3> {
    private T3 tupleThree;

    public ThreeupleImpl(T1 tupleKey, T2 tupleValue, T3 tupleThree) {
        super(tupleKey, tupleValue);
        this.setTupleThree(tupleThree);
    }

    private void setTupleThree(T3 tupleThree) {
        this.tupleThree = tupleThree;
    }

    @Override
    public T3 getTupleThree() {
        return this.tupleThree;
    }
}
