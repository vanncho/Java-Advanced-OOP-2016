package pr04_WorkForce.models;

import pr04_WorkForce.interfaces.Employee;

public abstract class EmployeeImpl implements Employee{

    private String name;
    private int weeklyWorkHours;

    public EmployeeImpl(String name, int weeklyWorkHours) {
        this.setName(name);
        this.setWeeklyWorkHours(weeklyWorkHours);
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setWeeklyWorkHours(int weeklyWorkHours) {
        this.weeklyWorkHours = weeklyWorkHours;
    }

    @Override
    public int getWeeklyWorkHours() {
        return this.weeklyWorkHours;
    }
}
