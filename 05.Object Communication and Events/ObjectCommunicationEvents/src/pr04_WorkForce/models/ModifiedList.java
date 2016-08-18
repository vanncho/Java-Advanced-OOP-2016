package pr04_WorkForce.models;

import pr04_WorkForce.interfaces.JobCompletedListener;

import java.util.ArrayList;

public class ModifiedList<T> extends ArrayList<T> implements JobCompletedListener {

    @Override
    public void handleJobCompleted(JobCompletedEvent event) {
        this.remove(event.getSource());
    }
}
