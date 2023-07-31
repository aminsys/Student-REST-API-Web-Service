package com.student.studentregistration;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.exception.*;

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

    public void updateStudent(Student student){

        Optional<Student> obj = studentRepository.findById(student.getId());
        if (obj.isPresent()) {
            this.studentRepository.save(student);
        }
        else {
            throw new NoStudentUpdatePossible("Can't update a student that doesn't exist. Please check the student's ID that you are trying to update.");
        }
    }
}
