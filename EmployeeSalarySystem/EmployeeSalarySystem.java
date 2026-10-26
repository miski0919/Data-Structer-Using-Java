package Assignment;
// Parent class
class Employee {
    protected String employeeId;
    protected String name;
    protected String department;
    protected double basicSalary;

    public Employee(String employeeId, String name, String department, double basicSalary) {
        this.employeeId = employeeId;
        this.name = name;
        this.department = department;
        this.basicSalary = basicSalary;
    }

    public double calculateSalary() {
        return basicSalary;
    }

    public String getCategory() {
        return "Employee";
    }

    public void displayInfo() {
        System.out.println("Employee ID: " + employeeId);
        System.out.println("Name: " + name);
        System.out.println("Category: " + getCategory());
        System.out.printf("Monthly Salary: $%.2f\n", calculateSalary());
        System.out.println();
    }
}

// Subclass 1: FullTimeEmployee
class FullTimeEmployee extends Employee {
    private double allowance;

    public FullTimeEmployee(String employeeId, String name, String department, double basicSalary, double allowance) {
        super(employeeId, name, department, basicSalary);
        this.allowance = allowance;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + allowance;
    }

    @Override
    public String getCategory() {
        return "Full-Time Employee";
    }
}

// Subclass 2: PartTimeEmployee
class PartTimeEmployee extends Employee {
    private double hoursWorked;
    private double hourlyRate;

    public PartTimeEmployee(String employeeId, String name, String department, double hoursWorked, double hourlyRate) {
        super(employeeId, name, department, 0.0);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double calculateSalary() {
        return hoursWorked * hourlyRate;
    }

    @Override
    public String getCategory() {
        return "Part-Time Employee";
    }
}

// Subclass 3: Manager
class Manager extends Employee {
    private double bonus;

    public Manager(String employeeId, String name, String department, double basicSalary, double bonus) {
        super(employeeId, name, department, basicSalary);
        this.bonus = bonus;
    }

    @Override
    public double calculateSalary() {
        return basicSalary + bonus;
    }

    @Override
    public String getCategory() {
        return "Manager";
    }
}

// Main class to execute and demonstrate polymorphism
public class EmployeeSalarySystem {
    public static void main(String[] args) {
        Employee[] employees = new Employee[3];

        employees[0] = new FullTimeEmployee("EMP001", "Ahmed Ali", "Administration", 500.0, 150.0);
        employees[1] = new PartTimeEmployee("EMP002", "Fatima Hassan", "Support", 40.0, 6.0);
        employees[2] = new Manager("EMP003", "Mohamed Omar", "Operations", 1000.0, 200.0);

        System.out.println("===== EMPLOYEE SALARY REPORT =====");
        System.out.println();

        for (Employee emp : employees) {
            emp.displayInfo();
        }
    }
}

