package com.student.studentregistration;

import org.bson.types.ObjectId;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = StudentRepository.class)
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
        return strings -> {
            studentRepository.save(new Student(new ObjectId(), "Calvin, Keld", 80));
            studentRepository.save(new Student(new ObjectId(),"Bryson, Bilal", 41));
            studentRepository.save(new Student(new ObjectId(),"Clíntonson, Mazín", 100));
            studentRepository.save(new Student(new ObjectId(),"Bin Hamid, Layla", 100));
        };
    }
}
