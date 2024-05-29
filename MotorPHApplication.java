import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;

public class MotorPHApplication extends JFrame {
    private JTextField employeeNumberField;
    private JComboBox<String> payCoverageComboBox;
    private JTextArea resultArea;

    private List<Employee> employees;

    public MotorPHApplication() {
        setTitle("MotorPH Application");
        setSize(400, 200); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        // Initialize the list of employees
        int[] employeeNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34};
        String[] lastNames = {"Garcia", "Lim", "Aquino", "Reyes", "Hernandez", "Villanueva", "San Jose", "Romualdez", "Atienza", "Alvaro", "Salcedo", "Lopez", "Farala", "Martinez", "Romualdez", "Mata", "De Leon", "San Jose", "Rosario", "Bautista", "Lazaro", "Delos Santos", "Santos", "Del Rosario", "Tolentino", "Gutierrez", "Manalaysay", "Villegas", "Ramos", "Maceda", "Aguilar", "Castro", "Martinez", "Santos"};
        String[] firstNames = {"Manuel III", "Antonio", "Bianca Sofia", "Isabella", "Eduard", "Andrea Mae", "Brad", "Alice", "Rosie", "Roderick", "Anthony", "Josie", "Martha", "Leila", "Fredrick", "Christian", "Selena", "Allison", "Cydney", "Mark", "Darlene", "Kolby", "Vella", "Tomas", "Jacklyn", "Percival", "Garfield", "Lizeth", "Carol", "Emelia", "Delia", "John Rafael", "Carlos Ian", "Beatriz"};
        String[] positions = {"Chief Executive Officer", "Chief Operating Officer", "Chief Finance Officer", "Chief Marketing Officer", "IT Operations and Systems", "HR Manager", "HR Team Leader", "HR Rank and File", "HR Rank and File", "Accounting Head", "Payroll Manager", "Payroll Team Leader", "Payroll Rank and File", "Payroll Rank and File", "Account Manager", "Account Team Leader", "Account Team Leader", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Account Rank and File", "Sales & Marketing", "Supply Chain and Logistics", "Customer Service and Relations"};
        double[] basicSalaries = {90000, 60000, 60000, 60000, 52670, 52670, 42975, 22500, 22500, 52670, 50825, 38475, 24000, 24000, 53500, 42975, 41850, 22500, 22500, 23250, 23250, 24000, 22500, 22500, 24000, 24750, 24750, 24000, 22500, 22500, 22500, 52670, 52670, 52670};
        employees = new ArrayList<>();

        // Add employees to the list
        for (int i = 0; i < employeeNumbers.length; i++) {
            employees.add(new Employee(i + 1, firstNames[i], lastNames[i], positions[i], basicSalaries[i]));
        }

        // Employee Number Input
        JLabel employeeNumberLabel = new JLabel("Employee Number:");
        employeeNumberField = new JTextField();

        // Pay Coverage Selection
        JLabel payCoverageLabel = new JLabel("Pay Coverage");
        String[] payCoverages = {"Monthly", "Bi-Weekly", "Weekly"};
        payCoverageComboBox = new JComboBox<>(payCoverages);

        // Buttons for Actions
        JButton calculatePayrollButton = new JButton("Calculate Payroll");
        JButton generatePayStubsButton = new JButton("Generate Pay Stubs");

        // Display Area for Results
        resultArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(resultArea); calculatePayrollButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int employeeNumber = Integer.parseInt(employeeNumberField.getText());
                    String payCoverage = (String) payCoverageComboBox.getSelectedItem();

                    // Validate employee number
                    if (employeeNumber <= 0) {
                        throw new IllegalArgumentException("Employee number must be a positive integer.");
                    }

                    // Validate pay coverage
                    if (!payCoverage.equals("Monthly") &&! payCoverage.equals("Bi-Weekly") &&! payCoverage.equals("Weekly")) {
                        throw new IllegalArgumentException("Invalid pay coverage selection.");
                    }

                    // Find the employee with the entered employee number
                    Employee employee = null;
                    for (Employee emp : employees) {
                        if (emp.getEmployeeNumber() == employeeNumber) {
                            employee = emp;
                            break;
                        }
                    }

                    if (employee != null) {
                        // Perform payroll calculation for the specific employee
                        PayrollProcessor processor = new PayrollProcessor();
                        List<Employee> singleEmployeeList = new ArrayList<>(); singleEmployeeList.add(employee); processor.calculatePayroll(singleEmployeeList);
                        resultArea.append("Employee Number: " + employee.getEmployeeNumber() + "\n");
                        resultArea.append("Name: " + employee.getFirstName() + " " + employee.getLastName() + "\n");
                        resultArea.append("Position: " + employee.getPosition() + "\n");
                        resultArea.append("Total Salary: " + employee.calculateTotalSalary() + "\n");
                    } else { JOptionPane.showMessageDialog(null, "Employee not found.");
                    }
                } catch (NumberFormatException ex) { JOptionPane.showMessageDialog(null, "Invalid Employee Number. Please enter a valid integer.");
                } catch (IllegalArgumentException ex) { JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                } catch (Exception ex) { JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        }); generatePayStubsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add logic to generate pay stubs
                PayrollProcessor processor = new PayrollProcessor(); processor.generatePayStubs(employees);
                resultArea.append("Pay stubs generated.\n");
            }
        });

        add(employeeNumberLabel);
        add(employeeNumberField);
        add(payCoverageLabel);
        add(payCoverageComboBox);
        add(calculatePayrollButton);
        add(generatePayStubsButton);
        add(scrollPane);

        setVisible(true);
        }

        public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MotorPHApplication();
            }
        });
    }
}
