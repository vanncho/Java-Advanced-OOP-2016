package pr10.models;

import pr10.interfaces.Tuple;

public class TupleImpl<T1, T2> implements Tuple<T1, T2> {
    private T1 tupleKey;
    private T2 tupleValue;

    public TupleImpl(T1 tupleKey, T2 tupleValue) {
        this.setTupleKey(tupleKey);
        this.setTupleValue(tupleValue);
    }

    private void setTupleKey(T1 tupleKey) {
        this.tupleKey = tupleKey;
    }

    private void setTupleValue(T2 tupleValue) {
        this.tupleValue = tupleValue;
    }

    @Override
    public T1 getTupleKey() {
        return this.tupleKey;
    }

    @Override
    public T2 getTupleValue() {
        return this.tupleValue;
    }
}
