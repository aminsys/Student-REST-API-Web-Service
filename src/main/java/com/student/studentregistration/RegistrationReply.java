package com.student.studentregistration;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationReply {

    ObjectId id;
    String name;
    int grade;
    LocalDateTime regDateTime;
}
