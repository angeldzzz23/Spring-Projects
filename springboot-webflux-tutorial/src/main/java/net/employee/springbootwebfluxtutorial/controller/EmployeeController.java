package net.employee.springbootwebfluxtutorial.controller;

import lombok.AllArgsConstructor;
import net.employee.springbootwebfluxtutorial.dto.EmployeeDto;
import net.employee.springbootwebfluxtutorial.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/api/employees")
public class EmployeeController {
    private EmployeeService employeeService;

    // Build reactive save employee REST API
    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<EmployeeDto> savedEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.saveEmployee(employeeDto);
    }

    // build reactive get single employee REST API
    @GetMapping("{id}")
    public Mono<EmployeeDto> getEmployee(@PathVariable("id") String employeeId) {
        return employeeService.getEmployee(employeeId);
    }

    // build reactive get all employeesDto
    @GetMapping()
    public Flux<EmployeeDto> getAllEmployee() {
        return employeeService.getAllEmployees();
    }

    // Build Reactive Updated Employee REST
    @PutMapping("{id}")
    public Mono<EmployeeDto> updateEmployee(@RequestBody EmployeeDto employeeDto,
                                            @PathVariable("id") String employeeId) {

        return employeeService.updateEmployee(employeeDto, employeeId);
    }

    // build reactive delete employee rest api
    @DeleteMapping("{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public Mono<Void> deleteEmployee(@PathVariable("id") String employeeId) {
        return employeeService.deleteEmployee(employeeId);
    }




}
