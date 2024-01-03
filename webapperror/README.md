# Notas

## Manejo de excepciones

El manejo de excepciones es una técnica de programación que permite al programador controlar los errores ocasionados durante la ejecución de un programa informático.

Las excepciones, como su nombre lo indica, se producen cuando la ejecución de un método no termina correctamente, sino que termina de manera excepcional como consecuencia de una situación no esperada.

El manejo de excepciones permite al usuario crear aplicaciones tolerantes a fallas y robustas (resistentes a errores) para controlar estas excepciones y que pueda seguir ejecutándose el programa sin verse afectado por el problema.

**Tipos de excepciones**

Las excepciones se pueden clasificar en dos tipos principales:

* **Excepciones controladas:** Son excepciones que pueden ser manejadas por el programador.
* **Excepciones no controladas:** Son excepciones que no pueden ser manejadas por el programador y que provocan el cierre del programa.

**Manejo de excepciones controladas**

El manejo de excepciones controladas se realiza utilizando la estructura try-catch-finally.

La estructura try-catch-finally tiene tres bloques:

* El bloque try contiene el código que puede generar excepciones.
* El bloque catch contiene el código que se ejecuta si se produce una excepción en el bloque try.
* El bloque finally contiene el código que se ejecuta siempre, independientemente de si se produce una excepción o no.

El siguiente ejemplo muestra cómo utilizar la estructura try-catch-finally para manejar una excepción:

```java
public class MyClass {

    public static void main(String[] args) {
        try {
            // Código que puede generar excepciones
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            // Código que se ejecuta si se produce una excepción
            System.out.println("Se ha producido una excepción aritmética");
        } finally {
            // Código que se ejecuta siempre
            System.out.println("Se ha ejecutado el bloque finally");
        }
    }
}
```

En este ejemplo, el bloque try contiene el código que puede generar una excepción aritmética. Si se produce la excepción, el bloque catch se ejecuta y se imprime un mensaje de error. El bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.

**Manejo de excepciones no controladas**

Las excepciones no controladas no pueden ser manejadas por el programador. En estos casos, el programa se cerrará inmediatamente.

Sin embargo, es posible realizar un manejo parcial de las excepciones no controladas utilizando la sentencia throw.

La sentencia throw se utiliza para lanzar una excepción. El siguiente ejemplo muestra cómo utilizar la sentencia throw para lanzar una excepción no controlada:

```java
public class MyClass {

    public static void main(String[] args) {
        throw new RuntimeException("Excepción no controlada");
    }
}
```

En este ejemplo, se lanza una excepción no controlada de tipo RuntimeException. El programa se cerrará inmediatamente después de lanzar la excepción.

**Consideraciones en el manejo de excepciones**

Al manejar excepciones, es importante tener en cuenta las siguientes consideraciones:

* **Especificidad:** El bloque catch debe ser lo más específico posible para la excepción que se va a manejar. Esto ayudará a evitar que se ejecute el código incorrecto cuando se produzca una excepción.
* **Excepciones no controladas:** Si es posible, es mejor manejar todas las excepciones. Sin embargo, en algunos casos puede ser necesario lanzar excepciones no controladas. En estos casos, es importante documentar claramente las excepciones que se pueden producir y las acciones que se realizarán cuando se produzcan.

**Herramientas de manejo de excepciones**

Existen varias herramientas que pueden ayudar al programador a manejar excepciones de manera más eficiente. Estas herramientas incluyen:

* **Marcos de trabajo de excepciones:** Los marcos de trabajo de excepciones proporcionan una estructura para el manejo de excepciones. Por ejemplo, el marco de trabajo de excepciones de Java proporciona las clases `Exception` y `Throwable`.
* **Herramientas de análisis de código:** Las herramientas de análisis de código pueden ayudar a identificar los errores que pueden provocar excepciones.

El manejo de excepciones es una técnica importante que debe ser utilizada por todos los programadores. El manejo de excepciones adecuado puede ayudar a crear aplicaciones más robustas y tolerantes a fallas.

## Anotacion RestControllerAdvice

La anotación **@RestControllerAdvice** es una anotación de Java que se utiliza para marcar una clase que contiene métodos para manejar excepciones que ocurren en controladores REST.

La anotación @RestControllerAdvice es una combinación de las anotaciones @ControllerAdvice y @ResponseBody. La anotación @ControllerAdvice permite declarar métodos relacionados con el manejo de excepciones que serán compartidos entre múltiples controladores, evitando así la duplicación de código o la generación de jerarquías para que los controladores traten de manera homogénea las excepciones.

La anotación @ResponseBody indica que los métodos de la clase anotada devolverán objetos de tipo `ResponseEntity`. Esto permite que los métodos de manejo de excepciones devuelvan respuestas HTTP personalizadas.

La anotación @RestControllerAdvice se puede utilizar para manejar las siguientes excepciones:

* **Excepciones no controladas:** Las excepciones no controladas son excepciones que no se manejan en los controladores REST.
* **Excepciones controladas:** Las excepciones controladas son excepciones que se manejan en los controladores REST.

El siguiente ejemplo muestra cómo utilizar la anotación @RestControllerAdvice:

```java
@RestControllerAdvice
public class MyRestControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // Devuelve una respuesta HTTP con el código 500
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```

En este ejemplo, el método `handleException()` se utiliza para manejar todas las excepciones, incluidas las excepciones no controladas. El método `handleException()` devuelve una respuesta HTTP con el código 500.

La anotación @RestControllerAdvice es una herramienta útil para centralizar el manejo de excepciones en aplicaciones REST.

## ResponseEntity

En Spring Framework, la clase `ResponseEntity` representa una respuesta HTTP completa. Esta clase incluye el código de estado HTTP, los encabezados y el cuerpo de la respuesta.

La clase `ResponseEntity` se utiliza para devolver respuestas HTTP personalizadas de los controladores REST.

La clase `ResponseEntity` tiene los siguientes atributos:

* **statusCode:** El código de estado HTTP de la respuesta.
* **headers:** Los encabezados de la respuesta.
* **body:** El cuerpo de la respuesta.

La clase `ResponseEntity` se puede crear utilizando el constructor de la clase o utilizando los métodos estáticos `ok()`, `created()`, `accepted()`, `noContent()`, `badRequest()`, `unauthorized()`, `forbidden()`, `notFound()`, `conflict()`, `gone()`, `preconditionFailed()`, `payloadTooLarge()`, `uriTooLong()`, `unsupportedMediaType()`, `internalServerError()`, `badGateway()`, `serviceUnavailable()`, `gatewayTimeout()`, `httpVersionNotSupported()`, `imATeapot()` y `tooManyRequests()`.

El siguiente ejemplo muestra cómo crear una respuesta HTTP con el código de estado 200:

```java
ResponseEntity<String> response = ResponseEntity.ok("Hola, mundo!");
```

El siguiente ejemplo muestra cómo crear una respuesta HTTP con el código de estado 400:

```java
ResponseEntity<ErrorResponse> response = ResponseEntity.badRequest().body(new ErrorResponse("El formato de la solicitud es incorrecto"));
```

La clase `ResponseEntity` es una herramienta útil para devolver respuestas HTTP personalizadas de los controladores REST.

## Anotacion ExceptionHandler

La anotación **@ExceptionHandler** es una anotación de Java que se utiliza para marcar un método que se utiliza para manejar excepciones.

La anotación @ExceptionHandler se puede utilizar en los siguientes contextos:

* **En métodos de controlador:** Los métodos de controlador pueden utilizar la anotación @ExceptionHandler para manejar excepciones que se producen en el controlador.
* **En clases @ControllerAdvice:** Las clases @ControllerAdvice pueden utilizar la anotación @ExceptionHandler para manejar excepciones que se producen en cualquier controlador.

La anotación @ExceptionHandler tiene los siguientes atributos:

* **value:** Una clase o una lista de clases que representan las excepciones que se van a manejar.
* **order:** Un entero que indica el orden en el que se van a ejecutar los métodos de manejo de excepciones.

El siguiente ejemplo muestra cómo utilizar la anotación @ExceptionHandler en un método de controlador:

```java
@Controller
public class MyController {

    @GetMapping("/")
    public String index() {
        int x = 10 / 0;
        return "index";
    }

    @ExceptionHandler(ArithmeticException.class)
    public String handleArithmeticException(ArithmeticException ex) {
        return "Se ha producido una excepción aritmética";
    }
}
```

En este ejemplo, el método `index()` puede producir una excepción aritmética. El método `handleArithmeticException()` se utiliza para manejar la excepción aritmética.

El siguiente ejemplo muestra cómo utilizar la anotación @ExceptionHandler en una clase @ControllerAdvice:

```java
@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // Devuelve una respuesta HTTP con el código 500
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```

En este ejemplo, el método `handleException()` se utiliza para manejar todas las excepciones, incluidas las excepciones no controladas. El método `handleException()` devuelve una respuesta HTTP con el código 500.

La anotación @ExceptionHandler es una herramienta útil para centralizar el manejo de excepciones en aplicaciones web.

## HttpStatus

En el mundo de las APIs y servicios web, **HttpStatus** es un código numérico que representa el estado de una respuesta HTTP. Estos códigos proporcionan información sobre el resultado de la interacción entre el cliente y el servidor. Es similar a lo que vemos en las pantallas de error de sitios web con códigos como "404 Not Found".

Hay cinco categorías principales de códigos de estado HTTP:

**1. Códigos de respuesta informativos (100-199):**
Indican que se recibió la solicitud y el procesamiento continúa. No se espera que el cliente tome ninguna acción específica.

**2. Códigos de respuesta satisfactorios (200-299):**
Indican que la solicitud se completó con éxito. Los códigos más comunes son:

* **200 OK:** La solicitud se completó con éxito y el cuerpo de la respuesta contiene el resultado.
* **201 Created:** Se ha creado un nuevo recurso y su ubicación se proporciona en el encabezado Location.
* **204 No Content:** La solicitud se completó con éxito, pero no hay contenido que devolver en el cuerpo de la respuesta.

**3. Códigos de redirección (300-399):**
Indican que el cliente necesita tomar una acción adicional para completar la solicitud, generalmente redirigiéndose a otra ubicación. Los códigos más comunes son:

* **301 Moved Permanently:** El recurso solicitado se ha movido permanentemente a una nueva ubicación.
* **302 Found:** El recurso solicitado se encuentra temporalmente en otra ubicación.
* **304 Not Modified:** El recurso solicitado no ha sido modificado desde la última vez que se accedió a él, por lo que el cliente puede usar su copia local.

**4. Códigos de error del cliente (400-499):**
Indican que el cliente ha cometido un error en la solicitud. Los códigos más comunes son:

* **400 Bad Request:** La solicitud es sintácticamente incorrecta.
* **401 Unauthorized:** El cliente no está autorizado para acceder al recurso solicitado.
* **404 Not Found:** El recurso solicitado no se encuentra.

**5. Códigos de error del servidor (500-599):**
Indican que el servidor ha encontrado un error al procesar la solicitud. El código más común es:

* **500 Internal Server Error:** El servidor ha encontrado un error interno y no pudo completar la solicitud.

Entender y utilizar correctamente los códigos de estado HTTP es esencial para el desarrollo y la comunicación en el mundo de las APIs y servicios web. Proporcionan información valiosa para depurar problemas y mejorar la experiencia del usuario.

Si tienes alguna pregunta específica sobre un código de estado o necesitas más información sobre un tema en particular, ¡no dudes en preguntar!

## Anotacion ResponseStatus

La anotación **@ResponseStatus** es una anotación de Java que se utiliza para establecer el código de estado HTTP de una respuesta.

La anotación @ResponseStatus se puede utilizar en los siguientes contextos:

* **En métodos de controlador:** Los métodos de controlador pueden utilizar la anotación @ResponseStatus para establecer el código de estado HTTP de la respuesta que se devuelve.
* **En clases @ControllerAdvice:** Las clases @ControllerAdvice pueden utilizar la anotación @ResponseStatus para establecer el código de estado HTTP de la respuesta que se devuelve desde cualquier controlador.

La anotación @ResponseStatus tiene los siguientes atributos:

* **value:** El código de estado HTTP que se va a establecer.
* **reason:** La razón del código de estado HTTP.

El siguiente ejemplo muestra cómo utilizar la anotación @ResponseStatus en un método de controlador:

```java
@Controller
public class MyController {

    @GetMapping("/")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String index() {
        return "El recurso solicitado no se encuentra";
    }
}
```

En este ejemplo, el método `index()` devuelve una respuesta HTTP con el código de estado 404.

El siguiente ejemplo muestra cómo utilizar la anotación @ResponseStatus en una clase @ControllerAdvice:

```java
@RestControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        // Devuelve una respuesta HTTP con el código 500
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }
}
```

En este ejemplo, el método `handleException()` devuelve una respuesta HTTP con el código de estado 500.

La anotación @ResponseStatus es una herramienta útil para establecer el código de estado HTTP de una respuesta de forma clara y concisa.****

## Exception

La clase `Exception` es una clase de la biblioteca estándar de Java que representa errores que pueden ocurrir durante la ejecución de un programa.

La clase `Exception` es una subclase de la clase `Throwable`. Las clases `Throwable` representan cualquier error que puede ocurrir durante la ejecución de un programa.

Las excepciones se pueden clasificar en dos tipos principales:

* **Excepciones controladas:** Son excepciones que pueden ser manejadas por el programador.
* **Excepciones no controladas:** Son excepciones que no pueden ser manejadas por el programador y que provocan el cierre del programa.

Las excepciones controladas se pueden manejar utilizando la estructura try-catch-finally.

La estructura try-catch-finally tiene tres bloques:

* El bloque try contiene el código que puede generar excepciones.
* El bloque catch contiene el código que se ejecuta si se produce una excepción en el bloque try.
* El bloque finally contiene el código que se ejecuta siempre, independientemente de si se produce una excepción o no.

El siguiente ejemplo muestra cómo utilizar la estructura try-catch-finally para manejar una excepción:

```java
public class MyClass {

    public static void main(String[] args) {
        try {
            // Código que puede generar excepciones
            int x = 10 / 0;
        } catch (ArithmeticException e) {
            // Código que se ejecuta si se produce una excepción
            System.out.println("Se ha producido una excepción aritmética");
        } finally {
            // Código que se ejecuta siempre
            System.out.println("Se ha ejecutado el bloque finally");
        }
    }
}
```

En este ejemplo, el bloque try contiene el código que puede generar una excepción aritmética. Si se produce la excepción, el bloque catch se ejecuta y se imprime un mensaje de error. El bloque finally se ejecuta siempre, independientemente de si se produce una excepción o no.

Las excepciones no controladas no pueden ser manejadas por el programador. En estos casos, el programa se cerrará inmediatamente.

Sin embargo, es posible realizar un manejo parcial de las excepciones no controladas utilizando la sentencia throw.

La sentencia throw se utiliza para lanzar una excepción. El siguiente ejemplo muestra cómo utilizar la sentencia throw para lanzar una excepción no controlada:

```java
public class MyClass {

    public static void main(String[] args) {
        throw new RuntimeException("Excepción no controlada");
    }
}
```

En este ejemplo, se lanza una excepción no controlada de tipo RuntimeException. El programa se cerrará inmediatamente después de lanzar la excepción.

La clase `Exception` proporciona los siguientes métodos:

* `getMessage()`: Devuelve un mensaje que describe la excepción.
* `getCause()`: Devuelve la excepción que causó la excepción actual.
* `printStackTrace()`: Imprime un seguimiento de la pila de la excepción.

La clase `Exception` es una herramienta importante que debe ser utilizada por todos los programadores. El manejo de excepciones adecuado puede ayudar a crear aplicaciones más robustas y tolerantes a fallas.

## Excepciones personalizadas

Las excepciones personalizadas son clases que heredan de la clase `Exception`. Se utilizan para representar errores específicos que pueden ocurrir en una aplicación.

Las excepciones personalizadas se pueden utilizar en cualquier aplicación Java, pero son especialmente útiles en aplicaciones Spring Boot. Spring Boot proporciona una serie de anotaciones que facilitan el manejo de excepciones personalizadas.

Las siguientes anotaciones se utilizan para manejar excepciones personalizadas con Spring Boot:

* **@ExceptionHandler:** Se utiliza para marcar un método que se utiliza para manejar una excepción.
* **@ResponseStatus:** Se utiliza para establecer el código de estado HTTP de una respuesta.

El siguiente ejemplo muestra cómo utilizar las anotaciones @ExceptionHandler y @ResponseStatus para manejar una excepción personalizada:

```java
@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(MyException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorResponse> handleMyException(MyException ex) {
        // Devuelve una respuesta HTTP con el código 400
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(ex.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }
}
```

En este ejemplo, la clase `MyException` es una excepción personalizada que se utiliza para representar un error de solicitud incorrecto. El método `handleMyException()` se utiliza para manejar la excepción `MyException`. El método `handleMyException()` devuelve una respuesta HTTP con el código 400.

Las excepciones personalizadas se pueden utilizar para proporcionar información adicional sobre los errores que ocurren en una aplicación. Por ejemplo, una excepción personalizada puede incluir información sobre el usuario que causó el error, el recurso que se estaba intentando acceder o el motivo del error.

El manejo adecuado de las excepciones es una parte importante de cualquier aplicación. Las excepciones personalizadas pueden ayudar a crear aplicaciones más robustas y tolerantes a fallas.
