package employee_management.model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

import java.util.List;

@Entity
public class Employee {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer id;

    @NotBlank(message = "Name cannot be empty!")
    private String name;
    private String dob;

    @Email(message = "Invalid Email!")
    @NotBlank(message = "Email is requiered!")
    private String email;

    @NotBlank(message = "Phone Number cannot be empty!")
    private String phoneNumber;

    private String address;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    @JsonIgnore
    private Department department;

    private String role;

    @Positive(message = "Salary must be positive!")
    private double salary;

    public Employee() {

    }

    public Employee(String name, String dob, String email, String phoneNumber,
                    String address, Department department, String role, double salary) {
        this.name = name;
        this.dob = dob;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public Department getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



}

