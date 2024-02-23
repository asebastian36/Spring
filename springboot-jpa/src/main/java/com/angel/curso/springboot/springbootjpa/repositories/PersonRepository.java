package com.angel.curso.springboot.springbootjpa.repositories;

import com.angel.curso.springboot.springbootjpa.dto.PersonDto;
import com.angel.curso.springboot.springbootjpa.entities.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.*;

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
    Optional<Object> getFullById(Long id);

    //  obtener todos los campos de todos los registros
    @Query("select p.id, p.name, p.lastname, p.programmingLanguage from Person p")
    List<Object[]> getFullDataList();

    //  retornar el campo y el objeto completo
    @Query("select p, p.programmingLanguage from Person p")
    List<Object[]> findAllMix();

    //  regresar una instancia excluyendo campos, se requiere agregar un constructor
    @Query("select new Person(p.name, p.lastname) from Person p")
    List<Person> findAllClassPerson();

    //  regresar una instancia pero como una clase dto excluyendo campos
    @Query("select new com.angel.curso.springboot.springbootjpa.dto.PersonDto(p.name, p.lastname) from Person p")
    List<PersonDto> findAllDtoPerson();

    //  regresa una lista de nombres
    @Query("select p.name from Person p")
    List<String> findAllNames();

    //  regresa los nombres sin repetir
    @Query("select distinct (p.name) from Person p")
    List<String> findAllNamesDistinc();

    //  regresa los lenguajes sin repetir
    @Query("select distinct (p.programmingLanguage) from Person p")
    List<String> findAllLanguageDistinc();

    //  cuenta la cantidad de registros de la consulta
    @Query("select count(distinct(p.programmingLanguage)) from Person p")
    Long findAllLanguageDistincCount();

    //  regresa el nombre completo

    //  @Query("select concat(p.name, ' ', p.lastname) from Person p") opcion 1
    @Query("select p.name || ' ' || p.lastname from Person p")//    opcion 2
    List<String> findAllFullNamesConcat();

    @Query("select lower(concat(p.name, ' ', p.lastname)) from Person p")
    List<String> findAllFullNamesConcatLower();

    @Query("select upper(p.name || ' ' || p.lastname) from Person p")//    opcion 2
    List<String> findAllFullNamesConcatUpper();

    @Query("select p.id, upper(concat(p.name, ' ', p.lastname)), lower(p.programmingLanguage) from Person p")
    List<String> findAllPersonDataListCase();

    //  between : rango de valores
    @Query("select p from Person p where p.id between :initial and :end")
    List<Person> findBetweenById(Long initial, Long end);

    @Query("select p from Person p where  p.name between :initial and :end")
    List<Person> findAllBetweenChars(String initial, String end);

    //  order by ordena de manera ascendente por defecto y segun el campo
    @Query("select p from Person p where p.id between :initial and :end order by p.name asc, p.lastname desc")
    List<Person> findBetweenByIdOrderByName(Long initial, Long end);

    //  para cambiar el tipo de orden se usan asc y desc, tambien funciona para mas de un campo
    //  cuando hay dos campos el segundo criterio se aplica si tienen el nombre igual
    @Query("select p from Person p where  p.name between :initial and :end order by p.name, p.lastname desc")
    List<Person> findAllBetweenCharsOrderByName(String initial, String end);

    //  order by de manera automatica
    List<Person> findByIdBetweenOrderByNameAsc(Long initial, Long end);
    List<Person> findByNameBetweenOrderByLastnameDesc(String initial, String end);
    List<Person> findAllByOrderByNameDesc();

    //  funciones de agregacion
    @Query("select count(p) from Person p")
    Long getTotalPerson();

    @Query("select min(p.id) from Person p")
    Long getMinId();

    @Query("select max(p.id) from Person p")
    Long getMaxId();

    @Query("select p.name, length(p.name) from Person p ")
    public List<Object[]> getPersonNameLength();

    @Query("select min(length(p.name)) from Person p")
    public Long getMinLengtName();

    @Query("select max(length(p.name)) from Person p")
    public Long getMaxLengtName();

    @Query("select min(p.id), max(p.id), sum(p.id), avg(length(p.name)), count(p.id) from Person p")
    public Object getResumeAggregationFunction();

    //  sub consultas

    //  obtiene el nombre y su longitud del registro con el menor tamano
    @Query("select p.name, length(p.name) from Person p where length(p.name) = (select min(length(p.name)) from Person p)")
    public List<Object[]> getShorterName();

    @Query("select p from Person p where p.id = (select max(p.id) from Person p)")
    public Optional<Person> getLastRegister();

    //  where in

    @Query("select p from Person p where p.id in :ids")
    public List<Person> getPersonByIds(List<Long> ids);

    @Query("select p from Person p where p.id not in :ids")
    public List<Person> getPersonExcludesIds(List<Long> ids);
}
