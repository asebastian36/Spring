# Notas

## Inyección de dependencias

El patrón de diseño de inyección de dependencias es un patrón de diseño de software que permite desacoplar las dependencias entre clases. En la inyección de dependencias, una clase no crea sus propias dependencias, sino que recibe las dependencias de otra clase.

La inyección de dependencias tiene varios beneficios, entre los que se incluyen:

* **Mejora la mantenibilidad:** La inyección de dependencias facilita la modificación de las dependencias de una clase. Si cambia la implementación de una dependencia, no es necesario modificar la clase que la utiliza.
* **Mejora la testabilidad:** La inyección de dependencias facilita la creación de pruebas unitarias para las clases. Las pruebas unitarias pueden proporcionar dependencias simuladas a las clases que se están probando.
* **Mejora la flexibilidad:** La inyección de dependencias permite a las clases utilizar diferentes implementaciones de las mismas dependencias.

Existen varios tipos de inyección de dependencias, entre los que se incluyen:

* **Inyección de constructor:** La inyección de constructor es el tipo de inyección de dependencias más común. En la inyección de constructor, la clase que necesita la dependencia la recibe como parámetro del constructor.
* **Inyección de setter:** La inyección de setter es similar a la inyección de constructor, pero la dependencia se recibe como parámetro de un método setter.
* **Inyección de campo:** La inyección de campo es una forma de inyección de dependencias que permite inyectar una dependencia en un campo de una clase.

En Spring Boot, la inyección de dependencias se realiza utilizando anotaciones. Las anotaciones más utilizadas para la inyección de dependencias en Spring Boot son:

* **@Autowired:** La anotación @Autowired se utiliza para inyectar una dependencia en un constructor, un método setter o un campo.
* **@Qualifier:** La anotación @Qualifier se utiliza para especificar la implementación específica de una dependencia que se debe inyectar.
* **@Resource:** La anotación @Resource es similar a @Autowired, pero se utiliza menos en Spring Boot.

Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Autowired para inyectar una dependencia en un constructor:

```java
@Component
public class MyClass {

    @Autowired
    private MyDependency dependency;

    public MyClass() {
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La dependencia se inyecta en el constructor de `MyClass` utilizando la anotación @Autowired.

En general, la inyección de dependencias es una técnica de diseño de software útil que puede ayudar a mejorar la mantenibilidad, la testabilidad y la flexibilidad de las aplicaciones.

### Anotacion Component

La anotación @Component es una anotación de Spring Boot que se utiliza para indicar que una clase es un componente de Spring. Un componente de Spring es una clase que puede ser administrada por Spring, lo que significa que puede ser inyectada con dependencias, registrada en el contenedor de Spring y administrada por Spring.

La anotación @Component es una anotación estereotipo, lo que significa que es una anotación que se utiliza para proporcionar metadatos sobre una clase. En el caso de la anotación @Component, el metadato que proporciona es que la clase es un componente de Spring.

Para utilizar la anotación @Component, simplemente agrega la anotación a la clase que deseas que sea un componente de Spring. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Component:

```java
@Component
public class MyClass {

    public MyClass() {
    }

    public void doSomething() {
    }
}
```

En este ejemplo, la clase `MyClass` es un componente de Spring porque tiene la anotación @Component.

La anotación @Component es una anotación general que puede utilizarse para indicar que una clase es un componente de Spring. Sin embargo, existen otras anotaciones más específicas que pueden utilizarse para indicar que una clase es un componente de Spring de un tipo específico. Por ejemplo, la anotación @Controller se utiliza para indicar que una clase es un controlador de Spring MVC, mientras que la anotación @Service se utiliza para indicar que una clase es un servicio de Spring.

En general, la anotación @Component es una anotación útil que puede utilizarse para indicar que una clase es un componente de Spring.

### Anotacion Service

La anotación @Service es una anotación de Spring Boot que se utiliza para indicar que una clase es un servicio de Spring. Un servicio de Spring es una clase que proporciona una funcionalidad específica para la aplicación.

La anotación @Service es una anotación estereotipo, lo que significa que es una anotación que se utiliza para proporcionar metadatos sobre una clase. En el caso de la anotación @Service, el metadato que proporciona es que la clase es un servicio de Spring.

Para utilizar la anotación @Service, simplemente agrega la anotación a la clase que deseas que sea un servicio de Spring. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Service:

```java
@Service
public class MyService {

    public MyService() {
    }

    public void doSomething() {
        // ...
    }
}
```

En este ejemplo, la clase `MyService` es un servicio de Spring porque tiene la anotación @Service.

La anotación @Service es una anotación que se utiliza comúnmente en aplicaciones de Spring Boot. Los servicios de Spring se utilizan para proporcionar una funcionalidad específica para la aplicación, como la lógica de negocio, el acceso a datos o la comunicación con otros sistemas.

Aquí hay algunos ejemplos de cómo se pueden utilizar los servicios de Spring:

* Un servicio de Spring puede proporcionar lógica de negocio para una aplicación. Por ejemplo, un servicio de Spring puede proporcionar lógica para calcular el precio de un producto o para registrar un nuevo usuario.
* Un servicio de Spring puede proporcionar acceso a datos. Por ejemplo, un servicio de Spring puede proporcionar acceso a una base de datos o a un servicio de almacenamiento en la nube.
* Un servicio de Spring puede proporcionar comunicación con otros sistemas. Por ejemplo, un servicio de Spring puede proporcionar comunicación con un servicio web o con un sistema de mensajería.

En general, la anotación @Service es una anotación útil que se puede utilizar para indicar que una clase es un servicio de Spring.

### Anotacion Autowired

La anotación @Autowired es una anotación de Spring Boot que se utiliza para indicar que una propiedad, un método setter o un constructor debe ser inyectado con una dependencia.

La anotación @Autowired es una anotación de inyección de dependencias, lo que significa que se utiliza para inyectar una dependencia en una clase. Las dependencias son objetos que son utilizados por una clase para realizar su trabajo.

Para utilizar la anotación @Autowired, simplemente agrega la anotación a la propiedad, el método setter o el constructor que deseas que sea inyectado con una dependencia. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Autowired para inyectar una dependencia en un constructor:

```java
@Component
public class MyClass {

    @Autowired
    private MyDependency dependency;

    public MyClass() {
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La dependencia se inyecta en el constructor de `MyClass` utilizando la anotación @Autowired.

La anotación @Autowired puede utilizarse para inyectar cualquier tipo de dependencia, incluyendo clases, interfaces y tipos primitivos.

La anotación @Autowired también puede utilizarse para especificar la implementación específica de una dependencia que se debe inyectar. Para ello, se puede utilizar el atributo qualifier de la anotación @Autowired. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Autowired para especificar la implementación específica de una dependencia que se debe inyectar:

```java
@Component
public class MyClass {

    @Autowired
    @Qualifier("my-dependency-implementation")
    private MyDependency dependency;

    public MyClass() {
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La implementación específica de la dependencia que se debe inyectar se especifica utilizando el atributo qualifier de la anotación @Autowired.

En general, la anotación @Autowired es una anotación útil que se puede utilizar para inyectar dependencias en las clases.

### Uso de interfaces o clases abstractas para inyección de dependencias

Se suele usar una interfaz o clase abstracta para el uso de inyección de dependencias en lugar de usar clases por los siguientes motivos:

* **Desacoplamiento:** Utilizar una interfaz o clase abstracta permite desacoplar la clase que necesita la dependencia de la implementación específica de la dependencia. Esto facilita la modificación de la implementación de la dependencia sin tener que modificar la clase que la utiliza.
* **Flexibilidad:** Utilizar una interfaz o clase abstracta permite utilizar diferentes implementaciones de la dependencia. Esto facilita la experimentación con diferentes implementaciones de la dependencia o la sustitución de una implementación por otra.
* **Testabilidad:** Utilizar una interfaz o clase abstracta facilita la creación de pruebas unitarias para la clase que necesita la dependencia. Las pruebas unitarias pueden proporcionar dependencias simuladas a la clase que se está probando.

Por ejemplo, si tenemos una clase `MyClass` que necesita una dependencia de una base de datos, podemos utilizar la siguiente interfaz para la dependencia:

```java
public interface Database {

    void connect();

    void disconnect();

    void query(String query);
}
```

La clase `MyClass` puede utilizar la anotación @Autowired para inyectar una implementación de la interfaz `Database`. Por ejemplo:

```java
@Component
public class MyClass {

    @Autowired
    private Database database;

    public void doSomething() {
        database.connect();
        database.query("SELECT * FROM users");
        database.disconnect();
    }
}
```

En este ejemplo, la clase `MyClass` no necesita saber qué implementación específica de la interfaz `Database` se está inyectando. Esto se debe a que la clase `MyClass` solo utiliza los métodos de la interfaz `Database`.

Podemos utilizar diferentes implementaciones de la interfaz `Database` en la aplicación. Por ejemplo, podemos utilizar una implementación que se conecta a una base de datos MySQL o una implementación que se conecta a una base de datos PostgreSQL.

También podemos utilizar la interfaz `Database` para crear pruebas unitarias para la clase `MyClass`. Por ejemplo, podemos crear una implementación simulada de la interfaz `Database` que proporcione datos ficticios.

### Inyección de dependencias via constructor, getter y setter

La inyección de dependencias es un patrón de diseño de software que permite desacoplar las dependencias entre clases. En la inyección de dependencias, una clase no crea sus propias dependencias, sino que recibe las dependencias de otra clase.

En Spring Boot, la inyección de dependencias se realiza utilizando anotaciones. Las anotaciones más utilizadas para la inyección de dependencias en Spring Boot son:

* **@Autowired:** La anotación @Autowired se utiliza para inyectar una dependencia en un constructor, un método setter o un campo.
* **@Qualifier:** La anotación @Qualifier se utiliza para especificar la implementación específica de una dependencia que se debe inyectar.
* **@Resource:** La anotación @Resource es similar a @Autowired, pero se utiliza menos en Spring Boot.

La inyección de dependencias se puede realizar de tres maneras diferentes:

* **Inyección de constructor:** La inyección de constructor es el tipo de inyección de dependencias más común. En la inyección de constructor, la clase que necesita la dependencia la recibe como parámetro del constructor.
* **Inyección de setter:** La inyección de setter es similar a la inyección de constructor, pero la dependencia se recibe como parámetro de un método setter.
* **Inyección de campo:** La inyección de campo es una forma de inyección de dependencias que permite inyectar una dependencia en un campo de una clase.

**Inyección de constructor**

La inyección de constructor es la forma más recomendada de realizar la inyección de dependencias. Esto se debe a que la inyección de constructor garantiza que la dependencia esté disponible cuando la clase se inicializa.

Para realizar la inyección de constructor, simplemente agrega la anotación @Autowired al constructor de la clase que necesita la dependencia. Por ejemplo, el siguiente código muestra cómo realizar la inyección de constructor para una clase que necesita una dependencia de la clase `MyDependency`:

```java
@Component
public class MyClass {
    
    private MyDependency dependency;
    
    @Autowired
    public MyClass(MyDependency dependency) {
        this.dependency = dependency;
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La dependencia se inyecta en el constructor de `MyClass` utilizando la anotación @Autowired.

**Inyección de setter**

La inyección de setter es una forma alternativa de realizar la inyección de dependencias. La inyección de setter es menos recomendada que la inyección de constructor, ya que no garantiza que la dependencia esté disponible cuando la clase se inicializa.

Para realizar la inyección de setter, simplemente agrega la anotación @Autowired al método setter de la clase que necesita la dependencia. Por ejemplo, el siguiente código muestra cómo realizar la inyección de setter para una clase que necesita una dependencia de la clase `MyDependency`:

```java
@Component
public class MyClass {

    private MyDependency dependency;

    @Autowired
    public void setDependency(MyDependency dependency) {
        this.dependency = dependency;
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La dependencia se inyecta en el método setter `setDependency()` de `MyClass` utilizando la anotación @Autowired.

**Inyección de campo**

La inyección de campo es una forma menos recomendada de realizar la inyección de dependencias. La inyección de campo se desaconseja porque puede provocar problemas de seguridad y de testabilidad.

Para realizar la inyección de campo, simplemente agrega la anotación @Autowired al campo de la clase que necesita la dependencia. Por ejemplo, el siguiente código muestra cómo realizar la inyección de campo para una clase que necesita una dependencia de la clase `MyDependency`:

```java
@Component
public class MyClass {

    @Autowired
    private MyDependency dependency;

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La dependencia se inyecta en el campo `dependency` de `MyClass` utilizando la anotación @Autowired.

En general, se recomienda utilizar la inyección de constructor para realizar la inyección de dependencias. La inyección de constructor garantiza que la dependencia esté disponible cuando la clase se inicializa y es la forma más segura y testable de realizar la inyección de dependencias.

### Anotacion Qualifier

La anotación @Qualifier se utiliza en Spring Boot para especificar la implementación específica de una dependencia que se debe inyectar.

La anotación @Qualifier se utiliza en combinación con la anotación @Autowired. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Qualifier para especificar la implementación específica de una dependencia que se debe inyectar:

```java
@Component
public class MyClass {

    @Autowired
    @Qualifier("my-dependency-implementation")
    private MyDependency dependency;

    public MyClass() {
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La implementación específica de la dependencia que se debe inyectar se especifica utilizando el atributo qualifier de la anotación @Autowired.

El valor del atributo qualifier es un identificador que se utiliza para identificar la implementación específica de la dependencia. El identificador puede ser cualquier cadena de caracteres, pero se recomienda utilizar un nombre descriptivo que identifique la implementación específica de la dependencia.

Spring Boot utiliza el atributo qualifier para determinar qué implementación específica de una dependencia se debe inyectar. Si se especifica un atributo qualifier para una dependencia, Spring Boot buscará una implementación de la dependencia que tenga el mismo atributo qualifier. Si no se encuentra ninguna implementación de la dependencia con el mismo atributo qualifier, Spring Boot lanzará una excepción.

La anotación @Qualifier se puede utilizar para especificar la implementación específica de una dependencia en cualquier lugar donde se utilice la anotación @Autowired. Por ejemplo, se puede utilizar la anotación @Qualifier para especificar la implementación específica de una dependencia en un constructor, un método setter o un campo.

En general, la anotación @Qualifier es una anotación útil que se puede utilizar para especificar la implementación específica de una dependencia que se debe inyectar.

### Anotacion Primary

La anotación @Primary se utiliza en Spring Boot para indicar que una implementación de una dependencia es la implementación primaria. La implementación primaria es la implementación que se utilizará por defecto si no se especifica ninguna implementación específica.

La anotación @Primary se utiliza en combinación con la anotación @Autowired. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Primary para indicar que una implementación de una dependencia es la implementación primaria:

```java
@Component
public class MyClass {

    @Autowired
    private MyDependency dependency;

    public MyClass() {
    }

    public void doSomething() {
        dependency.doSomething();
    }
}
```

En este ejemplo, la clase `MyClass` necesita una dependencia de la clase `MyDependency`. La implementación primaria de la dependencia es la implementación que se utilizará por defecto si no se especifica ninguna implementación específica.

Spring Boot utiliza la anotación @Primary para determinar qué implementación específica de una dependencia se debe inyectar. Si se especifica una anotación @Primary para una dependencia, Spring Boot utilizará la implementación de la dependencia que tenga la anotación @Primary. Si no se especifica ninguna anotación @Primary para una dependencia, Spring Boot buscará una implementación de la dependencia que no tenga ninguna anotación @Qualifier.

La anotación @Primary se puede utilizar para indicar que una implementación de una dependencia es la implementación primaria en cualquier lugar donde se utilice la anotación @Autowired. Por ejemplo, se puede utilizar la anotación @Primary para indicar que una implementación de una dependencia es la implementación primaria en un constructor, un método setter o un campo.

En general, la anotación @Primary es una anotación útil que se puede utilizar para indicar que una implementación de una dependencia es la implementación primaria.

Aquí hay algunos ejemplos de cómo se pueden utilizar las anotaciones @Qualifier y @Primary juntas:

* **Si tenemos una clase `MyClass` que necesita una dependencia de la clase `MyDependency` y tenemos dos implementaciones de `MyDependency`, podemos utilizar la anotación @Qualifier para especificar la implementación específica que queremos inyectar. Por ejemplo, podemos utilizar la anotación @Qualifier con el valor "my-dependency-implementation-1" para inyectar la primera implementación de `MyDependency` y la anotación @Qualifier con el valor "my-dependency-implementation-2" para inyectar la segunda implementación de `MyDependency`.**
* **Si tenemos una clase `MyClass` que necesita una dependencia de la clase `MyDependency` y solo tenemos una implementación de `MyDependency`, podemos utilizar la anotación @Primary para indicar que esa implementación es la implementación primaria.**

### Anotacion Configuration

La anotación @Configuration se utiliza en Spring Boot para indicar que una clase es una clase de configuración. Una clase de configuración es una clase que proporciona información de configuración para Spring Boot.

La anotación @Configuration se utiliza en combinación con otras anotaciones, como @Bean y @ComponentScan. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Configuration:

```java
@Configuration
public class MyConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @ComponentScan("com.example.myapp")
    public void scan() {
    }
}
```

En este ejemplo, la clase `MyConfiguration` es una clase de configuración. La clase `MyConfiguration` proporciona dos elementos de configuración:

* **Un bean de la clase `MyBean`.** El bean de `MyBean` se crea utilizando el método `myBean()`.
* **Una anotación @ComponentScan que indica a Spring Boot que escanee el paquete `com.example.myapp` en busca de componentes.**

Spring Boot utiliza la anotación @Configuration para determinar qué clases son clases de configuración. Spring Boot utilizará las clases de configuración para obtener información de configuración para la aplicación.

La anotación @Configuration es una anotación útil que se puede utilizar para proporcionar información de configuración para Spring Boot.

Aquí hay algunos ejemplos de cómo se puede utilizar la anotación @Configuration:

* **Se puede utilizar la anotación @Configuration para proporcionar beans a Spring Boot.**
* **Se puede utilizar la anotación @Configuration para indicar a Spring Boot que escanee un paquete en busca de componentes.**
* **Se puede utilizar la anotación @Configuration para proporcionar configuraciones para otros elementos de Spring Boot, como los filtros o los interceptores.**

### Anotacion Bean

La anotación @Bean se utiliza en Spring Boot para indicar que un método devuelve un bean. Un bean es un objeto que se crea y administra por Spring Boot.

La anotación @Bean se utiliza en combinación con la anotación @Configuration. Por ejemplo, el siguiente código muestra cómo utilizar la anotación @Bean:

```java
@Configuration
public class MyConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
```

En este ejemplo, la clase `MyConfiguration` es una clase de configuración. La clase `MyConfiguration` proporciona un bean de la clase `MyBean`. El bean de `MyBean` se crea utilizando el método `myBean()`.

Spring Boot utiliza la anotación @Bean para determinar qué métodos devuelven beans. Spring Boot creará los beans que se devuelven por los métodos anotados con @Bean.

La anotación @Bean es una anotación útil que se puede utilizar para crear beans en Spring Boot.

Aquí hay algunos ejemplos de cómo se puede utilizar la anotación @Bean:

* **Se puede utilizar la anotación @Bean para crear objetos simples, como una instancia de una clase.**
* **Se puede utilizar la anotación @Bean para crear objetos complejos, como un objeto que se crea utilizando una fábrica.**
* **Se puede utilizar la anotación @Bean para crear objetos que dependen de otros objetos.**

En general, la anotación @Bean es una anotación versátil que se puede utilizar para crear una amplia variedad de beans en Spring Boot.

### Cuando declarar componentes con anotaciones o mediante una clase de configuración

La decisión de declarar componentes con anotaciones o mediante una clase de configuración depende de varios factores, entre ellos:

* **El grado de control que se necesita sobre la creación de beans.** Si se necesita un control completo sobre la creación de beans, es mejor utilizar una clase de configuración.
* **La necesidad de reutilizar beans.** Si se necesita reutilizar beans en diferentes clases o módulos, es mejor utilizar una clase de configuración.
* **La simplicidad de la aplicación.** Si la aplicación es simple, puede ser suficiente declarar componentes con anotaciones.

En general, se recomienda utilizar anotaciones para declarar componentes cuando:

* **Los componentes son simples y no requieren un control completo sobre su creación.**
* **Los componentes no necesitan ser reutilizados en diferentes clases o módulos.**
* **La aplicación es simple y no requiere una gran cantidad de configuración.**

Por ejemplo, si tenemos una clase `MyBean` que solo necesita una instancia, podemos declararla con una anotación:

```java
@Component
public class MyBean {

    public void doSomething() {
        // ...
    }
}
```

En este caso, no necesitamos un control completo sobre la creación de `MyBean`. Tampoco necesitamos reutilizar `MyBean` en diferentes clases o módulos. Y la aplicación es simple, por lo que no requiere una gran cantidad de configuración.

Por otro lado, si tenemos una clase `MyConfiguration` que proporciona varios beans, podemos declararlos en la clase de configuración:

```java
@Configuration
public class MyConfiguration {

    @Bean
    public MyBean myBean() {
        return new MyBean();
    }

    @Bean
    public MyOtherBean myOtherBean() {
        return new MyOtherBean();
    }
}
```

En este caso, necesitamos un control completo sobre la creación de `MyBean` y `MyOtherBean`. También necesitamos reutilizar `MyBean` y `MyOtherBean` en diferentes clases. Y la aplicación es lo suficientemente compleja como para requerir una gran cantidad de configuración.

En última instancia, la decisión de declarar componentes con anotaciones o mediante una clase de configuración es una decisión de diseño que debe tomarse en función de las necesidades específicas de la aplicación.

## Ciclo de vida de los componentes

El ciclo de vida de los componentes en Spring Boot es el proceso que sigue un componente desde su creación hasta su destrucción. El ciclo de vida de un componente está controlado por Spring Boot, y se puede personalizar mediante anotaciones.

El ciclo de vida de un componente en Spring Boot consta de las siguientes etapas:

* **Registro:** En esta etapa, Spring Boot registra el componente en el contenedor de beans.
* **Instanción:** En esta etapa, Spring Boot crea una instancia del componente.
* **Inicialización:** En esta etapa, Spring Boot inicializa el componente.
* **Inyección de dependencias:** En esta etapa, Spring Boot inyecta las dependencias del componente.
* **Uso:** En esta etapa, el componente se utiliza.
* **Destrucción:** En esta etapa, Spring Boot destruye el componente.

Las etapas de registro e instanciación son obligatorias para todos los componentes. Las etapas de inicialización, inyección de dependencias y uso son opcionales. La etapa de destrucción solo se aplica a los componentes que tienen un alcance mayor que `singleton`.

**Registro**

El registro de un componente se realiza mediante la anotación `@Component`. Esta anotación indica a Spring Boot que el componente debe registrarse en el contenedor de beans.

```
@Component
public class MyComponent {

}
```

**Instanción**

La instanciación de un componente se realiza mediante el contenedor de beans. El contenedor de beans utiliza una estrategia de creación de beans para crear una instancia del componente.

La estrategia de creación de beans predeterminada es `singleton`. Esto significa que Spring Boot creará una única instancia del componente y la utilizará para todas las solicitudes.

También se pueden utilizar otras estrategias de creación de beans, como `prototype` o `request`.

**Inicialización**

La inicialización de un componente se realiza mediante el método `init()`. Este método se invoca una vez que se ha creado el componente.

El método `init()` se puede utilizar para realizar cualquier tarea de inicialización que sea necesaria para el componente.

**Inyección de dependencias**

La inyección de dependencias se realiza mediante anotaciones, como `@Autowired`. Estas anotaciones indican a Spring Boot que debe inyectar las dependencias del componente.

Las dependencias se pueden inyectar en los constructores, los métodos setter o los campos de los componentes.

**Uso**

El componente se utiliza cuando se invoca un método del componente o cuando se accede a un atributo del componente.

**Destrucción**

La destrucción de un componente se realiza mediante el método `destroy()`. Este método se invoca una vez que el componente ya no es necesario.

El método `destroy()` se puede utilizar para realizar cualquier tarea de limpieza que sea necesaria para el componente.

**Personalización del ciclo de vida**

El ciclo de vida de un componente se puede personalizar mediante anotaciones. Las anotaciones que se pueden utilizar para personalizar el ciclo de vida de un componente son:

* **@PostConstruct:** Esta anotación indica a Spring Boot que se debe llamar al método anotado después de que se haya inicializado el componente.
* **@PreDestroy:** Esta anotación indica a Spring Boot que se debe llamar al método anotado antes de que se destruya el componente.

Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@PostConstruct` para realizar una tarea de inicialización:

```
@Component
public class MyComponent {

    @PostConstruct
    public void init() {
        // ...
    }

}
```

En este caso, el método `init()` se invocará una vez que se haya creado el componente.

### Anotacion PostConstruct

La anotación `@PostConstruct` se utiliza en Spring Boot para indicar que un método debe ser ejecutado después de que se haya inicializado un bean.

La anotación `@PostConstruct` se utiliza en combinación con la anotación `@Component`. Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@PostConstruct` para realizar una tarea de inicialización:

```java
@Component
public class MyComponent {

    @PostConstruct
    public void init() {
        // ...
    }

}
```

En este caso, el método `init()` se invocará una vez que se haya creado el componente.

El método anotado con `@PostConstruct` debe ser público y no debe tener argumentos. El método se puede utilizar para realizar cualquier tarea de inicialización que sea necesaria para el componente.

Por ejemplo, el siguiente código muestra cómo utilizar el método `init()` para inicializar una conexión a una base de datos:

```java
@Component
public class MyComponent {

    @PostConstruct
    public void init() {
        // Inicializa la conexión a la base de datos
    }

}
```

Es importante tener en cuenta que el método `init()` se invocará antes de que el componente sea utilizado. Por lo tanto, el método no debe realizar ninguna tarea que pueda bloquear el hilo principal de la aplicación.

También es importante tener en cuenta que el método `init()` se invocará solo una vez, incluso si el componente se crea varias veces.

En general, la anotación `@PostConstruct` es una anotación útil que se puede utilizar para realizar tareas de inicialización que deben ser ejecutadas después de que se haya creado un bean.

### Anotacion PreDestroy

La anotación `@PreDestroy` se utiliza en Spring Boot para indicar que un método debe ser ejecutado antes de que se destruya un bean.

La anotación `@PreDestroy` se utiliza en combinación con la anotación `@Component`. Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@PreDestroy` para realizar una tarea de limpieza:

```java
@Component
public class MyComponent {

    @PreDestroy
    public void destroy() {
        // ...
    }

}
```

En este caso, el método `destroy()` se invocará antes de que se destruya el componente.

El método anotado con `@PreDestroy` debe ser público y no debe tener argumentos. El método se puede utilizar para realizar cualquier tarea de limpieza que sea necesaria para el componente.

Por ejemplo, el siguiente código muestra cómo utilizar el método `destroy()` para cerrar una conexión a una base de datos:

```java
@Component
public class MyComponent {

    @PreDestroy
    public void destroy() {
        // Cierra la conexión a la base de datos
    }

}
```

Es importante tener en cuenta que el método `destroy()` se invocará después de que el componente haya sido utilizado. Por lo tanto, el método no debe realizar ninguna tarea que pueda bloquear el hilo principal de la aplicación.

También es importante tener en cuenta que el método `destroy()` se invocará solo una vez, incluso si el componente se crea varias veces.

En general, la anotación `@PreDestroy` es una anotación útil que se puede utilizar para realizar tareas de limpieza que deben ser ejecutadas antes de que se destruya un bean.

**Diferencias entre @PostConstruct y @PreDestroy**

Las principales diferencias entre las anotaciones `@PostConstruct` y `@PreDestroy` son las siguientes:

| Característica     | @PostConstruct                         | @PreDestroy                      |
|--------------------|----------------------------------------|----------------------------------|
| Orden de ejecución | Después de la creación del bean        | Antes de la destrucción del bean |
| Uso                | Para realizar tareas de inicialización | Para realizar tareas de limpieza |
| Obligatoriedad     | No es obligatoria                      | No es obligatoria                |

En general, la anotación `@PostConstruct` se utiliza para realizar tareas de inicialización que deben ser ejecutadas después de que se haya creado un bean, mientras que la anotación `@PreDestroy` se utiliza para realizar tareas de limpieza que deben ser ejecutadas antes de que se destruya un bean.

## Alcance (Scope) de los componentes

El alcance o scope de un componente en Spring Boot determina cómo se crea y se administra el componente. Spring Boot proporciona los siguientes alcances de componentes:

* **Singleton:** Este es el alcance predeterminado. Un componente con alcance singleton se crea una sola vez y se comparte por todas las solicitudes.
* **Prototype:** Un componente con alcance prototype se crea cada vez que se requiere.
* **Request:** Un componente con alcance request se crea para cada solicitud HTTP.
* **Session:** Un componente con alcance session se crea para cada sesión HTTP.
* **GlobalSession:** Un componente con alcance globalSession se crea para cada sesión global HTTP.

El alcance de un componente se puede especificar mediante la anotación `@Scope`. Por ejemplo, el siguiente código muestra cómo especificar el alcance de un componente como singleton:

```
@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
public class MyComponent {

}
```

En este ejemplo, el componente `MyComponent` se creará una sola vez y se compartirá por todas las solicitudes.

La elección del alcance adecuado para un componente depende de las necesidades específicas de la aplicación. Por ejemplo, un componente que debe ser compartido por todas las solicitudes debe tener un alcance singleton. Un componente que debe crearse para cada solicitud debe tener un alcance prototype.

Aquí hay una tabla que resume los diferentes alcances de componentes de Spring Boot:

| Alcance       | Descripción                                                   |
|---------------|---------------------------------------------------------------|
| Singleton     | Se crea una sola vez y se comparte por todas las solicitudes. |
| Prototype     | Se crea cada vez que se requiere.                             |
| Request       | Se crea para cada solicitud HTTP.                             |
| Session       | Se crea para cada sesión HTTP.                                |
| GlobalSession | Se crea para cada sesión global HTTP.                         |

### Alcances de algunos componentes

Los componentes más comunes en Spring Boot suelen tener el alcance **singleton**. Esto se debe a que los componentes singleton se comparten por todas las solicitudes, lo que puede mejorar el rendimiento y la eficiencia de la aplicación.

Algunos ejemplos de componentes comunes con alcance singleton son:

* **Controladores HTTP:** Los controladores HTTP son los componentes que reciben y procesan las solicitudes HTTP. Es importante que los controladores HTTP sean singleton para que puedan compartirse por todas las solicitudes.
* **Servicios:** Los servicios son componentes que implementan la lógica empresarial de la aplicación. Es importante que los servicios sean singleton para que puedan compartirse por todas las solicitudes.
* **Repositorios:** Los repositorios son componentes que proporcionan acceso a los datos. Es importante que los repositorios sean singleton para que puedan compartirse por todas las solicitudes.

Sin embargo, hay algunos componentes que pueden ser más adecuados para tener un alcance **prototype**. Por ejemplo, un componente que debe crearse para cada solicitud, como un objeto de sesión, debe tener un alcance prototype.

Algunos ejemplos de componentes comunes con alcance prototype son:

* **Objetos de sesión:** Los objetos de sesión son objetos que se crean para cada sesión HTTP. Es importante que los objetos de sesión sean prototype para que no se compartan entre sesiones.
* **Objetos de trabajo:** Los objetos de trabajo son objetos que se utilizan para realizar tareas que no deben compartirse entre solicitudes. Es importante que los objetos de trabajo sean prototype para que se puedan reutilizar para diferentes solicitudes.

En última instancia, la elección del alcance adecuado para un componente depende de las necesidades específicas de la aplicación.

### Anotacion RequestScope

La anotación `@RequestScope` se utiliza en Spring Boot para indicar que un componente debe crearse para cada solicitud HTTP.

La anotación `@RequestScope` se utiliza en combinación con la anotación `@Component`. Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@RequestScope` para crear un componente nuevo para cada solicitud HTTP:

```
@Component
@RequestScope
public class MyComponent {

}
```

En este caso, un nuevo componente `MyComponent` se creará para cada solicitud HTTP.

El componente anotado con `@RequestScope` debe ser público y no debe tener argumentos. El componente se puede utilizar para realizar cualquier tarea que sea necesaria para la solicitud HTTP.

Por ejemplo, el siguiente código muestra cómo utilizar el componente `MyComponent` para almacenar el estado de la solicitud HTTP:

```
@Component
@RequestScope
public class MyComponent {

    private String requestId;

    public MyComponent() {
        this.requestId = UUID.randomUUID().toString();
    }

    public String getRequestId() {
        return this.requestId;
    }

}
```

En este ejemplo, el componente `MyComponent` almacena el identificador de solicitud HTTP en una propiedad privada. El identificador de solicitud HTTP se puede utilizar para identificar la solicitud HTTP en particular.

Es importante tener en cuenta que los componentes con alcance `requestScope` se destruyen cuando finaliza la solicitud HTTP. Por lo tanto, el componente no debe contener ninguna información que deba conservarse más allá de la finalización de la solicitud HTTP.

En general, la anotación `@RequestScope` es una anotación útil que se puede utilizar para crear componentes que sean específicos de una solicitud HTTP.

### Anotacion SessionScope

La anotación `@SessionScope` se utiliza en Spring Boot para indicar que un componente debe crearse para cada sesión HTTP.

La anotación `@SessionScope` se utiliza en combinación con la anotación `@Component`. Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@SessionScope` para crear un componente nuevo para cada sesión HTTP:

```
@Component
@SessionScope
public class MyComponent {

}
```

En este caso, un nuevo componente `MyComponent` se creará para cada sesión HTTP.

El componente anotado con `@SessionScope` debe ser público y no debe tener argumentos. El componente se puede utilizar para realizar cualquier tarea que sea necesaria para la sesión HTTP.

Por ejemplo, el siguiente código muestra cómo utilizar el componente `MyComponent` para almacenar el estado de la sesión HTTP:

```
@Component
@SessionScope
public class MyComponent implements Serializable {

    private static final long serialVersionUID = 946004357128146951L;

    private String sessionId;

    public MyComponent() {
        this.sessionId = UUID.randomUUID().toString();
    }

    public String getSessionId() {
        return this.sessionId;
    }

}
```

En este ejemplo, el componente `MyComponent` almacena el identificador de sesión HTTP en una propiedad privada. El identificador de sesión HTTP se puede utilizar para identificar la sesión HTTP en particular.

Es importante tener en cuenta que los componentes con alcance `sessionScope` se destruyen cuando finaliza la sesión HTTP. Por lo tanto, el componente no debe contener ninguna información que deba conservarse más allá de la finalización de la sesión HTTP.

En general, la anotación `@SessionScope` es una anotación útil que se puede utilizar para crear componentes que sean específicos de una sesión HTTP.

**Diferencias entre @RequestScope y @SessionScope**

Las principales diferencias entre las anotaciones `@RequestScope` y `@SessionScope` son las siguientes:

| Característica | @RequestScope                            | @SessionScope                         |
|----------------|------------------------------------------|---------------------------------------|
| Alcance        | Por solicitud HTTP                       | Por sesión HTTP                       |
| Creación       | Para cada solicitud HTTP                 | Para cada sesión HTTP                 |
| Destrucción    | Cuando finaliza la solicitud HTTP        | Cuando finaliza la sesión HTTP        |
| Usos comunes   | Almacenar el estado de la solicitud HTTP | Almacenar el estado de la sesión HTTP |

En general, la anotación `@RequestScope` es más adecuada para almacenar información que es específica de una solicitud HTTP, mientras que la anotación `@SessionScope` es más adecuada para almacenar información que es específica de una sesión HTTP.

### Anotacion AplicationScope

La anotación `@ApplicationScope` se utiliza en Spring Boot para indicar que un componente debe crearse una sola vez y se compartirá por todas las solicitudes.

La anotación `@ApplicationScope` se utiliza en combinación con la anotación `@Component`. Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@ApplicationScope` para crear un componente nuevo que se compartirá por todas las solicitudes:

```
@Component
@ApplicationScope
public class MyComponent {

}
```

En este caso, un nuevo componente `MyComponent` se creará una sola vez y se compartirá por todas las solicitudes.

El componente anotado con `@ApplicationScope` debe ser público y no debe tener argumentos. El componente se puede utilizar para realizar cualquier tarea que sea necesaria para la aplicación.

Por ejemplo, el siguiente código muestra cómo utilizar el componente `MyComponent` para almacenar el estado de la aplicación:

```
@Component
@ApplicationScope
public class MyComponent {

    private String applicationId;

    public MyComponent() {
        this.applicationId = UUID.randomUUID().toString();
    }

    public String getApplicationId() {
        return this.applicationId;
    }

}
```

En este ejemplo, el componente `MyComponent` almacena el identificador de aplicación en una propiedad privada. El identificador de aplicación se puede utilizar para identificar la aplicación en particular.

Es importante tener en cuenta que los componentes con alcance `applicationScope` se destruyen cuando se detiene la aplicación. Por lo tanto, el componente no debe contener ninguna información que deba conservarse más allá de la detención de la aplicación.

En general, la anotación `@ApplicationScope` es una anotación útil que se puede utilizar para crear componentes que sean específicos de la aplicación.

**Diferencias entre @RequestScope, @SessionScope y @ApplicationScope**

Las principales diferencias entre las anotaciones `@RequestScope`, `@SessionScope` y `@ApplicationScope` son las siguientes:

| Característica | @RequestScope                            | @SessionScope                         | @ApplicationScope                    |
|----------------|------------------------------------------|---------------------------------------|--------------------------------------|
| Alcance        | Por solicitud HTTP                       | Por sesión HTTP                       | Por aplicación                       |
| Creación       | Para cada solicitud HTTP                 | Para cada sesión HTTP                 | Una sola vez                         |
| Destrucción    | Cuando finaliza la solicitud HTTP        | Cuando finaliza la sesión HTTP        | Cuando se detiene la aplicación      |
| Usos comunes   | Almacenar el estado de la solicitud HTTP | Almacenar el estado de la sesión HTTP | Almacenar el estado de la aplicación |

En general, la anotación `@RequestScope` es más adecuada para almacenar información que es específica de una solicitud HTTP, mientras que la anotación `@SessionScope` es más adecuada para almacenar información que es específica de una sesión HTTP. La anotación `@ApplicationScope` es más adecuada para almacenar información que es específica de la aplicación.****
