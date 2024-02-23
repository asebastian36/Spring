package com.angel.curso.springboot.springbootjpa;

import com.angel.curso.springboot.springbootjpa.dto.PersonDto;
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
        whereIn();
    }

    @Transactional(readOnly = true)
    public void whereIn() {
        List<Person> persons = repository.getPersonByIds(Arrays.asList(1L, 2L, 5L));
        persons.forEach(System.out::println);

        persons = repository.getPersonExcludesIds(Arrays.asList(1L, 2L, 5L));
        persons.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void subQueries() {
        List<Object[]> results = repository.getShorterName();
        results.forEach(element -> System.out.println("Name:" + element[0] + ", length:" + element[1]));
        
        Optional<Person> optional = repository.getLastRegister();

        if (optional.isPresent()) {
            Person person = optional.get();
            System.out.println("person = " + person);
        }
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesFunctionAggregation() {
        Long count = repository.getTotalPerson();
        System.out.println("count = " + count);
        
        Long min = repository.getMinId();
        System.out.println("min = " + min);
        
        Long max = repository.getMaxId();
        System.out.println("max = " + max);

        List<Object[]> names = repository.getPersonNameLength();
        names.forEach(arr -> System.out.println("Name:" + arr[0] + ", " + "Length:" + arr[1]));

        Long minLengthName = repository.getMinLengtName();
        System.out.println("minLengthName = " + minLengthName);

        Long maxLengthName = repository.getMaxLengtName();
        System.out.println("maxLengthName = " + maxLengthName);

        //  resumen de funciones de agregacion
        Object[] resume = (Object[]) repository.getResumeAggregationFunction();
        System.out.println("min:" + resume[0] + ", max:" + resume[1] + ", sum:" + resume[2] + ", avg:" + resume[3] + ", count:" + resume[4]);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesOrderBy() {
        List<Person> elements = repository.findBetweenByIdOrderByName(2L, 4L);
        elements.forEach(System.out::println);

        List<Person> persons = repository.findAllBetweenCharsOrderByName("A", "D");
        persons.forEach(System.out::println);

        //  automaticos
        List<Person> results = repository.findByIdBetweenOrderByNameAsc(3L, 5L);
        results.forEach(System.out::println);

        List<Person> objs = repository.findByNameBetweenOrderByLastnameDesc("A", "Z");
        objs.forEach(System.out::println);

        List<Person> list = repository.findAllByOrderByNameDesc();
        list.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesBetween() {
        List<Person> elements = repository.findBetweenById(2L, 4L);
        elements.forEach(System.out::println);

        List<Person> persons = repository.findAllBetweenChars("A", "C");
        persons.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesConcatUpperAndLower() {
        List<String> upper = repository.findAllFullNamesConcatUpper();
        upper.forEach(System.out::println);

        List<String> lower = repository.findAllFullNamesConcatLower();
        lower.forEach(System.out::println);

        List<String> data = repository.findAllPersonDataListCase();
        data.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesConcat() {
        List<String> fullNames = repository.findAllFullNamesConcat();
        fullNames.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueriesDistinc() {
        //  para obtener todos los nombres
        List<String> names = repository.findAllNames();
        names.forEach(System.out::println);

        //  para obtener todos los nombres sin que se repitan
        List<String> namesDistinc = repository.findAllNamesDistinc();
        namesDistinc.forEach(System.out::println);

        //  para obtener todos los lenguajes sin que se repitan
        List<String> languageDistinc = repository.findAllLanguageDistinc();
        languageDistinc.forEach(System.out::println);
        
        Long count = repository.findAllLanguageDistincCount();
        System.out.println("count = " + count);
    }

    @Transactional(readOnly = true)
    public void personalizedMixQueries() {
        List<Object[]> personsList = repository.findAllMix();
        personsList.forEach(element -> System.out.println("ProgrammingLanguage = " + element[1] + " Person: " + element[0]));

        //  metodos para regresar informacion especifica (name, lastname) de la entidad
        List<Person> persons = repository.findAllClassPerson();
        persons.forEach(System.out::println);

        List<PersonDto> dtos = repository.findAllDtoPerson();
        dtos.forEach(System.out::println);
    }

    @Transactional(readOnly = true)
    public void personalizedQueries() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id a buscar: ");
        Long id = sc.nextLong();

        //  obtener el nombre de un registro
        String result = repository.getNameById(id);
        System.out.println("result = " + result);

        //  obtener el nombre concatenado
        String fullName = repository.getFullNameById(id);
        System.out.println("fullName = " + fullName);

        //  obtener los campos de un registro
        Optional<Object> optional = repository.getFullById(id);

        if (optional.isPresent()) {
            Object[] array = (Object[]) optional.get();
            System.out.println("Registro " + array[0] + ": " +  array[1] + " " + array[2] + " " + array[3]);
        } else {
            System.out.println("Objeto no encontrado");
        }

        //  obtener los campos de los registros
        List<Object[]> arrayList = repository.getFullDataList();
        arrayList.forEach(arr -> System.out.println("Registro " + arr[0] + ": " +  arr[1] + " " + arr[2] + " " + arr[3]));
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
        /*
          opcion 1
                Person person = null;
                Optional<Person> optional = repository.findById(1L);

                if (optional.isPresent()) person = optional.get();

                System.out.println(person);
          opcion 2
        */

        repository.findOneNameLike("gel").ifPresent(System.out::println);
    }

    @Transactional(readOnly = true)
    public void list() {
        /*
          List<Person> persons = (List<Person>) repository.findByIdAndName(1, "Angel");
          persons.forEach(System.out::println);
        */

        List<Object[]> personsValues = repository.obtenerPersonValues(1);
        personsValues.forEach(person -> {
            System.out.println(person[0] + " " + person[1] + " es un menso en todo menos en, " + person[2]);
        });
    }
}
