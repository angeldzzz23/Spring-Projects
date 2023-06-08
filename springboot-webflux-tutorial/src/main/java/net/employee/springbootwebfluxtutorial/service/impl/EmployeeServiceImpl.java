package net.employee.springbootwebfluxtutorial.service.impl;

import lombok.AllArgsConstructor;
import net.employee.springbootwebfluxtutorial.dto.EmployeeDto;
import net.employee.springbootwebfluxtutorial.entity.Employee;
import net.employee.springbootwebfluxtutorial.mapper.EmployeeMapper;
import net.employee.springbootwebfluxtutorial.repository.EmployeeRepository;
import net.employee.springbootwebfluxtutorial.service.EmployeeService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public Mono<EmployeeDto> saveEmployee(EmployeeDto employeeDto) {
        // convert EmployeeDto into Employee entity
        Employee employee =  EmployeeMapper.mapToEmployee(employeeDto);
        Mono<Employee> savedEmployee = employeeRepository.save(employee);


        return savedEmployee.map((employeeEntity) -> EmployeeMapper
                .mapToEmployeeDto(employeeEntity));
    }

    @Override
    public Mono<EmployeeDto> getEmployee(String employeeId) {

        Mono<Employee> savedEmployee = employeeRepository.findById(employeeId);



        return savedEmployee
                .map((employee) -> EmployeeMapper.mapToEmployeeDto(employee));
    }
}
