package pr04_WorkForce.models;

public class StandartEmployee extends EmployeeImpl {

    private static final int HOURS_WORK_PER_WEEK = 40;

    public StandartEmployee(String name) {
        super(name, HOURS_WORK_PER_WEEK);
    }
}
