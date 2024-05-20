public class EmployeeApp {
    public static void main(String[] args) {
        //Define employee data
        Employee[] employees = {
                new Employee(1, "Garcia", "Manuel III", "10/11/1983", new Position("Chief Executive Officer"), 90000, 535.71),
                new Employee(2, "Lim", "Antonio", "06/19/1988", new Position("Chief Operating Officer"), 60000, 357.14),
                new Employee(3, "Aquino", "Bianca Sofia", "08/04/1989", new Position("Chief Finance Officer"), 60000, 357.14),
                new Employee(4, "Reyes","Isabella", "06/16/1994", new Position("Chief Marketing Officer"), 60000, 357.14),
                new Employee(5, "Hernandez", "Eduard", "09/23/1989", new Position("IT Operations and Systems"), 52670, 313.51),
                new Employee(6, "Villanueva", "Andrea Mae", "02/14/1988", new Position("HR Manager"), 52670, 313.51),
                new Employee(7, "San Jose", "Brad", "03/15/1996", new Position("HR Team Leader"), 42975, 255.80),
                new Employee(8, "Romualdez", "Alice", "05/14/1992", new Position("HR Rank and File"), 22500, 133.93),
                new Employee(9, "Atienza", "Rosie", "09/24/1948", new Position("HR Rank and File"), 22500, 133.93),
                new Employee(10, "Alvaro", "Roderick", "03/30/1988", new Position("Accounting Head"), 52670, 313.51),
                new Employee(11, "Salcedo", "Anthony", "09/14/1993", new Position("Payroll Manager"), 50825, 302.53),
                new Employee(12, "Lopez", "Josie", "01/14/1987", new Position("Payroll Team Leader"), 38475, 229.02),
                new Employee(13, "Farala", "Martha", "01/11/1942", new Position("Payroll Rank and File"), 24000, 142.86),
                new Employee(14, "Martinez", "Leila", "07/11/1970", new Position("Payroll Rank and File"), 24000, 142.86),
                new Employee(15, "Romualdez", "Fredrick", "03/10/1985", new Position("Account Manager"), 53500, 318.45),
                new Employee(16, "Mata", "Christian", "10/21/1987", new Position("Account Team Leader"), 42975, 255.80),
                new Employee(17, "De Leon", "Selena", "02/20/1975", new Position("Account Team Leader"), 41850, 249.11),
                new Employee(18, "San Jose", "Allison", "06/24/1986", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(19, "Rosario", "Cydney", "10/06/1996", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(20, "Bautista", "Mark", "02/12/1991", new Position("Account Rank and File"), 23250, 138.39),
                new Employee(21, "Lazaro", "Darlene", "11/25/1985", new Position("Account Rank and File"), 23250, 138.39),
                new Employee(22, "Delos Santos", "Kolby", "02/26/1980", new Position("Account Rank and File"), 24000, 142.86),
                new Employee(23, "Santos", "Vella", "12/31/1983", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(24, "Del Rosario", "Tomas", "12/18/1978", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(25, "Tolentino", "Jacklyn", "05/19/1984", new Position("Account Rank and File"), 24000, 142.86),
                new Employee(26, "Gutierrez", "Percival", "12/18/1970", new Position("Account Rank and File"), 24750, 147.32),
                new Employee(27, "Manalaysay", "Garfield", "08/28/1986", new Position("Account Rank and File"), 24750, 147.32),
                new Employee(28, "Villegas", "Lizeth", "12/12/1981", new Position("Account Rank and File"), 24000, 142.86),
                new Employee(29, "Ramos", "Carol", "08/20/1978", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(30, "Maceda", "Emelia", "04/14/1973", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(31, "Aguilar", "Delia", "01/27/1989", new Position("Account Rank and File"), 22500, 133.93),
                new Employee(32, "Castro", "John Rafael", "02/09/1992", new Position("Sales & Marketing"), 52670, 313.51),
                new Employee(33, "Martinez", "Carlos Ian", "11/16/1990", new Position("Supply Chain and Logistics"), 52670, 313.51),
                new Employee(34, "Santos", "Beatriz", "08/07/1990", new Position("Customer Service and Relations"), 52670, 313.51)
        };

        // Display employee information in the console
        for (Employee employee : employees) {
            System.out.println("Employee #" + employee.getEmployeeNumber());
            System.out.println("Last Name: " + employee.getLastName());
            System.out.println("First Name: " + employee.getFirstName());
            System.out.println("Birthday: " + employee.getBirthday());
            System.out.println("Position: " + employee.getPosition().getPositionName());
            System.out.println("Basic Salary: " + employee.getBasicSalary());
            System.out.println("Hourly Rate: " + employee.getHourlyRate());
            System.out.println();
        }
    }
}
