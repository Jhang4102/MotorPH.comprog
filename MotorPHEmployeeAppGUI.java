import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.TableModel;
import javax.swing.event.ListSelectionEvent;
import java.util.ArrayList;
import java.util.List;

public class MotorPHEmployeeAppGUI extends JFrame {
    private final List<Employee> employeeDatabase;
    private final JTable employeeTable;
    private final JTextField lastNameField;
    private final JTextField firstNameField;
    private final JTextField sssField;
    private final JTextField philHealthField;
    private final JTextField tinField;
    private final JTextField pagibigField;

    public MotorPHEmployeeAppGUI() {
        setTitle("MotorPH Employee App GUI");
        setSize(1200, 400); setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("MotorPH Employee App"); titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel, BorderLayout.NORTH);

        // Initialize the Employee Database using an array
        employeeDatabase = new ArrayList<>();
        initializeEmployeeDatabase();

        // Create a DefaultTableModel and JTable for employee records
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("Employee Number");
        tableModel.addColumn("Last Name");
        tableModel.addColumn("First Name");
        tableModel.addColumn("SSS No.");
        tableModel.addColumn("PhilHealth No.");
        tableModel.addColumn("TIN");
        tableModel.addColumn("Pagibig No.");

        for (Employee employee : employeeDatabase) {
            tableModel.addRow(new Object[]{ employee.getEmployeeNumber(), employee.getLastName(), employee.getFirstName(), employee.getSSSNumber(), employee.getPhilHealthNumber(), employee.getTinNumber(), employee.getPagibigNumber(),});
        }

        // Create JScrollPane with JTable for employee records
        employeeTable = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(employeeTable);
        add(scrollPane, BorderLayout.CENTER);

        lastNameField = new JTextField(10);
        firstNameField = new JTextField(10);
        sssField = new JTextField(10);
        philHealthField = new JTextField(10);
        tinField = new JTextField(10);
        pagibigField = new JTextField(10);

        // Add ListSelectionListener to update TextFields when row is selected
        ListSelectionModel selectionModel = employeeTable.getSelectionModel(); selectionModel.addListSelectionListener((ListSelectionEvent e) -> {
            int selectedRow = employeeTable.getSelectedRow();
            if (selectedRow != -1) {
                TableModel model = employeeTable.getModel(); lastNameField.setText(model.getValueAt(selectedRow, 1).toString()); firstNameField.setText(model.getValueAt(selectedRow, 2).toString()); sssField.setText(model.getValueAt(selectedRow, 3).toString()); philHealthField.setText(model.getValueAt(selectedRow, 4).toString()); tinField.setText(model.getValueAt(selectedRow, 5).toString()); pagibigField.setText(model.getValueAt(selectedRow, 6).toString());
            }
        });

        add(createUpdatePanel(), BorderLayout.EAST);
        add(createButtonPanel(), BorderLayout.WEST);
        add(createBottomPanel(), BorderLayout.SOUTH);

        setVisible(true);
    }

    private JPanel createUpdatePanel() {
        JPanel updatePanel = new JPanel();
        updatePanel.setLayout(new GridLayout(0, 2));
        updatePanel.add(new JLabel("LastName:"));
        updatePanel.add(lastNameField);
        updatePanel.add(new JLabel("First Name:"));
        updatePanel.add(firstNameField);
        updatePanel.add(new JLabel("SSS No.:"));
        updatePanel.add(sssField);
        updatePanel.add(new JLabel("PhilHealth No.:"));
        updatePanel.add(philHealthField);
        updatePanel.add(new JLabel("TIN:"));
        updatePanel.add(tinField);
        updatePanel.add(new JLabel("Pagibig No.:"));
        updatePanel.add(pagibigField);
        updatePanel.add(new JButton("Update"));
        return updatePanel;
    }

    private JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0, 1));
        buttonPanel.add(new JButton("Delete"));
        buttonPanel.add(new JButton("Refresh"));
        return buttonPanel;
    }

    private JPanel createBottomPanel() {
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(0, 1));
        bottomPanel.add(new JButton("Leave Application"));
        bottomPanel.add(new JButton("View Employee"));
        return bottomPanel;
    }

    private void initializeEmployeeDatabase() {
        // Populate the employee database with data
        employeeDatabase.add(new Employee(1, "Garcia", "Manuel III", "Chief Executive Officer", 90000.0, 1500.0, 2000.0, 1000.0, "44-4506057-3", "820126853951", "691295330870", "442-605-657-000"));
        employeeDatabase.add(new Employee(2, "Lim", "Antonio", "Chief Operating Officer", 60000.0, 1500.0, 2000.0, 1000.0, "52-2067274-9", "331735646338", "663904995411", "683-102-776-000"));
        employeeDatabase.add(new Employee(3, "Aquino", "Bianca Sofia", "Chief Finance Officer", 60000.0, 1500.0, 2000.0, 1000.0, "30-8870406-2", "177451189665", "171519773969", "971-711-280-000"));
        employeeDatabase.add(new Employee(4, "Reyes", "Isabella", "Chief Marketing Officer", 60000.0, 1500.0, 2000.0, 1000.0, "40-2511815-0", "341911411254", "416946776041", "876-809-437-000"));
        employeeDatabase.add(new Employee(5, "Hernandez", "Eduard", "IT Operations and Systems", 52670.0, 1500.0, 1000.0, 1000.0, "50-5577638-1", "957436191812", "952347222457", "031-702-374-000"));
        employeeDatabase.add(new Employee(6, "Villanueva", "Andrea Mae", "HR Manager", 52370.0, 1500.0, 1000.0, 1000.0, "49-1632020-8", "382189453145", "441093369646", "317-674-022-000"));
        employeeDatabase.add(new Employee(7, "San Jose", "Brad", "HR Team Leader", 42975.0, 1500.0, 800.0, 800.0, "40-2400714-1", "239192926939", "210850209964", "672-474-690-000"));
        employeeDatabase.add(new Employee(8, "Romualdez", "Alice", "HR Rank and File", 22500.0, 1500.0, 500.0, 500.0, "55-4476527-2", "545652640232", "211385556888", "888-572-294-000"));
        employeeDatabase.add(new Employee(9, "Atienza", "Rosie", "HR Rank and File", 22500.0, 1500.0, 500.0, 500.0, "41-0644692-3", "708988234853", "260107732354", "604-997-793-000"));
        employeeDatabase.add(new Employee(10, "Alvaro", "Roderick", "Accounting Head", 52670.0, 1500.0, 1000.0, 1000.0, "64-7605054-4", "578114853794", "799254095212", "525-420-419-000"));
        employeeDatabase.add(new Employee(11, "Salcedo", "Anthony", "Payroll Manager", 50825.0, 1500.0, 1000.0, 1000.0, "26-9647608-3", "126445315651", "218002473454", "210-805-911-000"));
        employeeDatabase.add(new Employee(12, "Lopez", "Josie", "Payroll Team Leader", 38475.0, 1500.0, 800.0, 800.0, "44-8563448-3", "431709011012", "113071293354", "218-489-737-000"));
        employeeDatabase.add(new Employee(13, "Farala", "Martha", "Payroll Rank and File", 24000.0, 1500.0, 500.0, 500.0, "45-5656375-0", "233693897247", "631130283546", "210-835-851-000"));
        employeeDatabase.add(new Employee(14, "Martinez", "Leila", "Payroll Rank and File", 24000.0, 1500.0, 500.0, 500.0, "27-2090996-4", "515741057496", "101205445886", "275-792-513-000"));
        employeeDatabase.add(new Employee(15, "Romualdez", "Fredrick", "Account Manager", 53500.0, 1500.0, 1000.0, 1000.0, "26-8768374-1", "308366860059", "223057707853", "598-065-761-000"));
        employeeDatabase.add(new Employee(16, "Mata", "Christian", "Account Team Leader", 42975.0, 1500.0, 800.0,800.0, "49-2959312-6", "824187961962", "631052853464", "103-100-522-000"));
        employeeDatabase.add(new Employee(17, "De Leon", "Selena", "Account Team Leader", 41850.0, 1500.0, 800.0, 800.0, "27-2090208-8", "587272469938", "719007608464", "482-259-498-000"));
        employeeDatabase.add(new Employee(18, "San Jose", "Allison", "Account Rank and File", 22500.0, 1500.0, 500.0,500.0, "45-3251383-0", "745148459521", "114907859343", "121-203-336-000"));
        employeeDatabase.add(new Employee(19, "Rosario", "Cydney", "Account Rank and File", 22500.0, 1500.0,500.0, 500.0, "49-1629900-2", "579253495499", "265104358643", "122-244-511-000"));
        employeeDatabase.add(new Employee(20, "Bautista", "Mark", "Account Rank and File", 23250.0, 1500.0, 500, 500, "49-1647342-5", "399665157135", "260054585575", "273-970-941-000"));
        employeeDatabase.add(new Employee(21, "Lazaro", "Darlene", "Account Rank and File", 23250.0, 1500.0, 500.0, 500.0, "45-5617168-2", "606386917510", "104907708845", "354-650-951-000"));
        employeeDatabase.add(new Employee(22, "Delos Santos", "Kolby", "Account Rank and File", 24000.0, 1500.0, 500.0, 500.0, "52-0109570-6", "357451271274", "113017988667", "187-500-345-000"));
        employeeDatabase.add(new Employee(23, "Santos", "Vella", "Account Rank and File", 22500.0, 1500.0, 500.0, 500.0, "52-9883524-3", "548670482885", "360028104576", "101-558-994-000"));
        employeeDatabase.add(new Employee(24, "Del Rosario", "Tomas", "Account Rank and File", 22500.0, 1500.0, 500.0, 500.0, "45-5866331-6", "953901539995", "913108649964", "560735732000"));
        employeeDatabase.add(new Employee(25, "Tolentino", "Jacklyn", "Account Rank and File", 24000.0, 1500.0, 500.0,500.0, "47-1692793-0", "753800654114", "210546661243", "841-177-857-000"));
        employeeDatabase.add(new Employee(26, "Gutierrez", "Percival", "Account Rank and File", 24750.0, 1500.0, 500.0, 500.0, "40-9504657-8", "797639382265", "210897095686", "502-995-670-000"));
        employeeDatabase.add(new Employee(27, "Manalaysay", "Garfield", "Account Rank and File", 24750.0, 1500.0, 500.0, 500.0, "45-3298166-4", "810909286264", "211274476563", "336-676-445-000"));
        employeeDatabase.add(new Employee(28, "Villegas", "Lizeth", "Account Rank and File", 24000.0, 1500.0, 500.0, 500.0, "40-2400719-4", "934389652994", "122238077997", "210-395-397-000"));
        employeeDatabase.add(new Employee(29, "Ramos", "Carol", "Account Rank and File", 22500.0, 1500.0, 500.0, 500.0, "60-1152206-4", "351830469744", "212141893454", "395-032-717-000"));
        employeeDatabase.add(new Employee(30, "Maceda", "Emelia", "Account Rank and File", 22500.0, 1500.0, 500.0, 500.0, "54-1331005-0", "465087894112", "515012579765", "215-973-013-000"));
        employeeDatabase.add(new Employee(31, "Aguilar", "Delia", "Account Rank and File", 22500.0, 1500.0, 500.0, 500.0, "52-1859253-1", "136451303068", "110018813465", "599-312-588-000"));
        employeeDatabase.add(new Employee(32, "Castro", "John Rafael", "Sales & Marketing", 52670.0, 1500.0, 1000.0, 1000.0, "26-7145133-4", "601644902402", "697764069311", "404-768-309-000"));
        employeeDatabase.add(new Employee(33, "Martinez", "Carlos Ian", "Supply Chain and Logistics", 52670.0, 1500.0, 1000.0, 1000.0, "11-5068372-7", "380685387212", "993372963726", "256-436-296-000"));
        employeeDatabase.add(new Employee(34, "Santos", "Beatriz", "Customer Service and Relation", 52670.0, 1500.0, 1000.0, 1000.0, "20-2987501-5", "918460050077", "874042259378", "911-529-713-000"));
    }

    private void openEmployeeDetailsFrame(int employeeNumber) {
        JFrame employeeDetailsFrame = new JFrame("Employee Details");
        employeeDetailsFrame.setSize(400, 200);
        employeeDetailsFrame.setLayout(new FlowLayout());

        JLabel monthLabel = new JLabel("Select Month");
        String[] months = {"January", "Febuary", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        JComboBox<String> monthComboBox = new JComboBox<>(months);
        JButton computeButton = new JButton("Compute");

        // Add action listener to the Compute button
        computeButton.addActionListener(e -> {
            String selectedMonth = (String) monthComboBox.getSelectedItem();
            Employee selectedEmployee = findEmployeeByNumber(employeeNumber);

            if (selectedEmployee != null) {
                double salary = calculateSalaryForMonth(selectedEmployee, selectedMonth); JOptionPane.showMessageDialog(null, "Salary details for Employee #" + selectedEmployee.getEmployeeNumber() + " in" + selectedMonth + ": PHP " + salary);
            } else {JOptionPane.showMessageDialog(null, "Employee not found in the database.");
            }
        });

        employeeDetailsFrame.add(monthLabel); employeeDetailsFrame.add(monthComboBox); employeeDetailsFrame.add(computeButton);

        employeeDetailsFrame.setVisible(true);
    }

    private Employee findEmployeeByNumber(int employeeNumber) {
        for (Employee employee : employeeDatabase) {
            if (employee != null && employee.getEmployeeNumber() == employeeNumber) {
                return employee;
            }
        }
        return null;
    }

    private double calculateSalaryForMonth(Employee employee, String month) {
        double basicSalary = employee.getBasicSalary();
        double riceSubsidy = employee.getRiceSubsidy();
        double phoneAllowance = employee.getPhoneAllowance();
        double clothingAllowance = employee.getClothingAllowance();

        double totalDeductions = riceSubsidy + phoneAllowance + clothingAllowance;
        double additionalDeductions = calculateAdditionalDeductions(month);

        return basicSalary - totalDeductions - additionalDeductions;
    }

    private double calculateAdditionalDeductions(String month) {
        double additionalDeductions = 0.0;

        switch (month.toLowerCase()) {
            case "december":
                additionalDeductions = 1000.0;
                break;
            case "january":
                additionalDeductions = 500.0;
                break;
        }

        return additionalDeductions;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MotorPHEmployeeAppGUI::new);
    }
}
