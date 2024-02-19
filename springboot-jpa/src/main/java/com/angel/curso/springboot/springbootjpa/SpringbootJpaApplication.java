package com.angel.curso.springboot.springbootjpa;

import com.angel.curso.springboot.springbootjpa.entities.Person;
import com.angel.curso.springboot.springbootjpa.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import java.util.*;

@SpringBootApplication
public class SpringbootJpaApplication implements CommandLineRunner {

    @Autowired
    private PersonRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootJpaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        personalizedQueries(1L);
    }

    @Transactional(readOnly = true)
    public void personalizedQueries(Long id) {
        String result = repository.getNameById(id);
        System.out.println("result = " + result);
        
        String fullName = repository.getFullNameById(id);
        System.out.println("fullName = " + fullName);
        
        Object[] array = repository.getFullById(id);
        System.out.println(array[0].toString());
    }

    @Transactional
    public void delete() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del registro a eliminar: ");
        Long id = sc.nextLong();

        Optional<Person> person = repository.findById(id);

        person.ifPresentOrElse(repository::delete, () -> System.out.println("Registro no encontrado"));
    }

    @Transactional
    public void  update() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el id del registro a actualizar: ");
        Long id = sc.nextLong();

        Optional<Person> person = repository.findById(id);

        person.ifPresent(p -> {
            System.out.println("Registro encontrado: " + p);

            System.out.println("Ingrese el lenguaje de programacion: ");
            String lenguaje = sc.next();

            System.out.println("Ingrese el nombre: ");
            String nombre = sc.next();

            System.out.println("Ingrese el apellido: ");
            String apellido = sc.next();

            p.setName(nombre);
            p.setLastname(apellido);
            p.setProgrammingLanguage(lenguaje);

            repository.save(p);

            System.out.println("Registro actualizado: " + p);
        });
    }

    @Transactional
    public void terminal() {
        Scanner sc = new Scanner(System.in);
        String name = sc.next();
        String lastname = sc.next();
        String programmingLanguage = sc.next();

        Person person = new Person(name, lastname, programmingLanguage);
        repository.save(person);

        System.out.println("Fin");
    }

    //  transacciones de solo lectura o que no modifiquen la BD
    @Transactional(readOnly = true)
    public void create() {
        Person person = new Person("Sebas", "Tian", "IA");
        repository.save(person);
    }

    @Transactional(readOnly = true)
    public void findOne() {
        //  opcion 1
//        Person person = null;
//        Optional<Person> optional = repository.findById(1L);
//
//        if (optional.isPresent()) person = optional.get();
//
//        System.out.println(person);

        //  opcion 2
        repository.findOneNameLike("gel").ifPresent(System.out::println);
    }

    @Transactional(readOnly = true)
    public void list() {
        //  List<Person> persons = (List<Person>) repository.findByIdAndName(1, "Angel");
        //  persons.forEach(System.out::println);

        List<Object[]> personsValues = repository.obtenerPersonValues(1);
        personsValues.forEach(person -> {
            System.out.println(person[0] + " " + person[1] + " es un menso en todo menos en, " + person[2]);
        });
    }
}
