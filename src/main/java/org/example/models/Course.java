package org.example.models;

import javax.persistence.*;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer course_id;

    private String course_name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Course(){}

    public Course(Integer course_id, String course_name, Department department) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.department = department;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }
}