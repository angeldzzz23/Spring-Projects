package net.javaStudent.sms.repository;

import net.javaStudent.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
