package employee_management.model.repository;

import employee_management.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository
        extends JpaRepository<Employee, Integer> {

    List<Employee> findByRole(String role);

    List<Employee> findBySalaryGreaterThan(double salary);

    List<Employee> findByDepartmentAndRole(String department, String role);
}