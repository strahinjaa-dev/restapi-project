package org.example.models;

public class Enrollment {

    private Integer student_id;
    private Integer course_id;

    public Enrollment(){}

    public Enrollment(Integer student_id, Integer course_id) {
        this.student_id = student_id;
        this.course_id = course_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    @Override
    public String toString() {
        return "Enrollment{" +
                "student_id=" + student_id +
                ", course_id=" + course_id +
                '}';
    }
}

