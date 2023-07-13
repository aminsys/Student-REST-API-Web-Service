package com.student.studentregistration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.StudentNotFoundException;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student getStudentById(Long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        }

        else {
            throw new StudentNotFoundException("Student with ID " + id + " doesn't exist");
        }

    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
}
