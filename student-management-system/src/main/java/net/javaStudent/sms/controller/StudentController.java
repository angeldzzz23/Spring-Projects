package net.javaStudent.sms.controller;

import jakarta.validation.Valid;
import net.javaStudent.sms.Service.StudentService;
import net.javaStudent.sms.dto.StudentDto;
import net.javaStudent.sms.entity.Student;
import net.javaStudent.sms.mapper.StudentMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

    // handler method to handle new student request
    @GetMapping("/students/new")
    public String newStudent(Model model) {
        // student model object to store student form data
        StudentDto studentDto  = new StudentDto();
        model.addAttribute("student", studentDto);
        return "create_student";
    }

    @PostMapping("/students")
    public String saveStudent(@Valid @ModelAttribute("student") StudentDto student, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("student", student);
            return "create_student";

        }

        studentService.createStudent(student);
        return "redirect:/students";
    }


    // handler method to handle save student form submisssion
//    @Override
//    public void createStudents(StudentDto studentDto) {
//        Student student = StudentMapper.mapToStudent(studentDto);
//    }

}
