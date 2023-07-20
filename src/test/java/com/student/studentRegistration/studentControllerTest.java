package com.student.studentRegistration;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.student.studentregistration.Student;
import com.student.studentregistration.StudentRegistrationApplication;
import com.student.studentregistration.StudentService;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(classes = StudentRegistrationApplication.class)
class studentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private StudentService studentService;

    @Test
    void testGetUserById() throws Exception {
        long userId = 9000L;

        Student mockStudent = new Student(1001L, "Calvin, Keld", 80);

        when(studentService.getStudentById(userId)).thenReturn(mockStudent);

        mockMvc.perform(get("/students/{id}", userId))
                .andExpect(status().isOk());
    }
}