package pr05;

import pr05.interfaces.Machine;
import pr05.interfaces.Serializable;

public class Robot implements Machine, Serializable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.setModel(model);
        this.setId(id);
    }

    private void setModel(String model) {
        this.model = model;
    }

    private void setId(String id) {
        this.id = id;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
