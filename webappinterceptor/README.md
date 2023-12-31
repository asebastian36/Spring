# Notas

## Interceptor

### Que hace un interceptor?

Los interceptores son utiles cuando se requiere aplicar una funcionalidad especifica para ciertas peticiones http y es transversal a nuestra aplicacion.

Es decir son fragmentos de codigo reutilizable que interceptan un metodo del controlador para agregar funcionalidad antes o despues.

### Como funcionan?

* Los interceptores deben implementar la interfaz `HandlerInterceptor`.
* Metodo boolean `preHandler()`: Cuando este metodo retorna **true**, continua con la ejecucion del controlador y si tiene mas interceptores asociados continua con la ejecucion en cadena, cuando retorna **false**, se asume que el interceptor se hace cargo del request (por ejemplo, redirige a una determinada vista o ruta) y no continua con la ejecucion del controlador ni de los demas interceptores, finaliza el request.
* Metodo void `preHandler()`: Implementa algo despues de que se haya invocado el metodo handler del controlador.
* Metodo void `afterCompletion()`: Implementa algo cuando finaliza el proceso, es decir, despues de cargar y renderizar la vista o json, cuando devuelve la respuesta al cliente. 
