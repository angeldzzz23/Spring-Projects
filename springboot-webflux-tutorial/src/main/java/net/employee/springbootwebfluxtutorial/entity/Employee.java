package net.employee.springbootwebfluxtutorial.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Employees")
public class Employee {
    @Id
    private String id;
    private String firstName;
    private String lastname;
    private String email;
}
