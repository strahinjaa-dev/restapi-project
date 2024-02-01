package org.example.models;

import org.example.models.Instructor;
import javax.persistence.*;
import javax.xml.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer student_id;
    private String first_name;
    private String last_name;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Instructor instructor;

    public Student(){}


    public Student(Integer student_id, String first_name, String last_name, Instructor instructor) {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.instructor = instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public Instructor getInstructor() {
        return instructor;
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
