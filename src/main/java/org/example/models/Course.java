package org.example.models;

public class Course {

    private Integer course_id;
    private String course_name;

    private Integer department_id_fk;

    public Course(){}
    public Course(Integer course_id, String course_name, Integer department_id_fk) {
        this.course_id = course_id;
        this.course_name = course_name;
        this.department_id_fk = department_id_fk;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public void setDepartment_id_fk(Integer department_id_fk) {
        this.department_id_fk = department_id_fk;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public Integer getDepartment_id_fk() {
        return department_id_fk;
    }
}
