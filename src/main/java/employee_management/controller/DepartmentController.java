package employee_management.controller;

import employee_management.Service.DepartmentService;
import employee_management.model.Department;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {
    private final DepartmentService departmentService;


    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/department")
    public Department addDepartment(@RequestBody Department department){
        return departmentService.addDepartment(department);
    }

    @GetMapping("/department/{id}")
    public Department getDepartment(@PathVariable Integer id){
        return departmentService.getDepartmentById(id);
    }


}
