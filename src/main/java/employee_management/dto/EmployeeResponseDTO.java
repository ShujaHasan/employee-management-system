package employee_management.dto;

import employee_management.model.Department;

public class EmployeeResponseDTO {

    private Integer id;
    private String name;
    private String email;
    private Department department;
    private String role;

    public EmployeeResponseDTO() {
    }

    public EmployeeResponseDTO(Integer id, String name, String email, Department department, String role) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.department = department;
        this.role = role;
    }

    // Generate getters and setters


    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
}