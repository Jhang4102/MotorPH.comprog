import java.util.ArrayList;
import java.util.List;

public class EmployeeApp {
    public static void main(String[] args) {
        //Define employee data using arrays
        int[] employeeNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
        String[] lastNames = {"Garcia", "Lim", "Aquino", "Reyes", "Hernandez", "Villanueva", "San Jose", "Romualdez", "Atienza", "Alvaro", "Salcedo", "Lopez", "Farala", "Martinez", "Romualdez", "Mata", "De Leon", "San Jose", "Rosario", "Bautista", "Lazaro", "Delos Santos", "Santos", "Del Rosario", "Tolentino", "Gutierrez", "Manalaysay", "Villegas", "Ramos", "Maceda", "Aguilar", "Castro", "Martinez", "Santos"};
        String[] firstNames = {"Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard", "Andrea Mae", "Brad", "Alice", "Rosie", "Roderick", "Anthony", "Josie", "Martha", "Leila", "Fredrick", "Christian", "Selena", "Allison", "Cydney", "Mark", "Darlene", "Kolby", "Vella", "Tomas", "Jacklyn", "Percival", "Garfield", "Lizeth", "Carol", "Emelia", "Delia", "John Rafael", "Carlos Ian", "Beatriz"};
        String[] positions = {"Chief Executive Officer", "Chief Operating Officer", "Chief Finance Officer", "Chief Marketing Officer", "IT Operations and Systems", "HR Manager", "HR Team Leader", "HR Rank and File", "HR Rank and File", "Accounting Head", "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Payroll Rank and File", "Account Manager", "Account Team Leader", "Account Team Leader", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics", "Customer Service and Relations"};
        double[] basicSalaries = {90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 52670, 50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 22500, 23250, 23250, 24000, 22500, 22500, 24000, 24750, 24750, 24000, 22500, 22500, 22500, 52670, 52670, 52670};
        double[] hourlyRates = {535.71, 357.14, 357.14, 357.14, 313.51, 313.51, 255.80, 133.93, 133.93, 313.51, 302.53, 229.02, 142.86, 318.45, 255.80, 249.11, 133.93, 133.93, 138.39, 138.39, 142.86, 133.93, 133.93, 142.86, 147.32, 147.32, 142.86, 133.93, 133.93, 133.93, 313.51, 313.15, 313.15};
        double[] riceSubsidies = {1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500, 1500};
        double[] clothingAllowances = {1000, 1000, 1000, 1000, 1000, 1000, 800, 500, 500, 1000, 1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 1000, 1000, 1000};
        double[] phoneAllowances = {2000, 2000, 2000, 2000, 1000, 1000, 800, 500, 500, 1000, 1000, 800, 500, 500, 1000, 800, 800, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 500, 1000, 1000, 1000};

        List<Employee> employees = new ArrayList<>();

        // Populate the employees list with employee objects
        for (int i = 0; i < employeeNumbers.length; i++) {
            Employee employee = new Employee(employeeNumbers[i], lastNames[i], firstNames[i], positions[i], basicSalaries[i]);
            employees.add(employee);
        }

        // Display employee information
        for (Employee employee : employees) {
            System.out.println("Employee #" + employee.getEmployeeNumber());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Position: " + employee.getPosition());
            System.out.println("Basic Salary: " + employee.getBasicSalary());
            System.out.println("Hourly Rate: " + employee.getHourlyRate());
            System.out.println("Rice Subsidy: " + employee.getRiceSubsidy());
            System.out.println("Clothing Allowance: " + employee.getClothingAllowance());
            System.out.println("Phone Allowance: " + employee.getPhoneAllowance());
        }
    }
}
