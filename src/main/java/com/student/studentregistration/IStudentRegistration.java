package com.student.studentregistration;

import java.util.List;

public interface IStudentRegistration {
    void addStudent(Student student);
    void updateStudent(Student student);
    List<Student> getAllStudents();
    void deleteStudent(Student student);
}
