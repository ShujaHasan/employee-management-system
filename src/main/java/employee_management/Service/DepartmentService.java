package employee_management.Service;

import employee_management.model.Department;
import employee_management.model.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;
    public DepartmentService(DepartmentRepository departmentRepository){
        this.departmentRepository = departmentRepository;
    }

    public Department addDepartment(Department department){
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Integer id){
        Optional<Department> department = departmentRepository.findById(id);

        if (department.isPresent()){
            return department.get();
        }
        return null;
    }

}
