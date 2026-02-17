package com.educonnect.model.assessment;

import com.educonnect.model.course.Course;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Data
public class Assessment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long assessmentId;

    private String title;
    private Double maxScore;
    private LocalDateTime deadline;

    @Enumerated(EnumType.STRING)
    private AssessmentType type;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;
}