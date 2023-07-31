package com.student.studentregistration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.exception.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/students/liststudents")
    @ResponseBody
    public List<Student> getStudentds(){
        return studentService.getAllStudents();
    }

    @GetMapping("/students/{id}")
    @ResponseBody
    public Student getStudentById(@PathVariable Long id) throws StudentNotFoundException {
        return studentService.getStudentById(id);
    }
    
    @PutMapping("student/update/{id}")
    public void updateStudent(@PathVariable String id, @RequestBody Student student) throws NoStudentUpdatePossible {
        studentService.updateStudent(student);
    }
}
