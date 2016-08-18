package pr04_WorkForce.interfaces;

import pr04_WorkForce.models.JobCompletedEvent;

public interface JobCompletedListener {

    void handleJobCompleted(JobCompletedEvent event);
}
