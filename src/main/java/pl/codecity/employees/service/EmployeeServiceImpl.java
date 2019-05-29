package pl.codecity.employees.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.codecity.employees.model.Employee;
import pl.codecity.employees.repository.EmployeeRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> findAll(){
        return repository.findAll();
    }

    public Optional<Employee> findOneById(Long id){
        return repository.findById(id);
    }

    public Employee save(Employee employee){
        return repository.save(employee);
    }

    public void deleteById(Long id){
        repository.deleteById(id);
    }
}
