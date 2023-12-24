# Notas

## RestController

La anotación `@RestController` se utiliza en Spring Boot para marcar una clase como un controlador REST.

La anotación `@RestController` combina las anotaciones `@Controller` y `@ResponseBody`. La anotación `@Controller` indica que la clase es un controlador HTTP, y la anotación `@ResponseBody` indica que los métodos de la clase devuelven objetos de dominio en lugar de vistas.

Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@RestController`:

```java
@RestController
public class UserController {

    @GetMapping("/users")
    public List<User> getUsers() {
        // Devuelve una lista de usuarios
    }
}
```

En este código, la clase `UserController` está marcada como un controlador REST. El método `getUsers()` devuelve una lista de usuarios.

La anotación `@RestController` tiene las siguientes ventajas:

* Simplifica la creación de controladores REST.
* Permite que los métodos de los controladores REST devuelvan objetos de dominio.
* Mejora el rendimiento de los controladores REST.

En general, la anotación `@RestController` es una herramienta útil para crear controladores REST.

### Diferencias entre Controller y RestController

Las principales diferencias entre usar la anotación `@Controller` y `@RestController` son las siguientes:

* **`@Controller`:** Indica que la clase es un controlador HTTP, pero no especifica cómo se deben devolver los resultados de los métodos.
* **`@RestController`:** Combina las anotaciones `@Controller` y `@ResponseBody`. Esto significa que los métodos de la clase `@RestController` siempre devuelven objetos de dominio en lugar de vistas.

> Nota un `@Controller` puede retornar un json si se agrega la anotacion `@ResponseBody`

En consecuencia, las siguientes son las diferencias específicas entre usar estas dos anotaciones:

* **Objetos devueltos:** Los métodos de una clase `@Controller` pueden devolver objetos de dominio, vistas o cualquier otro tipo de objeto. Los métodos de una clase `@RestController` **siempre** devuelven objetos de dominio.
* **Uso de `@ResponseBody`:** La anotación `@ResponseBody` no es necesaria en una clase `@RestController`. De hecho, es redundante, ya que la anotación `@RestController` ya la implica.
* **Uso de `ModelAndView`:** La anotación `@Controller` permite que los métodos devuelvan objetos `ModelAndView`. Los objetos `ModelAndView` se utilizan para asociar datos a una vista. Los métodos de una clase `@RestController` no pueden devolver objetos `ModelAndView`.

**Objetos de dominio**

Los objetos de dominio son objetos que representan entidades del mundo real. Por ejemplo, un objeto de dominio podría representar un usuario, un producto o una orden de compra.

En el contexto de Spring Boot, los objetos de dominio son objetos que se devuelven de los métodos de los controladores REST. Los objetos de dominio suelen ser serializables, ya que se envían a través de la red.

Los objetos de dominio pueden ser de cualquier tipo, pero suelen ser objetos JavaBeans. Los objetos JavaBeans son objetos que cumplen con las siguientes reglas:

* Tienen un constructor público sin argumentos.
* Tienen getters y setters para todas sus propiedades.

La siguiente es una clase de ejemplo de un objeto de dominio:

```java
public class User {

    private String name;
    private Integer age;
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

Esta clase representa un usuario. La clase tiene tres propiedades: `name`, `age` y `email`. La clase cumple con las reglas de los objetos JavaBeans.

En general, los objetos de dominio son una parte importante de los controladores REST. Los objetos de dominio permiten que los controladores REST sean más eficientes y fáciles de usar.

### JSON salida de RestController

Sí, una manera de representar un objeto de dominio es en JSON. JSON es un formato de datos ligero que se utiliza para intercambiar datos entre aplicaciones.

Para representar un objeto de dominio en JSON, se puede utilizar la clase `ObjectMapper` de la biblioteca Jackson. La clase `ObjectMapper` proporciona métodos para convertir objetos Java a JSON y viceversa.

La siguiente es una clase de ejemplo de un objeto de dominio:

```java
public class User {

    private String name;
    private Integer age;
    private String email;

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

La siguiente es una forma de convertir este objeto de dominio a JSON:

```java
ObjectMapper mapper = new ObjectMapper();

User user = new User();
user.setName("Juan");
user.setAge(25);
user.setEmail("juan@example.com");

String json = mapper.writeValueAsString(user);
```

El código anterior devolverá el siguiente JSON:

```json
{
    "name": "Juan",
    "age": 25,
    "email": "juan@example.com"
}
```

Para convertir JSON a un objeto de dominio, se puede utilizar el método `readValue()` de la clase `ObjectMapper`.

La siguiente es una forma de convertir el JSON anterior a un objeto de dominio:

```java
ObjectMapper mapper = new ObjectMapper();

User user = mapper.readValue(json, User.class);
```

El código anterior devolverá el siguiente objeto de dominio:

```java
User user = new User();
user.setName("Juan");
user.setAge(25);
user.setEmail("juan@example.com");
```

En general, JSON es una forma eficiente y fácil de representar objetos de dominio.

## Spring MVC

Spring MVC es un framework web de Java que implementa el patrón de diseño Modelo-Vista-Controlador (MVC). Spring MVC proporciona una infraestructura completa para el desarrollo de aplicaciones web, incluyendo:

* **Controladores:** Los controladores son responsables de procesar las solicitudes HTTP y devolver las respuestas.
* **Vistas:** Las vistas son responsables de generar la salida HTML.
* **Modelos:** Los modelos representan los datos que se utilizan en las solicitudes y respuestas.

Spring MVC utiliza un enfoque basado en anotaciones para la configuración. Esto hace que sea fácil y rápido desarrollar aplicaciones web con Spring MVC.

**Arquitectura de Spring MVC**

La arquitectura de Spring MVC se basa en el patrón de diseño MVC. El patrón MVC divide una aplicación web en tres componentes principales:

* **Modelo:** Representa los datos de la aplicación.
* **Vista:** Genera la salida HTML.
* **Controlador:** Procesa las solicitudes HTTP y envía las respuestas.

En Spring MVC, los modelos se implementan como clases Java. Las vistas se implementan como archivos HTML, JSP o Thymeleaf. Los controladores se implementan como clases Java que extienden la clase `Controller`.

**Controladores**

Los controladores son responsables de procesar las solicitudes HTTP y devolver las respuestas. Los controladores se implementan como clases Java que extienden la clase `Controller`.

Los controladores pueden procesar las solicitudes HTTP utilizando los siguientes métodos:

* `doGet()`: Se utiliza para procesar las solicitudes HTTP GET.
* `doPost()`: Se utiliza para procesar las solicitudes HTTP POST.
* `doPut()`: Se utiliza para procesar las solicitudes HTTP PUT.
* `doDelete()`: Se utiliza para procesar las solicitudes HTTP DELETE.

Los controladores también pueden utilizar los métodos `getModel()` y `setModel()` para acceder al modelo de la solicitud.

**Vistas**

Las vistas son responsables de generar la salida HTML. Las vistas se implementan como archivos HTML, JSP o Thymeleaf.

Para asociar una vista con un controlador, se puede utilizar la anotación `@RequestMapping`. La anotación `@RequestMapping` especifica el patrón de URL que se utilizará para asociar la vista con el controlador.

**Modelos**

Los modelos representan los datos de la aplicación. Los modelos se implementan como clases Java.

Para asociar un modelo con una vista, se puede utilizar el método `getModel()` del controlador.

**Características de Spring MVC**

Spring MVC ofrece una serie de características que facilitan el desarrollo de aplicaciones web, incluyendo:

* **Soporte para el patrón MVC:** Spring MVC proporciona una implementación completa del patrón MVC, lo que facilita la creación de aplicaciones web bien estructuradas.
* **Soporte para anotaciones:** Spring MVC utiliza un enfoque basado en anotaciones para la configuración, lo que hace que sea fácil y rápido desarrollar aplicaciones web.
* **Soporte para vistas:** Spring MVC admite una variedad de vistas, incluyendo archivos HTML, JSP y Thymeleaf.
* **Soporte para internacionalización:** Spring MVC admite la internacionalización, lo que facilita el desarrollo de aplicaciones web que se pueden utilizar en diferentes idiomas.
* **Soporte para seguridad:** Spring MVC admite la seguridad, lo que facilita el desarrollo de aplicaciones web seguras.

**Ventajas de Spring MVC**

Spring MVC ofrece una serie de ventajas, incluyendo:

* **Facilidad de uso:** Spring MVC es un framework fácil de usar, incluso para desarrolladores que no están familiarizados con el patrón MVC.
* **Eficiencia:** Spring MVC es un framework eficiente, lo que lo hace ideal para aplicaciones web de alto rendimiento.
* **Extensibilidad:** Spring MVC es un framework extensible, lo que permite a los desarrolladores adaptarlo a sus necesidades específicas.

**Desventajas de Spring MVC**

Spring MVC ofrece una serie de desventajas, incluyendo:

* **Tamaño:** Spring MVC es un framework relativamente grande, lo que puede dificultar su aprendizaje y uso.
* **Dependencias:** Spring MVC depende de una serie de bibliotecas externas, lo que puede aumentar la complejidad de la aplicación.

**Conclusión**

Spring MVC es un framework web de Java maduro y confiable que ofrece una serie de características que facilitan el desarrollo de aplicaciones web. Spring MVC es una buena opción para desarrolladores que buscan un framework web fácil de usar, eficiente y extensible.

## Spring

Spring es un framework de Java que proporciona una infraestructura completa para el desarrollo de aplicaciones empresariales. Spring proporciona una variedad de características que facilitan el desarrollo de aplicaciones empresariales, incluyendo:

* **Inyección de dependencias:** Spring utiliza la inyección de dependencias para conectar los componentes de una aplicación. Esto hace que sea más fácil de mantener y depurar las aplicaciones.
* **Administración de transacciones:** Spring proporciona un soporte integrado para la administración de transacciones. Esto hace que sea más fácil de desarrollar aplicaciones con transacciones seguras.
* **Acceso a datos:** Spring proporciona una variedad de herramientas para acceder a datos, incluyendo JDBC, Hibernate y JPA.
* **Web:** Spring proporciona un soporte completo para el desarrollo de aplicaciones web, incluyendo Spring MVC.

**Cómo funciona Spring**

Spring funciona mediante la creación de un contenedor de Spring. El contenedor de Spring es responsable de crear e inicializar los componentes de una aplicación. El contenedor de Spring utiliza la inyección de dependencias para conectar los componentes de una aplicación.

Cuando se inicia una aplicación Spring, el contenedor de Spring escanea el código fuente de la aplicación en busca de anotaciones de Spring. Las anotaciones de Spring indican al contenedor de Spring qué componentes deben crear e inicializar.

El contenedor de Spring también utiliza la inyección de dependencias para conectar los componentes de una aplicación. La inyección de dependencias es un patrón de diseño que permite a los componentes de una aplicación obtener los recursos que necesitan sin tener que crearlos explícitamente.

**Inyección de dependencias**

La inyección de dependencias es una característica clave de Spring. La inyección de dependencias permite a los desarrolladores crear aplicaciones más fáciles de mantener y depurar.

La inyección de dependencias funciona mediante la inyección de objetos en los campos, métodos o constructores de una clase. El contenedor de Spring es responsable de inyectar los objetos necesarios en los componentes de una aplicación.

**Administración de transacciones**

Spring proporciona un soporte integrado para la administración de transacciones. La administración de transacciones es una característica importante de las aplicaciones empresariales.

La administración de transacciones permite a las aplicaciones garantizar que las transacciones se completen de forma consistente. Spring proporciona una variedad de herramientas para la administración de transacciones, incluyendo el administrador de transacciones de Spring y el administrador de transacciones de JTA.

**Acceso a datos**

Spring proporciona una variedad de herramientas para acceder a datos. Las herramientas de acceso a datos de Spring facilitan el desarrollo de aplicaciones que acceden a datos.

Spring proporciona soporte para una variedad de tecnologías de acceso a datos, incluyendo JDBC, Hibernate y JPA.

**Web**

Spring proporciona un soporte completo para el desarrollo de aplicaciones web. Spring proporciona un framework web completo, Spring MVC.

Spring MVC es un framework web maduro y confiable que ofrece una variedad de características que facilitan el desarrollo de aplicaciones web.

**Ventajas de Spring**

Spring ofrece una serie de ventajas, incluyendo:

* **Facilidad de uso:** Spring es un framework fácil de usar, incluso para desarrolladores que no están familiarizados con la inyección de dependencias.
* **Eficiencia:** Spring es un framework eficiente, lo que lo hace ideal para aplicaciones empresariales de alto rendimiento.
* **Extensibilidad:** Spring es un framework extensible, lo que permite a los desarrolladores adaptarlo a sus necesidades específicas.

**Desventajas de Spring**

Spring ofrece una serie de desventajas, incluyendo:

* **Tamaño:** Spring es un framework relativamente grande, lo que puede dificultar su aprendizaje y uso.
* **Dependencias:** Spring depende de una serie de bibliotecas externas, lo que puede aumentar la complejidad de la aplicación.

**Conclusión**

Spring es un framework de Java maduro y confiable que ofrece una variedad de características que facilitan el desarrollo de aplicaciones empresariales. Spring es una buena opción para desarrolladores que buscan un framework de Java fácil de usar, eficiente y extensible.

## DTO

En programación, un DTO (Data Transfer Object) es un objeto que se utiliza para transferir datos entre diferentes componentes de una aplicación. Los DTO suelen ser objetos planos, sin comportamiento, que contienen solo los datos necesarios para la transferencia.

Los DTO se utilizan en una variedad de escenarios, incluyendo:

* **Transferencia de datos entre capas de una aplicación:** Los DTO se pueden utilizar para transferir datos entre capas de una aplicación, como la capa de presentación y la capa de datos.
* **Comunicación entre aplicaciones:** Los DTO se pueden utilizar para comunicar datos entre aplicaciones, como en el caso de servicios web.
* **Almacenamiento de datos en caché:** Los DTO se pueden utilizar para almacenar datos en caché, lo que puede mejorar el rendimiento de una aplicación.

Los DTO tienen las siguientes ventajas:

* **Reducen la complejidad de la aplicación:** Los DTO simplifican la transferencia de datos entre diferentes componentes de una aplicación.
* **Mejoran el rendimiento de la aplicación:** Los DTO pueden mejorar el rendimiento de una aplicación al reducir la cantidad de datos que se transfieren entre diferentes componentes.
* **Facilitan la prueba de la aplicación:** Los DTO facilitan la prueba de la aplicación al proporcionar una interfaz sencilla para la transferencia de datos.

Los DTO suelen tener las siguientes características:

* **Son objetos planos:** Los DTO no tienen comportamiento, solo contienen datos.
* **Contienen solo los datos necesarios:** Los DTO solo contienen los datos que son necesarios para la transferencia.
* **Son serializables:** Los DTO deben ser serializables para que se puedan transferir entre diferentes componentes de una aplicación.

La siguiente es una clase de ejemplo de un DTO:

```java
public class UserDTO {

    private String name;
    private Integer age;
    private String email;

    public UserDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
```

Esta clase representa un usuario. La clase tiene tres propiedades: `name`, `age` y `email`. La clase es un DTO porque es un objeto plano que contiene solo los datos necesarios para representar un usuario.

## Enviroment

En Spring Boot, el objeto `Environment` proporciona acceso a las propiedades de la aplicación. Estas propiedades pueden ser proporcionadas por el usuario, por el sistema operativo o por el entorno de ejecución de Spring Boot.

El objeto `Environment` se puede utilizar para obtener el valor de una propiedad específica, o para obtener una lista de todas las propiedades.

Para obtener el valor de una propiedad específica, se puede utilizar el método `getProperty()`. El método `getProperty()` toma como argumento el nombre de la propiedad como parámetro.

Por ejemplo, el siguiente código obtiene el valor de la propiedad `spring.application.name`:

```java
String applicationName = Environment.getRequiredProperty("spring.application.name");
```

Para obtener una lista de todas las propiedades, se puede utilizar el método `getProperties()`. El método `getProperties()` devuelve un objeto `Map` que contiene todas las propiedades.

Por ejemplo, el siguiente código imprime una lista de todas las propiedades:

```java
Map<String, Object> properties = Environment.getProperties();

for (Map.Entry<String, Object> entry : properties.entrySet()) {
    System.out.println("Property: " + entry.getKey() + ", Value: " + entry.getValue());
}
```

Las propiedades de la aplicación se pueden configurar de varias maneras, incluyendo:

* **Archivo de propiedades:** El archivo de propiedades es el método más común para configurar las propiedades de la aplicación. El archivo de propiedades es un archivo de texto plano que contiene pares de nombre-valor.
* **Variables de entorno:** Las variables de entorno se pueden utilizar para configurar las propiedades de la aplicación. Las variables de entorno son variables que se definen en el sistema operativo.
* **Argumentos de línea de comandos:** Los argumentos de línea de comandos se pueden utilizar para configurar las propiedades de la aplicación. Los argumentos de línea de comandos se especifican cuando se inicia la aplicación.

Spring Boot proporciona una variedad de herramientas para ayudar a los desarrolladores a configurar las propiedades de la aplicación. Estas herramientas incluyen:

* **Spring Boot CLI:** El Spring Boot CLI es una herramienta de línea de comandos que se puede utilizar para iniciar aplicaciones Spring Boot y configurar propiedades.
* **Spring Boot Maven Plugin:** El Spring Boot Maven Plugin es un complemento de Maven que se puede utilizar para configurar propiedades de la aplicación.
* **Spring Boot Gradle Plugin:** El Spring Boot Gradle Plugin es un complemento de Gradle que se puede utilizar para configurar propiedades de la aplicación.

En general, el objeto `Environment` es una herramienta útil para acceder a las propiedades de la aplicación en Spring Boot.

## Diferencias entre usar Forward o Redirect en vistas web

La diferencia radica en que forward se matiene dentro de la misma peticion http y no se pierde los parametros del request, tampoco cambia la ruta url. Mientras que el redirect si cambia la ruta url, reinicia el request y refresca
el navegador, tambien se pierden los parametros anteriores al redirect.

## Despliegue desde terminal

Entramos desde terminal al proyecto y se ejecuta este comando:

> Para generar el .jar que se ejecutara en local.

```cmd
./mvnw clean package
```

Despues se debe entrar a la ruta donde se guarda el jar generado la cual se llama `target` y se ejecuta con la siguiente sintaxis:

> el nombre se genera con el nombre del proyecto y la version utilizada.

```cmd
java -jar .\webapp-0.0.1-SNAPSHOT.jar
```
