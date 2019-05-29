package pl.codecity.employees.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.codecity.employees.model.Employee;
import pl.codecity.employees.service.EmploeeServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
@Slf4j
@RequiredArgsConstructor
public class EmployeeAPI {

    private final EmploeeServiceImpl employeeService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }

    @PostMapping
    public ResponseEntity create(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @GetMapping
    public ResponseEntity<Employee> getById(@PathVariable Long id){
        Optional<Employee> employees = employeeService.findOneById(id);
        if (!employees.isPresent()){
            log.error("Id" + id + " is not existed.");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employees.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (!employeeService.findOneById(id).isPresent()) {
            log.error("Id " + id + " is not existed.");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!employeeService.findOneById(id).isPresent()) {
            log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        employeeService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
