package net.employee.springbootwebfluxtutorial.service;

import net.employee.springbootwebfluxtutorial.dto.EmployeeDto;
import reactor.core.publisher.Mono;

public interface EmployeeService {
    Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto);

}
