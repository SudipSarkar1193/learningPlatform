package com.educonnect.model.user.student;

import com.educonnect.model.course.Enrollment;
import com.educonnect.model.user.Parent;
import com.educonnect.model.user.User;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "student_id")
public class Student extends User {

    private LocalDate dateOfBirth;
    private String enrollmentNumber;

    // Links to Parents
    @ManyToMany(mappedBy = "children")
    private List<Parent> parents;

    // Links to Academic Records (Cross-package relationship)
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Enrollment> enrollments;

    @OneToOne(mappedBy = "student", cascade = CascadeType.ALL)
    private StudentDocument studentDocument;
}