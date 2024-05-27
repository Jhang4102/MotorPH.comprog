import java.util.HashMap;

public class EmployeeDatabase {
    public HashMap<Integer, Employee> database;

    public EmployeeDatabase() {
        database = new HashMap<>();
    }

    public void addEmployee(Employee employee) { database.put(employee.getEmployeeNumber(), employee);
    }

    public void updateEmployee(Employee employee) {
        if (database.containsKey(employee.getEmployeeNumber())) {
            database.put(employee.getEmployeeNumber(), employee);
        } else {
            System.out.println("Employee not found in the database. Unable to update.");
        }
    }

    public Employee retrieveEmployee(int employeeNumber) {
        if (database.containsKey(employeeNumber)) {
            return database.get(employeeNumber);
        } else {
            System.out.println("Employee not found in the database.");
            return null;
        }
    }

    public void deleteEmployee(int employeeNumber) {
        if (database.containsKey(employeeNumber)) {
            database.remove(employeeNumber);
        } else {
            System.out.println("Employee not found in the database. Unable to delete.");
        }
    }

    public HashMap<Integer, Employee> getEmployees() {
        return database;
    }

    public HashMap<Integer,Employee> database() {
        return null;
    }
}
