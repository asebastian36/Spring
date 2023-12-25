# Notas

## Inyeccion de dependencias

La inyección de dependencias (DI) es un patrón de diseño de software que permite que los componentes de un sistema se conecten entre sí sin tener que conocer los detalles de la implementación.

En la inyección de dependencias, un componente (el cliente) solicita una dependencia (el proveedor) a un contenedor de inyección de dependencias. El contenedor de inyección de dependencias crea el proveedor y lo inyecta en el cliente.

La inyección de dependencias tiene las siguientes ventajas:

* **Reduce el acoplamiento:** Al inyectar las dependencias en los componentes, se reduce el acoplamiento entre los componentes. Esto hace que los componentes sean más reutilizables y fáciles de mantener.
* **Mejora la testabilidad:** Al inyectar las dependencias en los componentes, se facilita la creación de pruebas unitarias.
* **Facilita la escalabilidad:** Al inyectar las dependencias en los componentes, se facilita la escalabilidad de las aplicaciones.

La inyección de dependencias se puede implementar de varias maneras, incluyendo:

* **Inyección por constructor:** El cliente pasa el proveedor como argumento al constructor del cliente.
* **Inyección por setter:** El cliente llama a un método setter del cliente para inyectar el proveedor.
* **Inyección por campo:** El contenedor de inyección de dependencias inyecta el proveedor directamente en el campo del cliente.

Spring Framework proporciona soporte para la inyección de dependencias. Spring utiliza un contenedor de inyección de dependencias llamado ApplicationContext para crear y administrar las dependencias de las aplicaciones Spring.

En Spring, la inyección de dependencias se puede realizar mediante anotaciones. Las anotaciones de Spring permiten a los desarrolladores especificar las dependencias que deben inyectarse en los componentes.

Las anotaciones de inyección de dependencias más utilizadas en Spring son:

* `@Autowired`: Se utiliza para inyectar una dependencia mediante un constructor, un setter o un campo.
* `@Resource`: Se utiliza para inyectar una dependencia mediante un constructor, un setter o un campo.
* `@Qualifier`: Se utiliza para especificar el proveedor que se debe inyectar.

La siguiente es una clase de ejemplo que utiliza la inyección de dependencias:

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

En esta clase, el atributo `userRepository` está anotado con la anotación `@Autowired`. Esto indica al contenedor de inyección de dependencias que debe inyectar una instancia de la clase `UserRepository` en el atributo `userRepository`.

El contenedor de inyección de dependencias creará una instancia de la clase `UserRepository` y la inyectará en el atributo `userRepository`.

La inyección de dependencias es una técnica importante en el desarrollo de software orientado a objetos. La inyección de dependencias permite que los componentes de un sistema se conecten entre sí de forma flexible y eficiente.

## Spring Boot Actuator: Monitoreo y administración de endpoints

Spring Boot Actuator es una biblioteca adicional integrada en Spring Boot que proporciona una serie de endpoints HTTP para:

* **Monitorear:** el estado de la aplicación, métricas de rendimiento, health checks, información del entorno y del sistema.
* **Administrar:** la aplicación, como reiniciarla, cambiar la configuración o realizar tareas como limpiar cachés.

Estos endpoints son accesibles a través de una ruta base configurable por defecto "/actuator".

**Beneficios de Spring Boot Actuator:**

* **Simplifica el monitoreo y la administración:** Al exponer endpoints con información clave, facilita la supervisión del estado de la aplicación sin necesidad de desarrollar componentes o paneles de control personalizados.
* **Integración con herramientas de monitorización:** Muchos frameworks y herramientas de monitoring (Prometheus, Grafana, Micrometer) pueden consumir automáticamente las métricas expuestas por los endpoints de Actuator.
* **Mejora la depuración y la resolución de problemas:** La información detallada proporcionada por los endpoints puede ayudar a identificar y solucionar problemas de rendimiento o configuración.
* **Promueve buenas prácticas de ingeniería:** Actuator fomenta la creación de aplicaciones observables y con capacidad de administración, lo que las hace más fiables y mantenibles.

**Principales features de Spring Boot Actuator:**

* **Health Check:** Indica el estado general de la aplicación mediante endpoints como `/health` y `/liveness`.
* **Info:** Brinda información detallada sobre la aplicación, como versión, dependencias, configuración y entorno.
* **Metrics:** Expone métricas de rendimiento para diferentes aspectos de la aplicación, como el uso de la CPU, la memoria y los recursos de la base de datos.
* **Logging:** Permite ver y controlar los logs de la aplicación en vivo.
* **Beans:** Muestra información sobre los beans administrados por Spring.
* **Caches:** Permite gestionar las cachés de la aplicación, como ver su estado y limpiarlas.
* **Custom Endpoints:** Los desarrolladores pueden crear endpoints personalizados para exponer información y funcionalidades específicas de su aplicación.

**Seguridad de Spring Boot Actuator:**

Por defecto, los endpoints de Actuator están expuestos y no requieren autenticación, lo que es un riesgo de seguridad en entornos de producción. Es crucial habilitar mecanismos de seguridad como:

* **Autenticación:** Requerir una contraseña o token para acceder a los endpoints.
* **Autorización:** Controlar qué usuarios tienen acceso a cada endpoint.
* **Limitar la exposición:** Deshabilitar los endpoints que no se necesitan o restringir su acceso a determinadas direcciones IP.

**En resumen, Spring Boot Actuator es una herramienta valiosa para monitorear y administrar aplicaciones Spring Boot, mejorando su observabilidad, depuración y rendimiento. Recuerda implementar siempre medidas de seguridad para proteger los endpoints expuestos.**

## Principio de inmutabilidad

El principio de la inmutabilidad es un principio de diseño de software que establece que los objetos deben ser inmutables, es decir, no deben poder modificarse después de su creación.

Los objetos inmutables tienen las siguientes ventajas:

* **Mejoran la seguridad:** Los objetos inmutables no pueden modificarse accidentalmente, lo que reduce el riesgo de errores.
* **Mejoran la concurrencia:** Los objetos inmutables pueden ser compartidos de forma segura entre hilos, lo que facilita la programación concurrente.
* **Mejoran la testabilidad:** Los objetos inmutables son más fáciles de probar, ya que no es necesario preocuparse por los efectos secundarios de las modificaciones.

Hay varias formas de implementar el principio de la inmutabilidad:

* **Utilizando clases finales:** Las clases finales no pueden ser extendidas, lo que garantiza que los objetos creados a partir de ellas no pueden ser modificados.
* **Utilizando constructores privados:** Los constructores privados solo pueden ser llamados desde el interior de la clase, lo que garantiza que los objetos solo pueden ser creados por la propia clase.
* **Utilizando getters y setters:** Los getters y setters solo pueden devolver una copia de los datos del objeto, lo que garantiza que los datos originales no se pueden modificar.

La siguiente es una clase de ejemplo que implementa el principio de la inmutabilidad:

```java
public final class Point {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
```

Esta clase es final, por lo que no puede ser extendida. El constructor de la clase es privado, por lo que los objetos solo pueden ser creados por la propia clase. Los getters de la clase solo devuelven una copia de los datos del objeto, por lo que los datos originales no se pueden modificar.

El principio de la inmutabilidad es una técnica importante en el desarrollo de software seguro y concurrente.

## Inmutabilidad con la interfaz Cloneable

La interfaz `Cloneable` es una interfaz de Java que indica que una clase puede ser clonada. La clonación es el proceso de crear una copia exacta de un objeto.

Para implementar el principio de la inmutabilidad usando la interfaz `Cloneable`, una clase debe implementar la interfaz `Cloneable` y proporcionar una implementación del método `clone()`. El método `clone()` debe devolver una copia exacta del objeto.

La siguiente es una clase de ejemplo que implementa el principio de la inmutabilidad usando la interfaz `Cloneable`:

```java
public final class Point implements Cloneable {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
```

Esta clase es final, por lo que no puede ser extendida. El constructor de la clase es privado, por lo que los objetos solo pueden ser creados por la propia clase. Los getters de la clase solo devuelven una copia de los datos del objeto. El método `clone()` simplemente devuelve una copia del objeto.

Esta implementación de la inmutabilidad usando la interfaz `Cloneable` tiene las siguientes ventajas:

* Es simple de implementar.
* Es compatible con la mayoría de los IDE y frameworks.

Sin embargo, también tiene algunas desventajas:

* No es completamente segura. Es posible que un objeto clonado pueda ser modificado accidentalmente o maliciosamente.
* No es adecuada para objetos que contienen referencias a otros objetos.

Para evitar que un objeto clonado pueda ser modificado accidentalmente o maliciosamente, se puede utilizar el método `clone()` de la clase `Object` para crear una copia superficial del objeto. Una copia superficial solo copia los datos del objeto original, pero no copia las referencias a otros objetos.

La siguiente es una implementación mejorada de la clase `Point` que utiliza una copia superficial:

```java
public final class Point implements Cloneable {

    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Point point = (Point) super.clone();

        // Realiza una copia superficial de las referencias
        point.x = this.x;
        point.y = this.y;

        return point;
    }
}
```

Esta implementación de la clase `Point` es segura, ya que no es posible que un objeto clonado pueda modificar los datos originales del objeto original.

En general, la interfaz `Cloneable` es una herramienta útil para implementar el principio de la inmutabilidad. Sin embargo, es importante tener en cuenta las limitaciones de esta implementación.

## Anotacion Service y Repository

Las anotaciones `@Service` y `@Repository` son anotaciones de Spring Framework que se utilizan para indicar que una clase es un servicio o un repositorio, respectivamente.

La anotación `@Service` se utiliza para indicar que una clase es un servicio, es decir, una clase que implementa la lógica de negocio de una aplicación. Los servicios suelen ser clases que realizan operaciones complejas, como la creación, la lectura, la actualización y la eliminación de datos.

La anotación `@Repository` se utiliza para indicar que una clase es un repositorio, es decir, una clase que proporciona acceso a los datos de una aplicación. Los repositorios suelen ser clases que implementan un patrón de diseño de repositorio, como el patrón DAO (Data Access Object).

Las anotaciones `@Service` y `@Repository` tienen las siguientes ventajas:

* **Mejoran la organización del código:** Las anotaciones permiten organizar el código de una aplicación en capas, lo que facilita la comprensión y la mantenimiento del código.
* **Facilitan la inyección de dependencias:** Las anotaciones permiten inyectar los servicios y los repositorios en otras clases, lo que facilita el desarrollo de aplicaciones desacopladas.

La siguiente es una clase de ejemplo que utiliza la anotación `@Service`:

```java
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
}
```

En esta clase, la anotación `@Service` indica que la clase `UserService` es un servicio. La anotación `@Autowired` indica que el atributo `userRepository` debe ser inyectado por Spring.

La siguiente es una clase de ejemplo que utiliza la anotación `@Repository`:

```java
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
```

En esta clase, la anotación `@Repository` indica que la clase `UserRepository` es un repositorio. La clase `UserRepository` implementa la interfaz `JpaRepository`, que proporciona métodos para acceder a los datos de la base de datos.

En general, las anotaciones `@Service` y `@Repository` son herramientas útiles para organizar el código de una aplicación y facilitar la inyección de dependencias.
