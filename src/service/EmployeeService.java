package service;

import dao.EmployeeDAO;
import model.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService {
    private EmployeeDAO employeeDAO = new EmployeeDAO();

    public void addEmployee(Employee emp) {
        try {
            employeeDAO.addEmployee(emp);
        } catch (SQLException e) {
            System.out.println("Error adding employee: " + e.getMessage());
        }
    }

    public void listAllEmployees() {
        try {
            List<Employee> employees = employeeDAO.getAllEmployees();
            if (employees.isEmpty()) {
                System.out.println("No employees found.");
            } else {
                System.out.println("\n=== All Employees ===");
                for (Employee emp : employees) {
                    System.out.println(emp);
                }
                System.out.println("=====================\n");
            }
        } catch (SQLException e) {
            System.out.println("Error fetching employees: " + e.getMessage());
        }
    }

    public void updateEmployee(Employee emp) {
        try {
            employeeDAO.updateEmployee(emp);
        } catch (SQLException e) {
            System.out.println("Error updating employee: " + e.getMessage());
        }
    }

    public void deleteEmployee(int id) {
        try {
            employeeDAO.deleteEmployee(id);
        } catch (SQLException e) {
            System.out.println("Error deleting employee: " + e.getMessage());
        }
    }

    public Employee findEmployeeById(int id) {
        try {
            return employeeDAO.getEmployeeById(id);
        } catch (SQLException e) {
            System.out.println("Error finding employee: " + e.getMessage());
            return null;
        }
    }
}