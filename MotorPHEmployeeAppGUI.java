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
        // Add more employees with different attributes

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
