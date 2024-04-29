package com.angel.curso.springbootjparelationship.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "Courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String instructor;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    public Course() {
        this.students = new HashSet<>();
    }

    public Course(String name, String instructor) {
        this();
        this.name = name;
        this.instructor = instructor;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

    public void addStudent(Student student) {
        this.getStudents().add(student);
        student.getCourses().add(this);
    }

    public void removeStudent(Student student) {
        this.getStudents().remove(student);
        student.getCourses().remove(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course course)) return false;

        return id == course.id && Objects.equals(name, course.name) && Objects.equals(instructor, course.instructor);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(instructor);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", instructor='" + instructor + '\'' +
                '}';
    }
}
