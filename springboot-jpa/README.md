# Notas

## Hibernate

Es una herramienta de mapeo de objeto relacional (ORM) que permite trabajar los datos de una base de datos (RBDMS) en forma de clases y objetos (lenguaje POO).

## Tipos de consultas

* **Hibernate Query Language (HQL)**
* **Criteria API**
* **SQL Nativo**

## Asociaciones o relaciones

* `@ManyToOne`
* `@OneToMany`
* `@OneToOne`
* `@ManyToMany`

## Ciclo de vida

Tenemos acceso a multiples metodos para manipular una entidad en cada una de sus fases de vida.

* **PrePersist**
* **PreUpdate**
* **PostConstruct**
* **PreRemove**
* **PostRemove**
* **PostLoad**
* **PostPersist**

## Anotaciones @Embedded y @Embeddable

Las anotaciones `@Embedded` y `@Embeddable` se utilizan en Java para mapear objetos complejos dentro de una entidad JPA. Estas anotaciones permiten a los desarrolladores crear relaciones de composición entre entidades, donde una entidad puede contener otras entidades como atributos.

**@Embeddable:**

Esta anotación se utiliza para marcar una clase como **embebida**. Una clase embebible es una clase que puede ser incrustada dentro de otra clase como un atributo. La clase embebible debe tener un constructor sin argumentos y todos sus atributos deben ser también serializables.

**@Embedded:**

Esta anotación se utiliza para marcar un atributo de una clase como **embebido**. El atributo embebido debe ser de una clase que esté anotada con `@Embeddable`.

**Ejemplo:**

```java
@Entity
public class Persona {

    @Id
    private Long id;

    private String nombre;

    @Embedded
    private Direccion direccion;

}

@Embeddable
public class Direccion {

    private String calle;
    private String numero;
    private String ciudad;
    private String codigoPostal;

}
```

En este ejemplo, la clase `Persona` tiene un atributo `direccion` que es de la clase `Direccion`. La clase `Direccion` está anotada con `@Embeddable`, lo que indica que puede ser incrustada dentro de otra clase. La clase `Persona` también tiene la anotación `@Entity`, lo que indica que es una entidad JPA.

**Ventajas de usar @Embedded y @Embeddable:**

* **Mejora la legibilidad del código:** Permite agrupar atributos relacionados en una sola clase.
* **Simplifica la gestión de relaciones:** Permite crear relaciones de composición entre entidades de forma sencilla.
* **Reduce la redundancia de datos:** Evita la necesidad de duplicar información en diferentes entidades.

**Desventajas de usar @Embedded y @Embeddable:**

* **Puede aumentar la complejidad de las consultas:** Las consultas que involucran entidades con atributos embebidos pueden ser más complejas.
* **Puede afectar el rendimiento:** El acceso a atributos embebidos puede ser menos eficiente que el acceso a atributos simples.

**En resumen, las anotaciones @Embedded y @Embeddable son una herramienta útil para mapear objetos complejos dentro de una entidad JPA. Estas anotaciones pueden mejorar la legibilidad del código, simplificar la gestión de relaciones y reducir la redundancia de datos.**

**Recuerda:**

* La clase embebible debe tener un constructor sin argumentos y todos sus atributos deben ser también serializables.
* Es importante tener en cuenta las ventajas y desventajas de usar estas anotaciones antes de utilizarlas en tu proyecto.
