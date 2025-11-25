import model.Employee;
import service.EmployeeService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Email: ");
                    String email = sc.nextLine();
                    System.out.print("Enter Department: ");
                    String dept = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();

                    Employee newEmp = new Employee(name, email, dept, salary);
                    service.addEmployee(newEmp);
                    break;

                case 2:
                    service.listAllEmployees();
                    break;

                case 3:
                    System.out.print("Enter Employee ID to update: ");
                    int updateId = sc.nextInt();
                    sc.nextLine();

                    Employee empToUpdate = service.findEmployeeById(updateId);
                    if (empToUpdate == null) {
                        System.out.println("Employee not found!");
                        break;
                    }

                    System.out.println("Current: " + empToUpdate);
                    System.out.print("New Name (" + empToUpdate.getName() + "): ");
                    String newName = sc.nextLine();
                    if (newName.isEmpty()) newName = empToUpdate.getName();

                    System.out.print("New Email (" + empToUpdate.getEmail() + "): ");
                    String newEmail = sc.nextLine();
                    if (newEmail.isEmpty()) newEmail = empToUpdate.getEmail();

                    System.out.print("New Department (" + empToUpdate.getDepartment() + "): ");
                    String newDept = sc.nextLine();
                    if (newDept.isEmpty()) newDept = empToUpdate.getDepartment();

                    System.out.print("New Salary (" + empToUpdate.getSalary() + "): ");
                    String salaryInput = sc.nextLine();
                    double newSalary = salaryInput.isEmpty() ? empToUpdate.getSalary() : Double.parseDouble(salaryInput);

                    Employee updatedEmp = new Employee(updateId, newName, newEmail, newDept, newSalary);
                    service.updateEmployee(updatedEmp);
                    break;

                case 4:
                    System.out.print("Enter Employee ID to delete: ");
                    int deleteId = sc.nextInt();
                    service.deleteEmployee(deleteId);
                    break;

                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option!");
            }
        }
    }
}