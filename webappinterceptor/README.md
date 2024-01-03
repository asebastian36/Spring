# Notas

## Interceptor

En programación, un interceptor es un componente que se puede insertar en un flujo de ejecución para interceptar y modificar los datos que fluyen a través de él. Los interceptores se utilizan comúnmente para realizar tareas de validación, auditoría o personalización.

Los interceptores pueden interceptar el flujo de ejecución en diferentes puntos, como antes de que se ejecute una operación, después de que se ejecute una operación o durante la ejecución de una operación.

Los interceptores se pueden implementar de diferentes maneras, pero la forma más común es mediante el uso de clases que implementan una interfaz de interceptor. La interfaz de interceptor define los métodos que deben implementarse para interceptar el flujo de ejecución.

En Java, los interceptores se utilizan comúnmente en el framework Spring. Spring proporciona una serie de interceptores predefinidos que se pueden utilizar para realizar tareas comunes, como la validación, la auditoría y la seguridad.

A continuación se muestran algunos ejemplos de cómo se pueden utilizar los interceptores:

* **Validación:** Los interceptores se pueden utilizar para validar los datos que fluyen a través de un flujo de ejecución. Por ejemplo, un interceptor podría utilizarse para validar que los datos de un formulario web sean válidos.
* **Auditoría:** Los interceptores se pueden utilizar para auditar las operaciones que se realizan en un sistema. Por ejemplo, un interceptor podría utilizarse para registrar las operaciones de acceso a datos.
* **Personalización:** Los interceptores se pueden utilizar para personalizar el comportamiento de un sistema. Por ejemplo, un interceptor podría utilizarse para agregar información adicional a los datos que se envían a un servicio web.

Los interceptores son una herramienta poderosa que se puede utilizar para mejorar la funcionalidad y la seguridad de un sistema.

### Que hace un interceptor?

Los interceptores son utiles cuando se requiere aplicar una funcionalidad especifica para ciertas peticiones http y es transversal a nuestra aplicacion.

Es decir son fragmentos de codigo reutilizable que interceptan un metodo del controlador para agregar funcionalidad antes o despues.

### Como funcionan?

* Los interceptores deben implementar la interfaz `HandlerInterceptor`.
* Metodo boolean `preHandler()`: Cuando este metodo retorna **true**, continua con la ejecucion del controlador y si tiene mas interceptores asociados continua con la ejecucion en cadena, cuando retorna **false**, se asume que el interceptor se hace cargo del request (por ejemplo, redirige a una determinada vista o ruta) y no continua con la ejecucion del controlador ni de los demas interceptores, finaliza el request.
* Metodo void `preHandler()`: Implementa algo despues de que se haya invocado el metodo handler del controlador.
* Metodo void `afterCompletion()`: Implementa algo cuando finaliza el proceso, es decir, despues de cargar y renderizar la vista o json, cuando devuelve la respuesta al cliente. 
