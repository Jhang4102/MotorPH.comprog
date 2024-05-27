import java.util.List;
public class PayrollProcessor {
        public void calculatePayroll(List<Employee> employees) {
            // Calculate payroll for employees
            for (Employee employee : employees) {
                double totalSalary = employee.calculateTotalSalary();
                // Add payroll calculation logic here
                System.out.println("Payroll calculated for Employee #" + employee.getEmployeeNumber() + ": Total Salary - " + totalSalary);
            }
        }

        public void generatePayStubs(List<Employee> employees) {
            // Generate pay stubs for employees
            for (Employee employee: employees) {
                double totalSalary = employee.calculateTotalSalary();
                // Add pay stub generation logic here
                System.out.println("Pay Stub for Employee #" + employee.getEmployeeNumber() + ": Total Salary - " + totalSalary);
            }
        }
    }
