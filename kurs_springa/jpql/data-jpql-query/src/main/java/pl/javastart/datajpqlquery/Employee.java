package pl.javastart.datajpqlquery;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
class Employee {

    @Id
    private Long id;
    private String firstName;
    private String lastName;
    private double salary;

    public Employee(){}

    public Employee(Long id, String firstName, String lastName, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", salary=" + salary +
                '}';
    }
}
