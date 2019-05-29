package pl.codecity.employees.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.codecity.employees.model.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Employee findOneById(Long id);

    //List<Employee> findAll(Long id);
}
