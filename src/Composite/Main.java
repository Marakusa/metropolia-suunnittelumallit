package Composite;

public class Main {
    public static void main(String[] args) {
        Organization organization = new Organization("My Organization");
        organization.addEmployee(new Employee("Employee 0", 50000));

        Department department1 = new Department("Department 1");
        department1.addEmployee(new Employee("Employee 1", 50000));
        department1.addEmployee(new Employee("Employee 2", 60000));

        Department department2 = new Department("Department 2");
        department2.addEmployee(new Employee("Employee 3", 70000));
        department2.addEmployee(new Employee("Employee 4", 80000));

        Department department11 = new Department("Department 1.1");
        department11.addEmployee(new Employee("Employee 5", 70000));
        department11.addEmployee(new Employee("Employee 6", 80000));
        department1.addDepartment(department11);

        organization.addDepartment(department1);
        organization.addDepartment(department2);

        organization.parseXml();
    }
}
