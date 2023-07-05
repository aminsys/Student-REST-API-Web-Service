package com.student.studentregistration;

import java.util.List;
import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {

    @Autowired
    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/students/liststudents")
    @ResponseBody
    public List<Student> getStudentds(){
        return studentRepository.findAll();
    }

    @PostMapping("/add/student")
    @ResponseBody
    public RegistrationReply addStudent(@RequestBody Student student){
        RegistrationReply stdReg = new RegistrationReply();
        ObjectId objId = new ObjectId();
        student.setId(objId);
        studentRepository.save(student);
        stdReg.setId(objId);
        stdReg.setName(student.getName());
        stdReg.setGrade(student.getGrade());
        stdReg.setRegDateTime(LocalDateTime.now());

        return stdReg;
    }

    @PutMapping("/update/student/{id}")
    @ResponseBody
    public String updateStudent(@RequestBody Student student, @PathVariable String id ){
        ObjectId objId = new ObjectId(id);
        if(studentRepository.existsById(objId)) {
            studentRepository.deleteById(objId);
            studentRepository.save(student);
            return "Student with id " + objId.toString() + " has been updated.";
        }
        return "Student with id " + objId.toString() + " doesn't exist";
    }

    @DeleteMapping("/delete/student/{id}")
    @ResponseBody
    public String deleteStudent(@PathVariable String id){
        ObjectId objId = new ObjectId(id);
        if(studentRepository.existsById(objId)){
            studentRepository.deleteById(objId);
            return "Student with id " + objId + " has been deleted";
        }
        return "Student with id " + objId + " doesn't exist";
    }
    
}
