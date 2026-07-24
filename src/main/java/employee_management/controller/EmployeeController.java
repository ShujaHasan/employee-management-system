package employee_management.controller;

import employee_management.Service.DepartmentService;
import employee_management.Service.EmployeeService;
import employee_management.dto.EmployeeResponseDTO;
import employee_management.model.Department;
import employee_management.model.Employee;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService = employeeService;
    }
//
    @GetMapping("/test")
    public String test(){
        return employeeService.message();
    }

    @PostMapping("/employees")
    public Employee addEmployee(@Valid @RequestBody Employee employee){
        return employeeService.addEmployee(employee);
    }

    @GetMapping("/employees")
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable){
        return employeeService.getAllEmployees(pageable);
    }

    @GetMapping("/employees/{id}")
    public EmployeeResponseDTO getEmployeeById(@PathVariable int id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("employees/role/{role}")
    public List<EmployeeResponseDTO> getEmployeeByRole(@PathVariable String role){
        return employeeService.getEmployeesByRole(role);
    }

    @GetMapping("employees/salary/greater/{salary}")
    public List<EmployeeResponseDTO> getEmployeeBySalary(@PathVariable double salary){
        return employeeService.getEmployeeBySalary(salary);
    }

    @GetMapping("employees/department/{department}/role/{role}")
    public List<EmployeeResponseDTO> getEmployeeByDepartmentAndRole(@PathVariable String department, @PathVariable String role) {
        return employeeService.getEmployeeByDepartmentAndRole(department, role);
    }

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }



}
