package employee_management.controller;

import employee_management.Service.EmployeeService;
import employee_management.dto.EmployeeResponseDTO;
import employee_management.model.Employee;
import employee_management.model.repository.EmployeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


import java.security.PublicKey;

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

    @PutMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee){
        return employeeService.updateEmployee(id, employee);
    }

    @DeleteMapping("/employees{id}")
    public String deleteEmployee(@PathVariable int id){
        return employeeService.deleteEmployee(id);
    }

}
