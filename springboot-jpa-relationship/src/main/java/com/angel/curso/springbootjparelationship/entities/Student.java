package com.angel.curso.springbootjparelationship.entities;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String lastname;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(
            name = "students_courses"
            , joinColumns = @JoinColumn(name = "students_id")
            , inverseJoinColumns = @JoinColumn(name = "courses_id")
            , uniqueConstraints = @UniqueConstraint( columnNames = {"students_id", "courses_id"})
    )
    private Set<Course> courses;

    public Student() {
        courses = new HashSet<>();
    }

    public Student(String name, String lastname) {
        this();
        this.name = name;
        this.lastname = lastname;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public void addCourse(Course course) {
        this.getCourses().add(course);
        course.getStudents().add(this);
    }

    public void removeCourse(Course course) {
        this.getCourses().remove(course);
        course.getStudents().remove(this);
    }

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;

        return id == student.id && Objects.equals(name, student.name) && Objects.equals(lastname, student.lastname);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(id);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(lastname);
        return result;
    }

    @Override
    public String toString() {
        return "{" +
                "lastname='" + lastname + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
