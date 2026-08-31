package Composite;

import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

public class Organization {
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

    public Organization(String name) {
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

    public void parseXml() {
        try {
            // Create XML document
            DocumentBuilderFactory factory =
                    DocumentBuilderFactory.newInstance();

            DocumentBuilder builder =
                    factory.newDocumentBuilder();

            Document document = builder.newDocument();

            // Create the root element
            Element organizationElement =
                    document.createElement("organization");

            organizationElement.setAttribute("name", name);

            document.appendChild(organizationElement);

            // Add employees
            for (Employee employee : employees) {
                organizationElement.appendChild(
                        employee.parseXml(document)
                );
            }

            // Add departments
            for (Department department : departments) {
                organizationElement.appendChild(
                        department.parseXml(document)
                );
            }

            // Create XML transformer
            TransformerFactory transformerFactory =
                    TransformerFactory.newInstance();

            Transformer transformer =
                    transformerFactory.newTransformer();

            // Pretty-print XML
            transformer.setOutputProperty(
                    OutputKeys.INDENT,
                    "yes"
            );

            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount",
                    "4"
            );

            // Print XML to console
            transformer.transform(
                    new DOMSource(document),
                    new StreamResult(System.out)
            );

        } catch (Exception e) {
            System.out.println("Error parsing XML: " + e.getMessage());
        }
    }
}
