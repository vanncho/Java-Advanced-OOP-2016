package pr04_WorkForce.models;

import pr04_WorkForce.interfaces.Employee;
import pr04_WorkForce.interfaces.JobCompletedListener;

import java.util.ArrayList;
import java.util.List;

public class Job {

    private String name;
    private int hoursOfWorkRequired;
    private Employee employee;
    private List<JobCompletedListener> observers;

    public Job(String name, int hoursOfWorkRequired, Employee employee) {
        this.setName(name);
        this.setHoursOfWorkRequired(hoursOfWorkRequired);
        this.setEmployee(employee);
        this.observers = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public int getHoursOfWorkRequired() {
        return this.hoursOfWorkRequired;
    }

    private void setHoursOfWorkRequired(int hoursOfWorkRequired) {
        this.hoursOfWorkRequired = hoursOfWorkRequired;
    }

    private void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void update() {
        this.setHoursOfWorkRequired(this.getHoursOfWorkRequired() - this.employee.getWeeklyWorkHours());

        if (this.getHoursOfWorkRequired() <= 0) {
            System.out.printf("Job %s done!%n", this.getName());
            this.fireJobCompleteEvent();
        }
    }

    public void addJobCompleteListener(JobCompletedListener listener) {
        this.observers.add(listener);
    }

    public void removeJobCompleteListener(JobCompletedListener listener) {
        this.observers.remove(listener);
    }

    public void fireJobCompleteEvent() {
        JobCompletedEvent event = new JobCompletedEvent(this);

        for (JobCompletedListener observer : observers) {
            observer.handleJobCompleted(event);
        }
    }

    @Override
    public String toString() {
        return String.format("Job: %s Hours Remaining: %d", this.getName(), this.getHoursOfWorkRequired());
    }
}
