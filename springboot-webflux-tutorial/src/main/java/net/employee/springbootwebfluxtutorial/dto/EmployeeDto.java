package net.employee.springbootwebfluxtutorial.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
// we created  an employee dto
public class EmployeeDto {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
}
