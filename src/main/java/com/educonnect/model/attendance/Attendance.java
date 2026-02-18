package com.educonnect.model.attendance;

import com.educonnect.model.course.Course;
import com.educonnect.model.user.student.Student;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Data
public class Attendance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;

    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    private boolean isPresent;
    private String remarks; // Optional field for any additional notes (e.g., reason for absence)
}