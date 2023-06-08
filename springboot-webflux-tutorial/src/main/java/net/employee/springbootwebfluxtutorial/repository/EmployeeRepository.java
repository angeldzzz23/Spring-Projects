package net.employee.springbootwebfluxtutorial.repository;

import net.employee.springbootwebfluxtutorial.entity.Employee;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface EmployeeRepository extends ReactiveCrudRepository<Employee, String> {


}
