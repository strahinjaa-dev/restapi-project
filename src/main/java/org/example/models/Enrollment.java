package org.example.models;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Enrollment implements Serializable {

        @Embeddable
        public static class EnrollmentId implements Serializable {
            @Column(name = "student_id")
            private int studentId;

            @Column(name = "course_id")
            private int courseId;

            public int getStudentId() {
                return studentId;
            }

            public int getCourseId() {
                return courseId;
            }

            public void setStudentId(int studentId) {
                this.studentId = studentId;
            }

            public void setCourseId(int courseId) {
                this.courseId = courseId;
            }
        }

        @EmbeddedId
        private EnrollmentId enrollment_id;

        @MapsId("studentId")
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "student_id", nullable = false, insertable = false, updatable = false)
        private Student student;

        @MapsId("courseId")
        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "course_id", nullable = false, insertable = false, updatable = false)
        private Course course;

    public EnrollmentId getEnrollment_id() {
        return enrollment_id;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public void setEnrollment_id(EnrollmentId enrollment_id) {
        this.enrollment_id = enrollment_id;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Enrollment(EnrollmentId id, Student student, Course course) {
        this.enrollment_id = id;
        this.student = student;
        this.course = course;
    }
    public Enrollment(){}
}


