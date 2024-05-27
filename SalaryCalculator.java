public class SalaryCalculator {
    public double calculateSalary(Employee employee) {
        double totalSalary = employee.calculateTotalSalary();
        double pagIbigDeduction = employee.calculatePagIbigDeduction(totalSalary);
        double philhealthDeduction = employee.calculatePhilhealthDeduction(totalSalary);
        double incomeTaxDeduction = employee.calculateIncomeTaxDeduction(totalSalary);

        // Calculate the netSalary after deductions
        double netSalary = totalSalary - pagIbigDeduction - philhealthDeduction - incomeTaxDeduction;

        return netSalary;
    }
}
