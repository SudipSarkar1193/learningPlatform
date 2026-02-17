package com.educonnect.model.assessment;

import com.educonnect.model.user.Student;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

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