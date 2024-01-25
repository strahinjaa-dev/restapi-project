package org.example.models;

import javax.xml.*;


public class Student {

    private Integer student_id;
    private String first_name;
    private String last_name;

    private Integer instructor_id;

    public Student(){}

    public Student(Integer student_id, String first_name, String last_name, Integer instructor_id) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.instructor_id = instructor_id;
    }

    public void setInstructor_id(Integer instructor_id) {
        this.instructor_id = instructor_id;
    }

    public Integer getInstructor_id() {
        return instructor_id;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }


}
