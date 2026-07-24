package employee_management.Service;

import employee_management.dto.EmployeeResponseDTO;
import employee_management.model.Department;
import employee_management.model.Employee;
import employee_management.model.repository.DepartmentRepository;
import employee_management.model.repository.EmployeeRepository;
import employee_management.exception.EmployeeNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

     private final EmployeeRepository repository;
     private final ModelMapper modelMapper;
     private final DepartmentRepository departmentRepository;


    EmployeeService(EmployeeRepository repository, ModelMapper modelMapper, DepartmentRepository departmentRepository){
         this.repository = repository;
         this.modelMapper = modelMapper;
        this.departmentRepository = departmentRepository;
    }

        public String message(){
        return "Repository Connected!";
    }

    public Employee addEmployee(Employee employee){

         Department department = departmentRepository.findById(employee.getDepartment().getId())
                 .orElseThrow(() -> new RuntimeException("Department ID " + employee.getDepartment().getId() + " does not exist!"));

         employee.setDepartment(department);

         return repository.save(employee);
    }
//
    public Page<EmployeeResponseDTO> getAllEmployees(Pageable pageable){
         Page<Employee> employees = repository.findAll(pageable);

         return employees.map(employee ->
                 modelMapper.map(employee, EmployeeResponseDTO.class ));
    }

    public List<EmployeeResponseDTO> getEmployeesByRole(String role){

        List<Employee> employees = repository.findByRole(role);

        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .toList();
    }

    public List<EmployeeResponseDTO> getEmployeeBySalary(double salary){
        List<Employee> employees = repository.findBySalaryGreaterThan(salary);

        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .toList();
    }

    public List<EmployeeResponseDTO> getEmployeeByDepartmentAndRole(String department, String role){

        List<Employee> employees = repository.findByDepartmentAndRole(department, role);

        return employees.stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponseDTO.class))
                .toList();
    }

    public EmployeeResponseDTO getEmployeeById(Integer id){
        Employee employee = repository.findById(id)
                .orElseThrow(()->
                    new EmployeeNotFoundException("Employee not found"));

//         if (employee.isPresent()){
//             return employee.get();
//         }
//         throw new EmployeeNotFoundException(
//                 "Employee with ID " + id + " Not found."
//         );

        return modelMapper.map(employee, EmployeeResponseDTO.class);
    }

    public Employee updateEmployee(int id, Employee updatedEmployee){
         Optional<Employee> employee = repository.findById(id);
         if (employee.isPresent()){

             Employee exisitngEmployee = employee.get();

             exisitngEmployee.setName(updatedEmployee.getName());
             exisitngEmployee.setDob(updatedEmployee.getDob());
             exisitngEmployee.setEmail(updatedEmployee.getEmail());
             exisitngEmployee.setPhoneNumber(updatedEmployee.getPhoneNumber());
             exisitngEmployee.setAddress(updatedEmployee.getAddress());
             exisitngEmployee.setDepartment(updatedEmployee.getDepartment());
             exisitngEmployee.setRole(updatedEmployee.getRole());
             exisitngEmployee.setSalary(updatedEmployee.getSalary());

             return repository.save(exisitngEmployee);
         }
         return null;
    }

    public String deleteEmployee(int id){
         Optional<Employee> employee = repository.findById(id);

         if (employee.isPresent()){
             repository.delete(employee.get());


         }
         return "Employee not found";
    }
    

}
