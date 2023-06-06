package net.javaStudent.sms.controller;

import net.javaStudent.sms.Service.StudentService;
import net.javaStudent.sms.dto.StudentDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
public class StudentController {
    private StudentService studentService;

    // injectin student service dependency
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // handler method to handle list of student requests
    @GetMapping("/students")
    public String listStudents(Model model) {
        List<StudentDto> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

}
