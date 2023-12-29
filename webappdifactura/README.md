# Notas

## Anotacion PostConstruct

La anotación **@PostConstruct** es una anotación de Java que se utiliza para indicar que un método debe ser ejecutado después de que el bean haya sido creado y configurado. Este método se conoce como método de inicialización.

La anotación @PostConstruct se utiliza para realizar tareas de inicialización que no pueden o no deben realizarse en el constructor del bean. Por ejemplo, la anotación @PostConstruct se puede utilizar para:

* **Inicializar recursos externos:** La anotación @PostConstruct se puede utilizar para inicializar recursos externos, como conexiones a bases de datos o servicios web.
* **Cargar datos:** La anotación @PostConstruct se puede utilizar para cargar datos, como datos de configuración o datos de la base de datos.
* **Realizar validaciones:** La anotación @PostConstruct se puede utilizar para realizar validaciones, como validar la configuración del bean o validar los datos cargados.

La anotación @PostConstruct se ejecuta después de que el bean ha sido creado y configurado. Esto significa que el bean ya tiene todos sus valores de propiedad asignados y está listo para ser utilizado.

La anotación @PostConstruct se puede utilizar en cualquier método público o protegido de un bean. El método debe tener un parámetro de tipo `void` y no debe tener parámetros.

La siguiente es una clase de ejemplo que utiliza la anotación @PostConstruct:

```java
@Component
public class MyBean {

    private String name;

    public MyBean() {
        // ...
    }

    @PostConstruct
    public void init() {
        // Inicializa el nombre del bean
        this.name = "Bard";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
```

En esta clase, el método `init()` se ejecuta después de que el bean ha sido creado y configurado. El método `init()` inicializa el nombre del bean a "Bard".

En resumen, la anotación @PostConstruct es una herramienta útil para realizar tareas de inicialización después de que un bean ha sido creado y configurado.

## Anotacion PreDestroy

La anotación **@PreDestroy** es una anotación de Java que se utiliza para indicar que un método debe ser ejecutado antes de que el bean sea destruido. Este método se conoce como método de destrucción.

La anotación @PreDestroy se utiliza para realizar tareas de limpieza que deben realizarse antes de que el bean sea destruido. Por ejemplo, la anotación @PreDestroy se puede utilizar para:

* **Liberar recursos externos:** La anotación @PreDestroy se puede utilizar para liberar recursos externos, como conexiones a bases de datos o servicios web.
* **Guardar datos:** La anotación @PreDestroy se puede utilizar para guardar datos, como datos de configuración o datos de la base de datos.
* **Realizar validaciones:** La anotación @PreDestroy se puede utilizar para realizar validaciones, como validar la configuración del bean o validar los datos guardados.

La anotación @PreDestroy se ejecuta antes de que el bean sea destruido. Esto significa que el bean todavía tiene acceso a todos sus recursos y valores de propiedad.

La anotación @PreDestroy se puede utilizar en cualquier método público o protegido de un bean. El método debe tener un parámetro de tipo `void` y no debe tener parámetros.

La siguiente es una clase de ejemplo que utiliza la anotación @PreDestroy:

```java
@Component
public class MyBean {

    private String name;

    public MyBean() {
        // ...
    }

    @PostConstruct
    public void init() {
        // Inicializa el nombre del bean
        this.name = "Bard";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @PreDestroy
    public void destroy() {
        // Libera los recursos del bean
        System.out.println("Liberando recursos del bean");
    }
}
```

En esta clase, el método `destroy()` se ejecuta antes de que el bean sea destruido. El método `destroy()` libera los recursos del bean, como la conexión a la base de datos.

En resumen, la anotación @PreDestroy es una herramienta útil para realizar tareas de limpieza antes de que un bean sea destruido.

## Alcance (scope) de los componentes en Spring Boot

En Spring Boot, el alcance (scope) de un componente determina la vida útil de dicho componente. El alcance puede ser:

* **Singleton:** El componente se crea una sola vez y se mantiene en memoria durante toda la vida de la aplicación.
* **Request:** El componente se crea una sola vez para cada solicitud HTTP que se procesa.
* **Session:** El componente se crea una sola vez para cada sesión HTTP que se abre.
* **Prototype:** El componente se crea cada vez que se necesita.

El alcance predeterminado de un componente es **singleton**. Esto significa que se crea una sola instancia del componente y se mantiene en memoria durante toda la vida de la aplicación.

El alcance **request** es útil para componentes que se utilizan para procesar una solicitud HTTP específica. Por ejemplo, un componente que se utiliza para procesar un formulario web se puede configurar con alcance **request**.

El alcance **session** es útil para componentes que se utilizan para almacenar datos de sesión. Por ejemplo, un componente que se utiliza para almacenar información del usuario se puede configurar con alcance **session**.

El alcance **prototype** es útil para componentes que se utilizan solo una vez. Por ejemplo, un componente que se utiliza para generar un informe se puede configurar con alcance **prototype**.

El alcance de un componente se puede configurar utilizando las anotaciones `@Scope` o `@RequestScope`, `@SessionScope` o `@Prototype`.

La siguiente tabla muestra un resumen de los alcances de los componentes de Spring Boot:

| Alcance   | Descripción                                                                                               |
|-----------|-----------------------------------------------------------------------------------------------------------|
| Singleton | Se crea una sola instancia del componente y se mantiene en memoria durante toda la vida de la aplicación. |
| Request   | Se crea una sola instancia del componente para cada solicitud HTTP que se procesa.                        |
| Session   | Se crea una sola instancia del componente para cada sesión HTTP que se abre.                              |
| Prototype | Se crea una nueva instancia del componente cada vez que se necesita.                                      |

En general, el alcance de un componente debe seleccionarse en función de las necesidades específicas de la aplicación.

## Anotacion JsonIgnoreProperties

La anotación **@JsonIgnoreProperties** es una anotación de Java que se utiliza para indicar que ciertas propiedades de un objeto no deben ser serializadas o deserializadas.

La anotación @JsonIgnoreProperties se puede utilizar en las siguientes situaciones:

* **Para ocultar propiedades sensibles:** Las propiedades que contienen información sensible, como contraseñas o números de tarjetas de crédito, se pueden ocultar utilizando la anotación @JsonIgnoreProperties.
* **Para mejorar el rendimiento:** Las propiedades que no son necesarias para la serialización o deserialización se pueden ocultar para mejorar el rendimiento.
* **Para simplificar la serialización o deserialización:** Las propiedades que son complejas o difíciles de serializar o deserializar se pueden ocultar para simplificar el proceso.

La anotación @JsonIgnoreProperties acepta un parámetro opcional que especifica los nombres de las propiedades que deben ser ignoradas. Si el parámetro está ausente, todas las propiedades que no estén marcadas con la anotación @JsonProperty serán ignoradas.

La siguiente es una clase de ejemplo que utiliza la anotación @JsonIgnoreProperties:

```java
@JsonIgnoreProperties({"password", "creditCardNumber"})
public class User {

    private String name;
    private String email;
    private String password;
    private String creditCardNumber;

    public User() {
        // ...
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }
}
```

En esta clase, las propiedades `password` y `creditCardNumber` están marcadas con la anotación @JsonIgnoreProperties. Esto significa que estas propiedades no serán serializadas o deserializadas cuando se utilice la clase `User` con un convertidor JSON.

En general, la anotación @JsonIgnoreProperties es una herramienta útil para ocultar propiedades de un objeto que no deben ser serializadas o deserializadas.
