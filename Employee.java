import java.util.Scanner;

public class Employee {
    private int employeeNumber;
    private String lastName;
    private String firstName;
    private String birthday;
    private Position position; // Updated to be of type Position
    private double basicSalary;
    private double riceSubsidy;
    private double phoneAllowance;
    private double clothingAllowance;
    private double grossSemiMonthlyRate;
    private String startTime;
    private String endTime;
    private double hourlyRate;
    private double weeklySalary;
    private double sssDeduction;
    private double pagIbigDeduction;
    private double philhealthDeduction;
    private double incomeTaxDeduction;

    public double calculateTotalSalary() {
        // Calculate the total salary based on basic salary, allowances, and deductions
        return basicSalary + riceSubsidy + phoneAllowance + clothingAllowance;
    }

    public void displayEmployeeInfo() {
        System.out.println("Employee Info:");
        System.out.println("Name: " + firstName + " " + lastName);
        System.out.println("Position: " + position.getPositionName()); // Accessing getPositionName() from Position object
        System.out.println("Total Salary: PHP" + calculateTotalSalary());
    }

    public Employee(int employeeNumber, String lastName, String firstName, String birthday, Position position, double basicSalary, double hourlyRate) {
        this.employeeNumber = employeeNumber;
        this.lastName = lastName;
        this.firstName = firstName;
        this.birthday = birthday;
        this.position = position;
        this.basicSalary = basicSalary;
        this.hourlyRate = hourlyRate;
    }

    public void calculateWeeklySalary() {
        Scanner scanner = new Scanner(System.in);
        double totalHoursWorked = 0;

        for (int day = 1; day <= 7; day++) {
            System.out.print("Enter hours worked for day " + day + ":");
            double hoursWorked = scanner.nextDouble();
            totalHoursWorked += hoursWorked;
        }

        // Apply 10-minute grace period for each day
        totalHoursWorked -= Math.min(10*7, totalHoursWorked); // Assuming 10-minute grace period per day

        // Calculate Weekly Salary
        weeklySalary = totalHoursWorked * hourlyRate;

        // Calculate deductions
        calculateSSSDeduction(weeklySalary);

        calculatePagIbigDeduction(weeklySalary);

        calculatePhilhealthDeduction(weeklySalary);

        calculateIncomeTaxDeduction(weeklySalary);
    }

    private void calculateSSSDeduction(double salary) {
        // Implement SSS deduction calculation based on the salary
        // Add the calculated SSS deduction to the total deductions
        sssDeduction = 0; // Example: Set SSS deduction to 0 for demonstration
    }

    private void calculatePagIbigDeduction(double salary) {
        // Implement Pag-ibig deduction calculation based on the salary
        // Add the calculated Pag-ibig deduction to the total deductions
        pagIbigDeduction = 0; // Example: Set Pag-ibig deduction to 0 for demonstration
    }

    private void calculatePhilhealthDeduction(double salary) {
        // Implement Philhealth deduction calculation based on the salary
        // Add the calculated Philhealth deduction to the total deduction
        philhealthDeduction = 0; // Example: Set Philhealth deduction to 0 for demonstration
    }

    private void calculateIncomeTaxDeduction(double salary) {
        // Implement Income Tax deduction calculation based on the salary
        // Add the calculated Income Tax deduction to the total deduction
        incomeTaxDeduction = 0; // Example: Set Income Tax deduction to 0 for demonstration
    }

    public double getNetWage() {
        double totalDeductions = sssDeduction + pagIbigDeduction + philhealthDeduction + incomeTaxDeduction;
        return weeklySalary - totalDeductions;
    }

    public double getWeeklySalary() {
        return weeklySalary;
    }

    public static void main (String[] args) {
        Position chiefExecutiveOfficer = new Position("Chief Executive Officer");
        Employee employee = new Employee(1, "Garcia", "Manuel III", "10/11/1983", chiefExecutiveOfficer, 90000.0, 535.71); // Assuming hourly rate is $10

        employee.displayEmployeeInfo();

        employee.calculateWeeklySalary();
        System.out.println("Weekly Salary: $" + employee.getWeeklySalary());
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getBirthday() {
        return birthday;
    }

    public Position getPosition() {
        return position;
    }

    public double getBasicSalary() {
        return basicSalary;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public double calculateHoursWorked() {
        if (startTime == null || endTime == null) {
            return 0; // Return 0 hours if start time or end time is null
        }

        String[] startParts = startTime.split(";");
        String[] endParts = endTime.split(";");

        if (startParts.length != 2 || endParts.length != 2) {
            return 0; // Return 0 hours if start time or end time format is incorrect
        }
        int startHour = Integer.parseInt(startTime.split(";")[0]);
        int startMinute = Integer.parseInt(startTime.split(";")[1]);
        int endHour = Integer.parseInt(endTime.split(";")[0]);
        int endMinute = Integer.parseInt(endTime.split(";")[1]);

        // Calculate total minutes worked
        int totalMinutesWorked = (endHour * 60 + endMinute) - (startHour * 60 + startMinute);

        // Apply the 10-minute grace period
        if (startHour < 8 || (startHour == 8 && startMinute < 11)) {
            totalMinutesWorked -= Math.min(10, totalMinutesWorked);
        }

        // Convert total minutes worked to hours
        double totalHoursWorked = totalMinutesWorked / 60.0;

        return totalHoursWorked;
    }
}
