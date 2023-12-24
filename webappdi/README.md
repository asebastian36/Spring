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

¿Te gustaría conocer más sobre algún aspecto específico de Spring Boot Actuator?


