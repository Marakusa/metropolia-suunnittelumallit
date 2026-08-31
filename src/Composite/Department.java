package Composite;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import java.util.ArrayList;

public class Department {
    private final String name;

    public String getName() {
        return name;
    }

    private final ArrayList<Department> departments;
    private final ArrayList<Employee> employees;

    public ArrayList<Department> getDepartments() {
        return departments;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public Department(String name) {
        this.name = name;

        departments = new ArrayList<>();
        employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void removeDepartment(Department department) {
        departments.remove(department);
    }

    public Node parseXml(Document document) {
        Element departmentElement = document.createElement("department");
        departmentElement.setAttribute("name", getName());
        for (Employee employee : employees) {
            departmentElement.appendChild(employee.parseXml(document));
        }
        for (Department department : departments) {
            departmentElement.appendChild(department.parseXml(document));
        }
        return departmentElement;
    }
}
