package com.educonnect.model.assessment;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.educonnect.model.user.student.Student;

@Entity
@Data
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submissionId;

    @ManyToOne
    @JoinColumn(name = "assessment_id")
    private Assessment assessment;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;

    private String submissionUrl; // S3 Link or File Path
    private Double obtainedScore;
    private LocalDateTime submittedAt;
    private String teacherFeedback;
}