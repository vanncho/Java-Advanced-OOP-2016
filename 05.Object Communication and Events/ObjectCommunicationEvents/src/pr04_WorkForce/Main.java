package pr04_WorkForce;

import pr04_WorkForce.interfaces.Employee;
import pr04_WorkForce.models.Job;
import pr04_WorkForce.models.ModifiedList;
import pr04_WorkForce.models.PartTimeEmployee;
import pr04_WorkForce.models.StandartEmployee;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Employee currentEmployee;
        ModifiedList<Job> jobs = new ModifiedList<>();
        Map<String, Employee> employees = new LinkedHashMap<>();

        Scanner input = new Scanner(System.in);

        while (true) {
            String[] lineTokens = input.nextLine().split("[\\s]+");

            if (lineTokens[0].equals("End")) {
                break;
            }

            switch (lineTokens[0]) {
                case "Job":
                    currentEmployee = employees.get(lineTokens[3]);
                    Job job = new Job(lineTokens[1], Integer.valueOf(lineTokens[2]), currentEmployee);
                    job.addJobCompleteListener(jobs);
                    jobs.add(job);
                    break;
                case "StandartEmployee":
                    currentEmployee = new StandartEmployee(lineTokens[1]);
                    employees.put(lineTokens[1], currentEmployee);
                    break;
                case "PartTimeEmployee":
                    currentEmployee = new PartTimeEmployee(lineTokens[1]); // !!!!
                    employees.put(lineTokens[1], currentEmployee);
                    break;
                case "Pass":
                    Job[] jobsToUpdate = new Job[jobs.size()];
                    jobs.toArray(jobsToUpdate);

                    for (Job currentJob : jobsToUpdate) {
                        currentJob.update();
                    }
                    break;
                case "Status":
                    for (Job currentJob : jobs) {
                        System.out.println(currentJob.toString());
                    }
                    break;
            }
        }
    }
}
