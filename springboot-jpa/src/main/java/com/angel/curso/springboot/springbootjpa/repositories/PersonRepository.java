package com.angel.curso.springboot.springbootjpa.repositories;

import com.angel.curso.springboot.springbootjpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {
    //  para consultas

    //  automatico
    List<Person> findByProgrammingLanguage(String programmingLanguage);

    //  no automatico y personalizado
    @Query("select p from Person p where p.id = ?1 and p.name = ?2")
    List<Person> buscar(long id, String name);

    //  personalizado y automatico
    List<Person> findByIdAndName(long id, String name);

    //  personalizadas que retornan un arreglo, no una entidad
    @Query("select p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> obtenerPersonValues();


    @Query("select p.name, p.lastname, p.programmingLanguage from Person p where p.name = ?1 and p.lastname = ?2 and p.programmingLanguage = ?3")
    List<Object[]> obtenerPersonValues(String name, String lastname, String programmingLanguage);

    @Query("select p.name, p.lastname, p.programmingLanguage from Person p where p.id = :id")
    List<Object[]> obtenerPersonValues(long id);

    @Query("select p.name, p.lastname, p.programmingLanguage from Person p where p.name = :name")
    List<Object[]> obtenerPersonValues(String name);

    @Query("select p from Person p where p.id = ?1")
    Optional<Person> findOne(Long id);

    @Query("select p from Person p where p.name = ?1")
    Optional<Person> findOneName(String name);

    //  para buscar por contenido aunque no sea exactamente igual
    @Query("select p from Person p where p.name like  %?1%")//  % al inicio que empice con % al final que termine con, dos % que contenga
    Optional<Person> findOneNameLike(String name);

    //  para retornar el campo
    @Query("select p.name from Person p where p.id = :id")
    String getNameById(Long id);

    //  obtener nombre y apellido
    @Query("select concat(p.name, ' ' , p.lastname) as fullname from Person p where p.id = :id")
    String getFullNameById(Long id);

    //  obtener todos los campos de un registro
    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p where p.id = :id")
    Object[] getFullById(Long id);
}
