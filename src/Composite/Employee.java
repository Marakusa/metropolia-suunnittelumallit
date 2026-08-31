package Composite;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class Employee {
    private final String name;
    private final double salary;

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public Node parseXml(Document document) {
        Element employeeElement = document.createElement("employee");
        employeeElement.setAttribute("name", getName());
        employeeElement.setAttribute("salary", String.valueOf(getSalary()));
        return employeeElement;
    }
}
