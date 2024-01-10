# Notas

## Programacion orientada a aspectos

La programación orientada a aspectos (POA) es un paradigma de programación que permite modularizar las preocupaciones transversales de un programa. Estas preocupaciones transversales son aquellas que se aplican a múltiples clases o métodos, como la logging, la seguridad, la internacionalización o la auditoría.

La POA se basa en la idea de que las preocupaciones transversales deben ser manejadas por aspectos separados de las clases o métodos que implementan la funcionalidad principal de la aplicación. Esto permite una mayor modularidad y flexibilidad en el desarrollo de aplicaciones.

Los aspectos se definen mediante el uso de anotaciones o archivos XML. Los aspectos pueden contener código que se ejecuta antes, durante o después de la ejecución de un método o clase.

La POA ofrece una serie de ventajas, entre las que se incluyen:

* **Mayor modularidad:** Las preocupaciones transversales se pueden modularizar en aspectos separados, lo que facilita el mantenimiento y la evolución de las aplicaciones.

* **Mayor flexibilidad:** Los aspectos pueden ser aplicados a múltiples clases o métodos, lo que facilita la reutilización del código.

* **Mejor legibilidad:** La separación de las preocupaciones transversales del código principal mejora la legibilidad del código.

La POA es un paradigma de programación relativamente nuevo, pero ha ganado popularidad en los últimos años. Se utiliza en una amplia gama de aplicaciones, incluidas las aplicaciones empresariales, las aplicaciones web y las aplicaciones móviles.

Algunos ejemplos de aspectos son:

* **Logging:** Los aspectos pueden utilizarse para registrar información sobre la ejecución de un método o clase, como la entrada y la salida de parámetros, el tiempo de ejecución y los errores.

* **Seguridad:** Los aspectos pueden utilizarse para validar los permisos de los usuarios antes de permitirles acceder a un recurso.

* **Internacionalización:** Los aspectos pueden utilizarse para traducir el texto de una aplicación a diferentes idiomas.

* **Auditoría:** Los aspectos pueden utilizarse para registrar información sobre el uso de una aplicación, como las transacciones realizadas por los usuarios.

La POA es una herramienta poderosa que puede ayudar a los desarrolladores a crear aplicaciones más modulares, flexibles y legibles.

## Aspecto

Un aspecto en POA es un módulo de código que se utiliza para modularizar las preocupaciones transversales de un programa. Las preocupaciones transversales son aquellas que se aplican a múltiples clases o métodos, como la logging, la seguridad, la internacionalización o la auditoría.

Los aspectos se definen mediante el uso de anotaciones o archivos XML. Los aspectos pueden contener código que se ejecuta antes, durante o después de la ejecución de un método o clase.

En concreto, un aspecto en POA puede realizar las siguientes acciones:

* **Agregar comportamiento**: Los aspectos pueden agregar comportamiento a las clases o métodos a los que se aplican. Por ejemplo, un aspecto de seguridad puede agregar código para validar los permisos de los usuarios antes de permitirles acceder a un recurso.

* **Modificar comportamiento**: Los aspectos pueden modificar el comportamiento de las clases o métodos a los que se aplican. Por ejemplo, un aspecto de logging puede agregar código para registrar información sobre la ejecución de un método.

* **Reemplazar comportamiento**: Los aspectos pueden reemplazar el comportamiento de las clases o métodos a los que se aplican. Por ejemplo, un aspecto de internacionalización puede reemplazar el texto de una aplicación por su equivalente en un idioma diferente.

La elección de qué acciones realizará un aspecto depende de la preocupación transversal que se esté abordando.

### Conceptos clave

* **Aspect (aspecto)**:Modularizacion de una preocupacion (tarea o proceso) que corta a traves de multiples objetos y metodos, un interceptor.

* **Join point (punto de cruce o union)**: Es un punto en la ejecucion del programa, ejemplo en una invocacion de metodo o manejo de una excepcion en Spring AOP, un join point representa una ejecucion de un metodo.

* **Advice (consejo o asesoramiento)**: Codigo que se ejecuta en un particular punto de union (join point), hay diferentes tipos, antes/before advice, se ejecuta antes del punto de union (join point), despues/after advice, se ejecuta despues del punto de union (join point), alrededor/around advice, se ejecuta alrededor del punto de union (join point).

* **Point cuts (puntos de corte)**: Un punto de corte (point cut) es una expresion que agrupa uno o mas puntos (join points). Un point cut puede estar compuesto en base a relaciones complejas definidas por expresiones regulares (patron), para restringir y afinar aun mas cuando se deba ejecutar un advice o consejo.

## Advice

En la programación orientada a aspectos (POA), un advice es un bloque de código que se ejecuta en un punto específico de la ejecución de un método o clase. Los advices se utilizan para modularizar las preocupaciones transversales de un programa, como la logging, la seguridad, la internacionalización o la auditoría.

Los advices se definen mediante el uso de anotaciones o archivos XML. Las anotaciones se utilizan para definir advices simples, mientras que los archivos XML se utilizan para definir advices más complejos.

Los advices pueden ejecutarse en uno de los siguientes puntos de la ejecución de un método o clase:

* **Antes de la ejecución**: El advice se ejecuta antes de que se ejecute el método o la clase.

* **Durante la ejecución**: El advice se ejecuta durante la ejecución del método o la clase.

* **Después de la ejecución**: El advice se ejecuta después de que se haya ejecutado el método o la clase.

Los advices también pueden ejecutarse en uno de los siguientes ámbitos:

* **Ambito de método**: El advice se aplica a un método específico.

* **Ambito de clase**: El advice se aplica a todas las instancias de una clase.

* **Ambito de paquete**: El advice se aplica a todas las clases de un paquete.

### Tipos de advice

* **Before advice**: Consejo que se ejecuta antes de una ejecucion de metodo.

* **After returning advice**: Consejo a ser ejecutado despues de que una ejecucion de metodo sea completado con normalidad, es decir haya retornado el valor/objeto.

* **After throwing advice**: Consejo a ser ejecutado si un metodo lanza una excepcion.

* **After (finally) advice**: Consejo a ser ejecutado independientemente de si un metodo retorna/finaliza normalmente o si lanza una excepcion.

* **Around advice**: Consejo que envuelven a una invocacion de metodo, este es el mas poderoso de los tipos de advice. Around advice puede realizar tareas personalizadas antes y despues de la invocacion del metodo.
