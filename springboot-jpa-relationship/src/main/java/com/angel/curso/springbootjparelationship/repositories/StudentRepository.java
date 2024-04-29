package com.angel.curso.springbootjparelationship.repositories;

import com.angel.curso.springbootjparelationship.entities.Student;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("select c from Student c left join fetch c.courses where c.id = :id")
    Optional<Student> findByIdWithCourses(Long id);
}
