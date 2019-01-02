package pub.liyf.bean;

import java.io.Serializable;
import java.util.Objects;

public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = -622235723656604219L;
    private Double salary;
    private String job;

    public Employee() {

    }

    public Employee(String id, String name, Integer age, Double salary, String job) {
        super(id, name, age);
        this.salary = salary;
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() +"\'" +
                "name='" + getName() + '\'' +
                "age=" + getAge() +
                ",salary=" + salary +
                ", job='" + job + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employee.getId(), this.getId());
    }

}