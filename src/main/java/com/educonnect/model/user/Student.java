package com.educonnect.model.user;

import com.educonnect.model.course.Enrollment;
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
}