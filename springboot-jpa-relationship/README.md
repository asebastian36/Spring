# Asociaciones en JPA

Las asociaciones en JPA se utilizan para definir relaciones entre entidades. Estas relaciones pueden ser de uno a uno, uno a muchos, muchos a uno o muchos a muchos.

**Tipos de asociaciones:**

* **Uno a uno:** Una entidad de un tipo está asociada con una sola entidad de otro tipo.
* **Uno a muchos:** Una entidad de un tipo está asociada con múltiples entidades de otro tipo.
* **Muchos a uno:** Múltiples entidades de un tipo están asociadas con una sola entidad de otro tipo.
* **Muchos a muchos:** Múltiples entidades de un tipo están asociadas con múltiples entidades de otro tipo.

**Anotaciones para definir asociaciones:**

* **`@OneToOne`:** Se utiliza para definir una asociación uno a uno.
* **`@OneToMany`:** Se utiliza para definir una asociación uno a muchos.
* **`@ManyToOne`:** Se utiliza para definir una asociación muchos a uno.
* **`@ManyToMany`:** Se utiliza para definir una asociación muchos a muchos.

**Opciones de configuración:**

Las anotaciones para definir asociaciones también permiten configurar diversas opciones, como:

* **`mappedBy`:** Se utiliza para especificar el atributo en la otra entidad que define la relación.
* **`cascade`:** Se utiliza para especificar si las operaciones de persistencia, eliminación o actualización se deben propagar a las entidades relacionadas.
* **`fetch`:** Se utiliza para especificar si la asociación se debe cargar de forma eager o lazy.

**En resumen, las asociaciones en JPA son una herramienta fundamental para definir relaciones entre entidades. Las anotaciones para definir asociaciones son fáciles de usar y permiten configurar diversas opciones.**

**Recuerda:**

* Es importante elegir el tipo de asociación adecuado para cada caso.
* Es importante configurar las opciones de las asociaciones de acuerdo a las necesidades de tu aplicación.

## @JoinColumn en Java (JPA)

**¿Qué es?**

La anotación `@JoinColumn` se utiliza en Java para especificar la columna de unión en una relación uno a uno, uno a muchos o muchos a uno entre entidades JPA.

**¿Para qué se usa?**

* **Especificar la columna de unión:** Permite indicar qué columna de la tabla de la entidad principal se utiliza para unir con la tabla de la entidad relacionada.
* **Personalizar la relación:** Define detalles como el nombre de la columna de unión, si es nullable o no, y si se debe generar o no un índice.

**En resumen, la anotación `@JoinColumn` es una herramienta fundamental para definir relaciones entre entidades JPA. Permite especificar la columna de unión y personalizar diversos aspectos de la relación.**

## Relaciones Unidireccionales vs Bidireccionales en JPA

Las relaciones entre entidades en JPA pueden ser unidireccionales o bidireccionales. La elección entre una u otra depende de cómo se desea navegar por la relación y de la necesidad de acceder a la entidad relacionada desde la entidad principal.

**Relaciones Unidireccionales:**

En una relación unidireccional, la navegación solo es posible en una dirección. Es decir, solo se puede acceder a la entidad relacionada desde la entidad principal, pero no viceversa.

**Ejemplo:**

```java
@Entity
public class Persona {

    @Id
    private Long id;

    private String nombre;

    @OneToOne
    private Direccion direccion;

}

@Entity
public class Direccion {

    @Id
    private Long id;

    private String calle;
    private String numero;
    private String ciudad;

}
```

En este ejemplo, la persona puede tener una dirección, pero la dirección no tiene ninguna referencia a la persona. Para obtener la dirección de una persona, se puede usar el atributo `direccion` de la clase `Persona`. Sin embargo, no se puede obtener la persona a partir de la dirección.

**Ventajas:**

* **Simplicidad:** Son más fáciles de entender y de implementar.
* **Menos código:** No se requiere código adicional para definir la relación en la entidad relacionada.
* **Menor memoria:** Se requiere menos memoria para almacenar las relaciones.

**Desventajas:**

* **Navegación limitada:** Solo se puede navegar por la relación en una dirección.
* **Acceso indirecto:** Se requiere acceder a la entidad relacionada a través de la entidad principal.

**Relaciones Bidireccionales:**

En una relación bidireccional, la navegación es posible en ambas direcciones. Se puede acceder a la entidad relacionada desde la entidad principal y viceversa.

**Ejemplo:**

```java
@Entity
public class Persona {

    @Id
    private Long id;

    private String nombre;

    @OneToOne(mappedBy = "persona")
    private Direccion direccion;

}

@Entity
public class Direccion {

    @Id
    private Long id;

    private String calle;
    private String numero;
    private String ciudad;

    @ManyToOne
    private Persona persona;

}
```

En este ejemplo, la persona puede tener una dirección y la dirección tiene una referencia a la persona. Se puede obtener la dirección de una persona usando el atributo `direccion` de la clase `Persona`, y también se puede obtener la persona a partir de la dirección usando el atributo `persona` de la clase `Direccion`.

**Ventajas:**

* **Navegación completa:** Se puede navegar por la relación en ambas direcciones.
* **Acceso directo:** Se puede acceder a la entidad relacionada directamente desde la entidad principal y viceversa.

**Desventajas:**

* **Complejidad:** Son más complejas de entender e implementar.
* **Más código:** Se requiere código adicional para definir la relación en ambas entidades.
* **Mayor memoria:** Se requiere más memoria para almacenar las relaciones.

**En resumen, la elección entre una relación unidireccional o bidireccional depende de las necesidades de la aplicación. Si solo se necesita acceder a la entidad relacionada desde la entidad principal, una relación unidireccional es suficiente. Si se necesita acceder a la entidad relacionada en ambas direcciones, se debe usar una relación bidireccional.**

## Fetch en JPA

**¿Qué es?**

`Fetch` en JPA es una estrategia de carga que define cómo se cargan las entidades relacionadas con una entidad principal. Existen dos tipos principales de fetch:

* **Eager (carga ansiosa):** Las entidades relacionadas se cargan automáticamente junto con la entidad principal.
* **Lazy (carga diferida):** Las entidades relacionadas se cargan solo cuando se necesitan, es decir, cuando se accede a un atributo de la entidad relacionada por primera vez.

**¿Para qué se usa?**

* **Optimizar el rendimiento:** `Lazy` puede mejorar el rendimiento al evitar la carga innecesaria de entidades que no se necesitan.
* **Controlar la carga de datos:** Permite controlar qué datos se cargan en memoria y cuándo.

**Ejemplo:**

```java
@Entity
public class Persona {

    @Id
    private Long id;

    private String nombre;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Telefono> telefonos;

}

@Entity
public class Telefono {

    @Id
    private Long id;

    private String numero;

}
```

En este ejemplo, la persona puede tener varios teléfonos. La anotación `@OneToMany(fetch = FetchType.LAZY)` indica que los teléfonos se cargarán de forma diferida, solo cuando se acceda a la lista `telefonos` de la persona por primera vez.

**Opciones de configuración:**

* `EAGER`: Carga las entidades relacionadas automáticamente.
* `LAZY`: Carga las entidades relacionadas solo cuando se necesitan.

**En resumen, `fetch` en JPA es una herramienta importante para optimizar el rendimiento y controlar la carga de datos en las aplicaciones JPA.**


## Notas

Las entidades que se manejan son ``Client``, ``Invoice`` y ``Address``, siendo entity la unica entidad con 2 relaciones.

La relacion entre ``Client`` e ``Invoice`` es bidireccional, tiene una ``@OneToMany`` por parte de ``Invoice`` y en ``Client`` una ``@ManyToOne``

La relacion entre ``Client`` y ``Address`` es unidireccional siendo ``@OneToMany`` le pertenece a ``Client``.

### Relacion de Cliente y Direccion

Para crear una tabla intermedia automatica desacoplada de ambas entidades, solo relacionandolas por su id.

```java
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
private List<Address> addresses;
```

Para incluir solo llave foranea sin crear otra tabla.

```java
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinColumn(name = "client_id")
private List<Address> addresses;
```

Tabla intermedia personalizada o para implementar una ya existente.

```java
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
@JoinTable(
        name = "table_clients_addresses",
        joinColumns = @JoinColumn(name = "id_client"),
        inverseJoinColumns =  @JoinColumn(name = "id_address"),
        uniqueConstraints = @UniqueConstraint(columnNames = {"id_address"})
)
private List<Address> addresses;
```

### Soluciones para la lazy load

Propiedad fetch en la relacion

```java
@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, mappedBy = "client")
    private List<Invoice> invoices;
```

Consultas personalizadas

```java
@Query("select c from Client c left join fetch c.addresses where c.id = :id")
Optional<Client> findOneWithAdresses(Long id);
```

Propiedad del .properties

```properties

```