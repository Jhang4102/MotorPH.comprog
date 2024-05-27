import java.util.List;
import java.util.ArrayList;

public class EmployeeSearch {
    private List<Employee> employeeList;

    public EmployeeSearch(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> searchByPosition(String positionName) {
        // Search for employees by position
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getPosition().equalsIgnoreCase(positionName)){
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> searchByLastName(String lastName) {
        // Search for employees by last name
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getLastName().equalsIgnoreCase(lastName)) {
                result.add(employee);
            }
        }
        return result;
    }
}
