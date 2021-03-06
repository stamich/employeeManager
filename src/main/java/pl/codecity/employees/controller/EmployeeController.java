package pl.codecity.employees.controller;

import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.codecity.employees.model.Employee;
import pl.codecity.employees.service.EmployeeServiceImpl;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImpl employeeService;

    @ApiOperation(value = "Getting all employees")
    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAll(){
        return ResponseEntity.ok(employeeService.findAll());
    }
    @ApiOperation(value = "Adding one employee")
    @PostMapping("/add")
    public ResponseEntity create(@Valid @RequestBody Employee employee){
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @ApiOperation(value = "Getting one employee")
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getOneById(@PathVariable Long id){
        Optional<Employee> employees = employeeService.findOneById(id);
        if (!employees.isPresent()){
            //log.error("Id" + id + " is not existed.");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employees.get());
    }

    @ApiOperation(value = "Updating employee")
    @PutMapping("/update/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @Valid @RequestBody Employee employee) {
        if (!employeeService.findOneById(id).isPresent()) {
            //log.error("Id " + id + " is not existed.");
            ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(employeeService.save(employee));
    }

    @ApiOperation(value = "Deleting employees")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        if (!employeeService.findOneById(id).isPresent()) {
            //log.error("Id " + id + " is not existed");
            ResponseEntity.badRequest().build();
        }
        employeeService.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
