import javax.swing.*;
import java.awt.*;

public class MotorPHEmployeeAppGUI extends JFrame {
    private final Employee[] employeeDatabase;
    private final EmployeeUI employeeUI;
    private final EmployeeValidator employeeValidator;
    private final SalaryCalculator salaryCalculator;

    public MotorPHEmployeeAppGUI() {
        setTitle("MotorPH Employee App GUI");
        setSize(600, 400); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MotorPH Employee App"); titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Initialize the Employee Database using an array
        employeeDatabase = new Employee[34];

        // Populate the employee database with data
        employeeDatabase[0] = new Employee(1, "Garcia", "Manuel III", "Chief Executive Officer", 90000.0);
        employeeDatabase[1] = new Employee(2, "Lim", "Antonio", "Chief Operating Officer", 60000.0);
        employeeDatabase[2] = new Employee(3, "Aquino", "Bianca Sofia", "Chief Finance Officer", 60000.0);
        employeeDatabase[3] = new Employee(4, "Reyes", "Isabella", "Chief Marketing Officer", 60000.0);
        employeeDatabase[4] = new Employee(5, "Hernandez", "Eduard", "IT Operations and Systems", 52670.0);
        employeeDatabase[5] = new Employee(6, "Villanueva", "Andrea Mae", "HR Manager", 52370.0);
        employeeDatabase[6] = new Employee(7, "San Jose", "Brad", "HR Team Leader", 42975.0);
        employeeDatabase[7] = new Employee(8, "Romualdez", "Alice", "HR Rank and File", 22500.0);
        employeeDatabase[8] = new Employee(9, "Atienza", "Rosie", "HR Rank and File", 22500.0);
        employeeDatabase[9] = new Employee(10, "Alvaro", "Roderick", "Accounting Head", 52670.0);
        employeeDatabase[10] = new Employee(11, "Salcedo", "Anthony", "Payroll Manager", 50825.0);
        employeeDatabase[11] = new Employee(12, "Lopez", "Josie", "Payroll Team Leader", 38475.0);
        employeeDatabase[12] = new Employee(13, "Farala", "Martha", "Payroll Rank and File", 24000.0);
        employeeDatabase[13] = new Employee(14, "Martinez", "Leila", "Payroll Rank and File", 24000.0);
        employeeDatabase[14] = new Employee(15, "Romualdez", "Fredrick", "Account Manager", 53500.0);
        employeeDatabase[15] = new Employee(16, "Mata", "Christian", "Account Team Leader", 42975.0);
        employeeDatabase[16] = new Employee(17, "De Leon", "Selena", "Account Team Leader", 41850.0);
        employeeDatabase[17] = new Employee(18, "San Jose", "Allison", "Account Rank and File", 22500.0);
        employeeDatabase[18] = new Employee(19, "Rosario", "Cydney", "Account Rank and File", 22500.0);
        employeeDatabase[19] = new Employee(20, "Bautista", "Mark", "Account Rank and File", 23250.0);
        employeeDatabase[20] = new Employee(21, "Lazaro", "Darlene", "Account Rank and File", 23250.0);
        employeeDatabase[21] = new Employee(22, "Delos Santos", "Kolby", "Account Rank and File", 24000.0);
        employeeDatabase[22] = new Employee(23, "Santos", "Vella", "Account Rank and File", 22500.0);
        employeeDatabase[23] = new Employee(24, "Del Rosario", "Tomas", "Account Rank and File", 22500.0);
        employeeDatabase[24] = new Employee(25, "Tolentino", "Jacklyn", "Account Rank and File", 24000.0);
        employeeDatabase[25] = new Employee(26, "Gutierrez", "Percival", "Account Rank and File", 24750.0);
        employeeDatabase[26] = new Employee(27, "Manalaysay", "Garfield", "Account Rank and File", 24750.0);
        employeeDatabase[27] = new Employee(28, "Villegas", "Lizeth", "Account Rank and File", 24000.0);
        employeeDatabase[28] = new Employee(29, "Ramos", "Carol", "Account Rank and File", 22500.0);
        employeeDatabase[29] = new Employee(30, "Maceda", "Emelia", "Account Rank and File", 22500.0);
        employeeDatabase[30] = new Employee(31, "Aguilar", "Delia", "Account Rank and File", 22500.0);
        employeeDatabase[31] = new Employee(32, "Castro", "John Rafael", "Sales & Marketing", 52670.0);
        employeeDatabase[32] = new Employee(33, "Martinez", "Carlos Ian", "Supply Chain and Logistics", 52670.0);
        employeeDatabase[33] = new Employee(34, "Santos", "Beatriz", "Customer Service and Relation", 52670.0);

        // Display the initialized Employee Database
        for (Employee emp : employeeDatabase) {
            if (emp != null) {
                System.out.println("Employee #" + emp.getEmployeeNumber() + " " + emp.getFirstName() + " " + emp.getLastName() + " " + emp.getPosition() + " " + emp.getBasicSalary());
            }
        }

        // Setup the Employee UI
        employeeUI = new EmployeeUI();
        add(employeeUI, BorderLayout.CENTER);

        // Setup the Employee Validator
        employeeValidator = new EmployeeValidator();

        //Setup the Salary Calculator
        salaryCalculator = new SalaryCalculator(); employeeUI.getSubmitButton().addActionListener(e -> {
            String employeeNumberText = employeeUI.getEmployeeNumberField().getText();
            int employeeNumber = Integer.parseInt(employeeNumberText);
            Employee employee = null;
            for (Employee emp : employeeDatabase) {
                if (emp != null && emp.getEmployeeNumber() == employeeNumber) {
                    employee = emp;
                    break;
                }
            }

            if (employee != null) {
                if (employeeValidator.validateEmployeeData(employee)) {
                    double netSalary = salaryCalculator.calculateSalary(employee);
                    // Display the net salary or perform further actions
                    JOptionPane.showMessageDialog(null, "Net Salary for Employee #" + employeeNumber + ": PHP" + netSalary);
                }
            } else { JOptionPane.showMessageDialog(null, "Employee not found in the database.");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MotorPHEmployeeAppGUI::new);
    }
}
