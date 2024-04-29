package com.angel.curso.springbootjparelationship.repositories;

import com.angel.curso.springbootjparelationship.entities.Course;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CourseRepository extends CrudRepository<Course, Long> {

    Optional<Course> findById(Long id);

    @Query("select c from Course c left join fetch c.students where c.id = :id")
    Optional<Course> findByIdWithStudents(Long id);
}
