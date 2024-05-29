import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
public class MotorPHApplication extends JFrame {
    private JTable employeeTable;
    private DefaultTableModel tableModel;
    private JButton viewEmployeeButton;
    private JComboBox<String> monthComboBox;
    private JButton computeButton;
    private JTextArea resultArea;

    private List<Employee> employees;

    public MotorPHApplication() {
        setTitle("MotorPH Employee App");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1));

        // Initialize the list of employees using arrays
        Employee[] employeeArray = {
                new Employee(1, "Garcia", "Manuel III", "Chief Executive Officer", 90000.0),
                new Employee(2, "Lim", "Antonio", "Chief Operating Officer", 60000.0),
                // Add more employees as needed
        };

        // Convert the array to a List and add to the employees list
        employees = new ArrayList<>(Arrays.asList(employeeArray));

        // Create the JTable to display employee records
        String[] columnNames = {"Employee Number", "Last Name", "First Name", "SSS No.", "PhilHealth No.", "TIN", "Pagibig No."};
        tableModel = new DefaultTableModel(columnNames, 0);
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);

        // View Employee Button
        viewEmployeeButton = new JButton("View Employee");
        viewEmployeeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    int employeeNumber = (int) tableModel.getValueAt(selectedRow, 0);
                    // Open a new frame for the selected employee
                    openEmployeeDetailsFrame(employeeNumber);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an employee.");
                }
            }
        });

        // Month Selection ComboBox
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        monthComboBox = new JComboBox<>(months);

        // Compute Button
        computeButton = new JButton("Compute");
        computeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = employeeTable.getSelectedRow();
                if (selectedRow != -1) {
                    int employeeNumber = (int) tableModel.getValueAt(selectedRow, 0);
                    String selectedMonth = (String) monthComboBox.getSelectedItem();
                    // Perform salary computation for the selected employee and month
                    computeEmployeeSalary(employeeNumber, selectedMonth);
                } else {
                    JOptionPane.showMessageDialog(null, "Please select an employee to compute salary.");
                }
            }
        });

        // Display Area for Results
        resultArea = new JTextArea();
        JScrollPane resultScrollPane = new JScrollPane(resultArea);

        // Add components to the frame
        add(scrollPane);
        add(viewEmployeeButton);
        add(monthComboBox);
        add(computeButton);
        add(resultScrollPane);

        // Populate the JTable with employee records
        for (Employee emp : employees) {
            Object[] rowData = {emp.getEmployeeNumber(), emp.getLastName(), emp.getFirstName(), "", "", "", ""}; // Placeholder for SSS No., PhilHealth No., TIN, Pagibig No.
            tableModel.addRow(rowData);
        }

        setVisible(true);
    }

    private void openEmployeeDetailsFrame(int employeeNumber) {
        // Find the employee with the specified employee number
        Employee selectedEmployee = null;
        for (Employee emp : employees) {
            if (emp.getEmployeeNumber() == employeeNumber) {
                selectedEmployee = emp;
                break;
            }
        }

        if (selectedEmployee != null) {
            // Create a new frame to display employee details
            JFrame employeeDetailsFrame = new JFrame("Employee Details");
            employeeDetailsFrame.setSize(300, 200); employeeDetailsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            employeeDetailsFrame.setLayout(new GridLayout(5,2));

            // Display employee details in labels
            JLabel employeeNumberLabel = new JLabel("Employee Number: " + selectedEmployee.getEmployeeNumber());
            JLabel firstNameLabel = new JLabel("First Name: " + selectedEmployee.getFirstName());
            JLabel lastNameLabel = new JLabel("Last Name: " + selectedEmployee.getLastName());
            JLabel positionLabel = new JLabel("Position: " + selectedEmployee.getPosition());
            JLabel salaryLabel = new JLabel("Total Salary: " + selectedEmployee.calculateTotalSalary());

            // Add labels to the frame
            employeeDetailsFrame.add(employeeNumberLabel);
            employeeDetailsFrame.add(firstNameLabel);
            employeeDetailsFrame.add(lastNameLabel);
            employeeDetailsFrame.add(positionLabel);
            employeeDetailsFrame.add(salaryLabel);

            // Make the frame visible
            employeeDetailsFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null, "Employee not found.");
        }
    }

    private void computeEmployeeSalary(int employeeNumber, String selectedMonth) {
        double totalSalary = 0.0; // Declare and initialize totalSalary variable
        // Find the employee with the specified employee number
        Employee selectedEmployee = null;
        for (Employee emp : employees) {
            if (emp.getEmployeeNumber() == employeeNumber) {
                selectedEmployee = emp;
                break;
            }
        }

        if (selectedEmployee != null) {
            // Calculate the salary based on the employee's basic salary and any additional factors
            totalSalary = selectedEmployee.calculateTotalSalary();

            // Display the computed total salary in the result area
            resultArea.setText(""); // Clear previous results
            resultArea.append("Employee Number: " + selectedEmployee.getEmployeeNumber() + "\n");
            resultArea.append("Name: " + selectedEmployee.getFirstName() + " " + selectedEmployee.getLastName() + "\n");
            resultArea.append("Position: " + selectedEmployee.getPosition() + "\n");
            resultArea.append("Month: " + selectedMonth + "\n");
            resultArea.append("Total Salary for " + selectedMonth + " " + totalSalary + "\n");
        } else {
            JOptionPane.showMessageDialog(null, "Employee not found.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MotorPHApplication();
            }
        });
    }
}
