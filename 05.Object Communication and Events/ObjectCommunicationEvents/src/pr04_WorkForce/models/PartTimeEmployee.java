package pr04_WorkForce.models;

public class PartTimeEmployee extends EmployeeImpl {

    private static final int HOURS_WORK_PER_WEEK = 20;

    public PartTimeEmployee(String name) {
        super(name, HOURS_WORK_PER_WEEK);
    }
}
