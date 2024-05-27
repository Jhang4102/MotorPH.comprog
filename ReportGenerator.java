import java.util.HashMap;
public class ReportGenerator {
    public void generateSalaryReport(EmployeeDatabase employeeDatabase) {
        // Generate a salary report for employees
        HashMap<Integer, Employee> database = employeeDatabase.database();
        for (Employee employee : database.values()) {
            // Generate the salary report for each employee
            System.out.println("Salary Report for Employee #" + employee.getEmployeeNumber() + ":");
            System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Basic Salary: " + employee.getBasicSalary());
            System.out.println("Total Salary: " + employee.calculateTotalSalary());
            System.out.println("------------------------------");
        }
    }

    public void generatePerformanceReport(EmployeeDatabase employeeDatabase) {
        // Generate a performance report for employees
        HashMap<Integer, Employee> database = employeeDatabase.database();
        for (Employee employee : database.values()) {
            // Generate the performance report for each employee
            System.out.println("Performance Report for Employee #" + employee.getEmployeeNumber() + ":");
            // Add performance metrics and details
            System.out.println("-------------------------------------");
        }
    }

    public void generateAttendanceReport(EmployeeDatabase employeeDatabase) {
        // Generate an attendance report for employees
        HashMap<Integer, Employee> database = employeeDatabase.database();
        for (Employee employee : database.values()) {
            // Generate the attendance report for each employee
            System.out.println("Attendance Report for Employee #" + employee.getEmployeeNumber() + ":");
            // Add attendance details and records
            System.out.println("----------------------------------");
        }
    }
}
