package pr04_WorkForce.models;

import java.util.EventObject;

public class JobCompletedEvent extends EventObject {

    public JobCompletedEvent(Object source) {
        super(source);
    }
}
