package employee_management.Service;

import employee_management.model.Employee;
import employee_management.model.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {

     private final EmployeeRepository repository;

     EmployeeService(EmployeeRepository repository){
         this.repository = repository;
     }

        public String message(){
        return "Repository Connected!";
    }

    public Employee addEmployee(Employee employee){
         return repository.save(employee);
    }

    public List<Employee> getAllEmployees(){
         return repository.findAll();
    }

    public Employee getEmployeeById(int id){
        Optional<Employee> employee = repository.findById(id);

         if (employee.isPresent()){
             return employee.get();
         }
         return null;
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

             return "Employee deleted scucesfully!";
         }
         return "Employee not found";
    }



}
