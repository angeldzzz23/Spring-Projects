package net.javaStudent.sms.Service.impl;

import net.javaStudent.sms.Service.StudentService;
import net.javaStudent.sms.dto.StudentDto;
import net.javaStudent.sms.entity.Student;
import net.javaStudent.sms.mapper.StudentMapper;
import net.javaStudent.sms.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {


    private StudentRepository studentRepository;

    // when it conly has one parameter in constructor, we can omit autowired implementation
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtos = students.stream()
                .map((student) -> StudentMapper.mapToStudentDto(student))
                .collect(Collectors.toList());
        return studentDtos;
    }

    @Override
    public void createStudent(StudentDto studentDto) {

        Student student = StudentMapper.mapToStudent(studentDto);
        studentRepository.save(student);

    }


    @Override
    public StudentDto getStudentById(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        StudentDto studentDto = StudentMapper.mapToStudentDto(student);

        return studentDto;
    }


    @Override
    public void updateStudent(StudentDto studentDto) {
        studentRepository.save(StudentMapper.mapToStudent(studentDto));

    }


    @Override
    public void deleteStudent(Long studentId) {
        studentRepository.deleteById(studentId);
    }


}
