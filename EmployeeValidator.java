public class EmployeeValidator {
    public boolean validateEmployeeData(Employee employee) {
        // Validate employee data
        if (employee.getEmployeeNumber() <= 0) {
            System.out.println("Employee number must be a positive integer.");
            return false;
        }

        if (employee.getFirstName().isEmpty() || employee.getLastName().isEmpty()) {
            System.out.println("First name and last name cannot be empty.");
            return false;
        }

        if (employee.getBasicSalary() < 0) {
            System.out.println("Basic Salary cannot be negative.");
            return false;
        }

        // Add more validation rules as needed

        return true; // Data is valid if all checks pass
    }
}
