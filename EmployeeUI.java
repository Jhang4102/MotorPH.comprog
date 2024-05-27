import java.util.Scanner;
public class EmployeeUI {
    public void displayEmployeeInfo(Employee employee) {
        // Display employee information on the user interface
        System.out.println("Employee Information:");
        System.out.println("Employee Number: " + employee.getEmployeeNumber());
        System.out.println("Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Position: " + employee.getPosition());
        System.out.println("Basic Salary: " + employee.getBasicSalary());
        // Add more employee details as needed
    }

    public void captureUserInput() {
        // Capture user input for employee data
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter Employee Number:");
        int employeeNumber = scanner.nextInt();
        System.out.println("Enter First Name:");
        String firstName = scanner.next();
        System.out.println("Enter Last Name:");
        String lastName = scanner.next();
        System.out.println("Enter Position:");
        String position = scanner.next();
        System.out.println("Enter Basic Salary:");
        double basicSalary = scanner.nextDouble();

        // Create an Employee object with the captured user input
        Employee newEmployee = new Employee(employeeNumber, firstName, lastName, position, basicSalary);

        // Process the new employee data as needed
    }

    public void performAction() {
        // Perform an action based on user input
        // Add logic to handle user actions or commands
    }
}
