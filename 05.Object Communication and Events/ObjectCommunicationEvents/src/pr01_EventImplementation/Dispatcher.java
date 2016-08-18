package pr01_EventImplementation;

import java.util.ArrayList;
import java.util.List;

public class Dispatcher {

    private String name;
    private Handler handler;
    private List<NameChangeListener> listeners;

    public Dispatcher(String name, Handler handler) {
        this.name = name;
        this.listeners = new ArrayList<>();

        this.handler = handler;
    }

    public void addNameChangeListener(Handler handler) {

        if (!this.listeners.contains(handler)) {
            this.listeners.add(handler);
        }
    }

    private void removeNameChangeListener(Handler handler) {

        if (this.listeners.contains(handler)) {
            this.listeners.remove(handler);
        }
    }

    void fireNameChangeEvent(NameChange nameChange) {

        this.handler.handleChangedName(nameChange);
        this.removeNameChangeListener(this.handler);
    }
}
