package pr08.models;

import pr08.interfaces.LeutenantGeneral;
import pr08.interfaces.Private;

import java.util.Collection;

public class LeutenantGeneralImpl extends PrivateImpl implements LeutenantGeneral {
    private Collection<Private> privateCollection;

    public LeutenantGeneralImpl(int id, String firstName, String lastName, double salary, Collection<Private> privateCollection) {
        super(id, firstName, lastName, salary);
        this.setPrivateCollection(privateCollection);
    }

    private void setPrivateCollection(Collection<Private> privateCollection) {
        this.privateCollection = privateCollection;
    }

    @Override
    public Collection<Private> getPrivateCollection() {
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(super.toString());
        sb.append(String.format("%nPrivates:"));

        for (Private aPrivate : privateCollection) {
            sb.append(System.lineSeparator());
            sb.append(aPrivate);
        }

        return sb.toString();
    }
}
