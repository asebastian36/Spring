# Estructura de una aplicacion Spring Boot

* **Maven Dependencies**: Ahi se guardan las depencias del proyecto.
* **src/main/java**: Carpeta raiz del proyecto, dentro esta la carpeta definida para guardar todas las clases que se van creando, tambien contiene una clase principal que ejecutara la aplicacion.
* **JRE System Library**: Contiene el entorno de ejecución de Java (JRE) que se utiliza para ejecutar tu código. El JRE es una colección de archivos y bibliotecas que permiten ejecutar programas Java.
* **src/main/resources**: Configuracion principal de Spring Boot para sobreescribir la configuracion (por defecto esta vacio) dado que ya esta configurado. Se configuran cosas como:
  * Conexiones a BD.
    * URL.
    * Cadena de conexion.
    * Credenciales del motor
    * Driver
  * Hibernate.
  * JPA.
* **target**: Aqui se guarda el empaquetado de la aplicacion el `.jar` para desplegar la aplicacion.

## Dependencias utilizadas

**Spring web** es una dependencia que proporciona soporte para crear aplicaciones web con Spring Framework. Esta dependencia incluye las clases y los métodos necesarios para crear controladores, vistas y modelos.

**Spring dev tools** es una dependencia que proporciona herramientas de desarrollo para Spring Framework. Estas herramientas incluyen un servidor de desarrollo integrado, un depurador y un asistente de codificación.

**Thymeleaf** es una plantilla de motor de vista que se utiliza para crear vistas HTML en aplicaciones web con Spring Framework. Thymeleaf es una plantilla de motor de vista de código abierto que es fácil de usar y personalizar.

| Dependencia | Descripción |
|-------------|-------------|
| Spring web | Proporciona soporte para crear aplicaciones web con Spring Framework |
| Spring dev tools | Proporciona herramientas de desarrollo para Spring Framework |
| Thymeleaf | Es una plantilla de motor de vista que se utiliza para crear vistas HTML en aplicaciones web con Spring Framework |

### Spring web

Proporciona un conjunto de clases y métodos que se utilizan para crear aplicaciones web con Spring Framework. Estas clases y métodos se dividen en varias categorías:

* **Controladores:** Los controladores son las clases que reciben las solicitudes HTTP de los clientes y responden con las respuestas HTTP.
* **Vistas:** Las vistas son las páginas HTML que se muestran a los clientes en respuesta a las solicitudes HTTP.
* **Modelos:** Los modelos son los datos que se pasan de los controladores a las vistas.

Los controladores son la parte más importante de una aplicación web Spring. Los controladores reciben las solicitudes HTTP de los clientes y responden con las respuestas HTTP. Para crear un controlador, se debe extender la clase `@Controller` de Spring. La clase `@Controller` proporciona métodos anotados con `@RequestMapping` que se utilizan para mapear las solicitudes HTTP a los métodos del controlador.

Las vistas son las páginas HTML que se muestran a los clientes en respuesta a las solicitudes HTTP. Para crear una vista, se debe utilizar un motor de plantillas. Spring proporciona varios motores de plantillas, como Thymeleaf, JSP y FreeMarker.

Los modelos son los datos que se pasan de los controladores a las vistas. Para pasar datos a una vista, se pueden utilizar los métodos `ModelAndView.addObject()` o `Model.addAttribute()`.

Aquí hay un ejemplo de un controlador simple que utiliza Spring web:

```java
@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("message", "Hello, world!");
        return "hello";
    }

}
```

Este controlador mapea la solicitud HTTP a la ruta `/hello`. Cuando se recibe una solicitud HTTP a la ruta `/hello`, el método `hello()` se ejecuta y se pasa un modelo a la vista `hello`. La vista `hello` utiliza el modelo para mostrar el mensaje "Hello, world!" al cliente.

Spring web proporciona una variedad de características y funcionalidades que facilitan la creación de aplicaciones web. Estas características incluyen:

* **Soporte para el enrutamiento HTTP:** Spring web proporciona un sistema de enrutamiento HTTP que se utiliza para mapear las solicitudes HTTP a los controladores.
* **Soporte para la inyección de dependencias:** Spring web utiliza la inyección de dependencias para inyectar automáticamente las dependencias en los controladores y las vistas.
* **Soporte para la internacionalización:** Spring web proporciona soporte para la internacionalización de las aplicaciones web.
* **Soporte para la seguridad:** Spring web proporciona soporte para la seguridad de las aplicaciones web.

Spring web es una herramienta poderosa que puede utilizarse para crear aplicaciones web de alta calidad con Spring Framework.

### Spring dev tools

Es un conjunto de herramientas de desarrollo que se utilizan para crear aplicaciones web con Spring Framework. Estas herramientas incluyen:

* **Servidor de desarrollo integrado:** El servidor de desarrollo integrado (IDE) de Spring dev tools proporciona un entorno de desarrollo integrado para crear y ejecutar aplicaciones web con Spring Framework.
* **Depuración:** El depurador de Spring dev tools permite depurar aplicaciones web con Spring Framework.
* **Asistente de codificación:** El asistente de codificación de Spring dev tools proporciona sugerencias de código y ayuda a completar el código automáticamente.
* **Herramientas de análisis:** Las herramientas de análisis de Spring dev tools ayudan a encontrar errores y problemas en las aplicaciones web con Spring Framework.

El servidor de desarrollo integrado de Spring dev tools es una herramienta muy útil para crear y ejecutar aplicaciones web con Spring Framework. El servidor de desarrollo integrado proporciona un entorno de desarrollo integrado que incluye un editor de código, un depurador y un servidor web. El editor de código proporciona una serie de características que facilitan la creación de código, como la autocompletación, la refactorización y la navegación de código. El depurador permite depurar aplicaciones web con Spring Framework. El depurador permite establecer puntos de interrupción, ver el valor de las variables y seguir el flujo de ejecución del código. El servidor web permite ejecutar aplicaciones web con Spring Framework. El servidor web se integra con el IDE, por lo que no es necesario configurar un servidor web externo.

El depurador de Spring dev tools es una herramienta muy útil para encontrar errores y problemas en las aplicaciones web con Spring Framework. El depurador permite establecer puntos de interrupción, ver el valor de las variables y seguir el flujo de ejecución del código. El depurador también permite interactuar con la aplicación web en tiempo de ejecución.

El asistente de codificación de Spring dev tools es una herramienta muy útil para completar el código automáticamente. El asistente de codificación proporciona sugerencias de código en base al contexto del código. El asistente de codificación también puede completar el código automáticamente.

Las herramientas de análisis de Spring dev tools son una serie de herramientas que ayudan a encontrar errores y problemas en las aplicaciones web con Spring Framework. Estas herramientas incluyen un analizador de código, un analizador de rendimiento y un analizador de seguridad. El analizador de código ayuda a encontrar errores de sintaxis y semántica en el código. El analizador de rendimiento ayuda a encontrar problemas de rendimiento en las aplicaciones web. El analizador de seguridad ayuda a encontrar problemas de seguridad en las aplicaciones web.

Spring dev tools es una herramienta poderosa que puede utilizarse para crear, depurar y analizar aplicaciones web con Spring Framework.

### Thymeleaf

Es un motor de plantillas de vista de código abierto que se utiliza para crear vistas HTML en aplicaciones web con Spring Framework. Thymeleaf es un motor de plantillas de vista de alto rendimiento que es fácil de usar y personalizar.

Thymeleaf es una plantilla de motor de vista de plantillas, lo que significa que utiliza plantillas HTML para crear las vistas de las aplicaciones web. Las plantillas HTML se pueden escribir manualmente o generarse automáticamente a partir de modelos de datos.

Thymeleaf proporciona una variedad de características y funcionalidades que facilitan la creación de vistas HTML. Estas características incluyen:

* **Expresión de modelo:** Thymeleaf proporciona expresiones de modelo que se utilizan para acceder a los datos del modelo en las plantillas.
* **Controles de flujo:** Thymeleaf proporciona controles de flujo que se utilizan para controlar el flujo de la ejecución de la plantilla.
* **Comandos:** Thymeleaf proporciona comandos que se utilizan para realizar tareas específicas en las plantillas.
* **Extendibilidad:** Thymeleaf es extensible, por lo que se pueden añadir nuevas características y funcionalidades a Thymeleaf.

Thymeleaf es una herramienta poderosa que puede utilizarse para crear vistas HTML de alta calidad con Spring Framework.

Aquí hay algunos ejemplos de cómo utilizar Thymeleaf para crear vistas HTML:

* Para mostrar el valor de una variable de modelo en una plantilla, se puede utilizar la siguiente expresión:

```html
{{ variable }}
```

* Para crear un bucle en un conjunto de datos, se puede utilizar la siguiente expresión:

```html
<ul>
  {% for item in items %}
    <li>{{ item }}</li>
  {% endfor %}
</ul>
```

* Para mostrar un formulario en una plantilla, se puede utilizar la siguiente expresión:

```html
<form action="/submit">
  <input type="text" name="name" />
  <input type="submit" value="Enviar" />
</form>
```

Thymeleaf es una herramienta versátil que puede utilizarse para crear una variedad de vistas HTML.

## Mandar datos desde el controlador hasta la vista

Opcion 1 con `Model`

```java
@GetMapping(value={"/index", "/", "/home"})
 public String index(Model model) {
  model.addAttribute("titulo", "Hola desde Spring framework");
  return "index";
 }
```

Opcion 2 con `ModelMap`

```java
@GetMapping(value={"/index", "/", "/home"})
 public String index(ModelMap model) {
  model.addAttribute("titulo", "Hola desde Spring framework");
  return "index";
 }
```

Opcion 3 con `Map`

```java
@GetMapping(value={"/index", "/", "/home"})
 public String index(Map<String, Object> map) {
  map.put("titulo", "Hola desde Spring framework");
  return "index";
 }
```

Opcion 4 con `ModelAndView`

```java
@GetMapping(value={"/index", "/", "/home"})
public ModelAndView index(ModelAndView mv) {
 mv.addObject("titulo", "Hola desde Spring framework");
 mv.setViewName("index");
 return mv;
}
```

## Anotacion @ResquestMapping

La anotación `@RequestMapping` es una anotación de Spring Framework que se utiliza para mapear las solicitudes HTTP a los métodos de los controladores.

La anotación `@RequestMapping` se puede utilizar en el nivel de clase o de método. Cuando se utiliza en el nivel de clase, mapea todas las solicitudes HTTP a la clase de controlador. Cuando se utiliza en el nivel de método, mapea las solicitudes HTTP al método del controlador.

La anotación @RequestMapping tiene los siguientes atributos:

* **value:** El atributo `value` especifica la ruta HTTP que se va a mapear.
* **method:** El atributo `method` especifica el método HTTP que se va a mapear.
* **consumes:** El atributo `consumes` especifica los tipos MIME que se van a aceptar.
* **produces:** El atributo `produces` especifica los tipos MIME que se van a producir.

Aquí hay un ejemplo de cómo utilizar la anotación @RequestMapping:

```java
@Controller
@RequestMapping("/hello")
public class HelloController {

    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
```

Este código mapea todas las solicitudes HTTP a la ruta `/hello` al método `hello()` del controlador `HelloController`. El método `hello()` devuelve la cadena `hello` como respuesta.

La anotación `@RequestMapping` se utiliza para simplificar el desarrollo de aplicaciones web con Spring Framework. La anotación `@RequestMapping` permite mapear las solicitudes HTTP a los métodos de los controladores sin tener que escribir código adicional.

Aquí hay algunas de las ventajas de utilizar la anotación `@RequestMapping`:

* **Simplifica el desarrollo de aplicaciones web:** La anotación `@RequestMapping` permite mapear las solicitudes HTTP a los métodos de los controladores sin tener que escribir código adicional.
* **Reduce la posibilidad de errores:** La anotación `@RequestMapping` ayuda a evitar errores al mapear las solicitudes HTTP a los métodos de los controladores.
* **Mejora la legibilidad del código:** La anotación `@RequestMapping` hace que el código sea más legible y fácil de entender.

## Objeto Model

> POJO clase simple que contiene atributos para sus datos y metodos getter y setter, puede implementar interfaces como serilizable
> recomendable no aplicar interfaces de frameworks

## Directiva if en Thymeleaf

La directiva if en Thymeleaf se utiliza para controlar el flujo de ejecución de una plantilla. La directiva if permite mostrar o ocultar contenido en una plantilla en función de una condición.

La directiva if se puede utilizar para realizar una variedad de tareas, como:

* Mostrar o ocultar contenido en función de la condición de una variable.
* Mostrar o ocultar contenido en función del valor de una cookie o un encabezado de solicitud.
* Mostrar o ocultar contenido en función de la hora del día.

La directiva if es una herramienta poderosa que se puede utilizar para controlar el flujo de ejecución de una plantilla.

## Directiva each en Thymeleaf

La directiva each de Thymeleaf se utiliza para iterar sobre una colección de datos. La directiva each permite mostrar o procesar cada elemento de una colección en una plantilla.

La directiva each se puede utilizar para realizar una variedad de tareas, como:

* Mostrar una lista de elementos.
* Procesar una colección de datos.
* Crear una tabla o una matriz.

La directiva each es una herramienta poderosa que se puede utilizar para iterar sobre colecciones de datos en Thymeleaf.

Aquí hay algunos atributos adicionales de la directiva each:

* **start:** El atributo `start` especifica el índice inicial de la iteración.
* **end:** El atributo `end` especifica el índice final de la iteración.
* **step:** El atributo `step` especifica el paso de la iteración.
* **length:** El atributo `length` especifica la longitud de la colección.
* **index:** El atributo `index` especifica el índice actual de la iteración.
* **first:** El atributo `first` especifica si el elemento actual es el primero de la colección.
* **last:** El atributo `last` especifica si el elemento actual es el último de la colección.

Estos atributos se pueden utilizar para controlar el comportamiento de la iteración.

## Anotacion @ModelAttribute

La anotación @ModelAttribute en Spring Framework se utiliza para añadir objetos al modelo de vista. El modelo de vista es una colección de objetos que se utilizan para representar los datos de la aplicación en las vistas.

La anotación @ModelAttribute se puede utilizar en el nivel de método o de clase. Cuando se utiliza en el nivel de clase, añade un objeto al modelo de vista para todos los métodos del controlador. Cuando se utiliza en el nivel de método, añade un objeto al modelo de vista solo para ese método.

La anotación @ModelAttribute tiene los siguientes atributos:

* **name:** El atributo `name` especifica el nombre del objeto que se añade al modelo de vista.
* **binding:** El atributo `binding` especifica si el objeto se une al modelo de vista de forma estricta o no.

Cuando se utiliza la anotación @ModelAttribute, el objeto se añade al modelo de vista con el nombre especificado en el atributo `name`. El objeto se puede utilizar en las vistas para representar los datos de la aplicación.

Aquí hay un ejemplo de cómo utilizar la anotación @ModelAttribute:

```java
@Controller
public class HelloController {

    @ModelAttribute("user")
    public User getUser() {
        return new User("John Doe", "johndoe@example.com");
    }

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("name", "World");
        return "hello";
    }

}
```

Este código añade un objeto `User` al modelo de vista con el nombre `user`. El objeto `User` tiene dos propiedades: `name` y `email`.

La anotación @ModelAttribute se puede utilizar para realizar una variedad de tareas, como:

* Agregar objetos al modelo de vista para su uso en las vistas.
* Precargar datos en el modelo de vista.
* Vincular objetos al modelo de vista de forma estricta o no.

La anotación @ModelAttribute es una herramienta poderosa que se puede utilizar para controlar el contenido de las vistas.
