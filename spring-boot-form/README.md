# Validaciones en formularios con Spring boot validation

## ¿Qué es la validación de datos en Spring Boot?

La validación de datos es el proceso de verificar la entrada de datos del usuario para asegurarse de que cumple con ciertas reglas o restricciones. Estas reglas pueden incluir:

* **Tipo de dato:** Verificar si el dato ingresado es del tipo esperado (por ejemplo, un número entero, una cadena de caracteres, etc.).
* **Rango de valores:** Verificar si el dato ingresado está dentro de un rango específico de valores.
* **Longitud:** Verificar si el dato ingresado tiene una longitud específica.
* **Formato:** Verificar si el dato ingresado tiene un formato específico (por ejemplo, una dirección de correo electrónico válida).

La validación de datos es importante por las siguientes razones:

* **Mejora la seguridad:** La validación de datos puede ayudar a prevenir ataques de entrada de datos (como la inyección de SQL) al detectar y rechazar datos maliciosos.
* **Mejora la experiencia del usuario:** La validación de datos puede ayudar a mejorar la experiencia del usuario al proporcionar feedback inmediato sobre los errores de entrada.
* **Mejora la calidad del código:** La validación de datos puede ayudar a mejorar la calidad del código al eliminar errores de entrada de datos.

**¿Qué hace la dependencia spring-boot-starter-validation?**

La dependencia **spring-boot-starter-validation** proporciona las siguientes características:

* **Integración con Hibernate Validator:** Hibernate Validator es una biblioteca de validación de datos popular que se utiliza en Spring Boot.
* **Anotaciones de validación:** Spring Boot proporciona varias anotaciones de validación que se pueden utilizar para especificar las reglas de validación para los datos de entrada.
* **Mensajes de error de validación:** Spring Boot proporciona mensajes de error de validación por defecto para las reglas de validación más comunes.
* **Personalización de la validación:** La validación de datos se puede personalizar para satisfacer las necesidades específicas de la aplicación.

**¿Cómo usar spring-boot-starter-validation?**

Una vez que hayas añadido la dependencia, puedes empezar a usar anotaciones de validación para especificar las reglas de validación para los datos de entrada. Por ejemplo, el siguiente código muestra cómo usar la anotación @NotBlank para validar que una cadena de caracteres no esté vacía:

```java
@NotBlank
private String name;
```

Si un usuario intenta enviar una cadena de caracteres vacía para el nombre, Spring Boot devolverá un error de validación.

En resumen, la dependencia **spring-boot-starter-validation** es una herramienta útil para habilitar la validación de datos en tus aplicaciones Spring Boot. La validación de datos puede ayudar a mejorar la seguridad, la experiencia del usuario y la calidad del código.

### Anotaciones mas comunes

Las anotaciones de validación más comunes o utilizadas de la dependencia **spring-boot-starter-validation** son las siguientes:

* **@NotNull:** Indica que el valor no debe ser nulo.
* **@NotEmpty:** Indica que el valor no debe estar vacío.
* **@Min:** Indica que el valor debe ser mayor o igual que un número determinado.
* **@Max:** Indica que el valor debe ser menor o igual que un número determinado.
* **@Size:** Indica que el valor debe tener una longitud específica.
* **@Email:** Indica que el valor debe ser una dirección de correo electrónico válida.
* **@Pattern:** Indica que el valor debe cumplir con un formato específico.

Por ejemplo, el siguiente código muestra cómo usar algunas de estas anotaciones para validar los datos de entrada de un formulario:

```java
@Data
public class UserForm {

    @NotBlank
    private String name;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;
}
```

Si un usuario intenta enviar un formulario con datos inválidos, Spring Boot devolverá un error de validación. Por ejemplo, si un usuario intenta enviar un formulario con un nombre vacío, Spring Boot devolverá el siguiente error de validación:

```
{
    "errors": [
        {
            "field": "name",
            "rejectedValue": "",
            "message": "El nombre no debe estar vacío."
        }
    ]
}
```

Además de estas anotaciones, la dependencia **spring-boot-starter-validation** proporciona muchas otras anotaciones que se pueden utilizar para especificar reglas de validación más complejas.

### Anotacion Valid

La anotación `@Valid` se utiliza en Spring Boot para indicar que un objeto debe validar sus propiedades.

La anotación `@Valid` se utiliza en combinación con otras anotaciones de validación, como `@NotNull`, `@NotEmpty`, `@Min`, `@Max`, `@Size`, `@Email`, `@Pattern`, etc.

Por ejemplo, el siguiente código muestra cómo usar la anotación `@Valid` para validar un objeto `User`:

```java
@Data
public class User {

    @NotNull
    @Size(min = 1, max = 50)
    private String name;

    @NotNull
    @Min(18)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "^[0-9]{10}$")
    private String phone;
}
```

Para validar un objeto con la anotación `@Valid`, se puede utilizar el método `validate()` del objeto `Validator`. El método `validate()` devuelve una lista de errores de validación.

Por ejemplo, el siguiente código muestra cómo validar un objeto `User` con la anotación `@Valid`:

```java
Validator validator = Validation.buildDefaultValidatorFactory().getValidator();

User user = new User();
user.setName("");
user.setAge(17);

Set<ConstraintViolation<User>> errors = validator.validate(user);

if (!errors.isEmpty()) {
    for (ConstraintViolation<User> error : errors) {
        System.out.println(error.getMessage());
    }
}
```

Este código imprimirá los siguientes mensajes de error:

```
El nombre no debe estar vacío.
La edad debe ser mayor o igual que 18.
```

También se puede utilizar la anotación `@Valid` en un controlador HTTP para validar los datos de entrada de una solicitud HTTP. Por ejemplo, el siguiente código muestra cómo validar los datos de entrada de un formulario con la anotación `@Valid`:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@Valid User user) {
        // Procesar el usuario
    }
}
```

Si un usuario intenta enviar un formulario con datos inválidos, Spring Boot devolverá un error de validación. Por ejemplo, si un usuario intenta enviar un formulario con un nombre vacío, Spring Boot devolverá el siguiente error de validación:

```json
{
    "errors": [
        {
            "field": "name",
            "rejectedValue": "",
            "message": "El nombre no debe estar vacío."
        }
    ]
}
```

### Interfaz BindingResult

La interfaz `BindingResult` se utiliza en Spring Boot para representar los resultados de la validación de datos.

La interfaz `BindingResult` proporciona los siguientes métodos para acceder a los errores de validación:

* `hasErrors()`: Devuelve `true` si hay al menos un error de validación.
* `getAllErrors()`: Devuelve una lista de todos los errores de validación.
* `getFieldErrors()`: Devuelve una lista de errores de validación para un campo específico.
* `getGlobalErrors()`: Devuelve una lista de errores de validación globales.

Por ejemplo, el siguiente código muestra cómo utilizar la interfaz `BindingResult` para acceder a los errores de validación:

> Solo funciona si pasamos la interfaz despues del objeto a valida.

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@Valid User user, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            // Procesar los errores de validación
        } else {
            // Procesar el usuario
        }
    }
}
```

En este código, el objeto `bindingResult` se utiliza para acceder a los errores de validación de la solicitud HTTP. Si hay al menos un error de validación, el método `hasErrors()` devolverá `true`. En este caso, el controlador HTTP puede procesar los errores de validación. Si no hay errores de validación, el controlador HTTP puede procesar el usuario.

La interfaz `BindingResult` también se puede utilizar para generar mensajes de error personalizados. Por ejemplo, el siguiente código muestra cómo generar un mensaje de error personalizado para un campo específico:

```java
@PostMapping("/users")
public void createUser(@Valid User user, BindingResult bindingResult) {

    if (bindingResult.hasErrors()) {
        for (FieldError error : bindingResult.getFieldErrors()) {
            error.rejectValue("name", "custom.message", "El nombre debe ser obligatorio.");
        }
    } else {
        // Procesar el usuario
    }
}
```

En este código, el método `rejectValue()` se utiliza para generar un mensaje de error personalizado para el campo `name`. El mensaje de error personalizado es "El nombre debe ser obligatorio.".

En general, la interfaz `BindingResult` es una herramienta útil para acceder a los resultados de la validación de datos.

### Anotacion ModelAttribute

La anotación `@ModelAttribute` se utiliza en Spring Boot para asociar un objeto con un modelo de vista.

La anotación `@ModelAttribute` se utiliza en combinación con una clase o un método. Si se utiliza con una clase, la anotación `@ModelAttribute` asociará el objeto de la clase con el modelo de vista. Si se utiliza con un método, la anotación `@ModelAttribute` asociará el objeto devuelto por el método con el modelo de vista.

Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@ModelAttribute` para asociar un objeto `User` con el modelo de vista:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@ModelAttribute User user) {
        // Procesar el usuario
    }
}
```

En este código, la anotación `@ModelAttribute` asociará el objeto `user` con el modelo de vista. Esto significa que el objeto `user` estará disponible en la vista.

La anotación `@ModelAttribute` también se puede utilizar para generar datos ficticios para el modelo de vista. Por ejemplo, el siguiente código muestra cómo generar datos ficticios para el modelo de vista:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@ModelAttribute User user) {
        // Procesar el usuario
    }

    @ModelAttribute
    public User createUser() {
        return new User("Juan", 25);
    }
}
```

En este código, el método `createUser()` se utiliza para generar un objeto `User` ficticio. El objeto `User` se asociará con el modelo de vista mediante la anotación `@ModelAttribute`.

En general, la anotación `@ModelAttribute` es una herramienta útil para asociar objetos con modelos de vista.

#### Acceso a los mensajes de error de forma manual

```java
@PostMapping("/form")
    public String procesar(@Valid @ModelAttribute("user") Usuario usuario, BindingResult result, Model model) {
        model.addAttribute("titulo", "Datos procesados");


        //  forma manual de obtener los mensajes de error
        if(result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();

            result.getFieldErrors().forEach(error -> {
                errores.put(error.getField(), "El campo " + error.getField() + " " + error.getDefaultMessage());
            });

            model.addAttribute("errores", errores);
            return "form";
        }

        model.addAttribute("user", usuario);
        return "resultado";
    }
```

#### Accediendo a esos mensajes en la vista

```html
<div th:if="${errores != null && errores.containsKey('password')}">
    <span th:text="${errores.password}"></span>
</div>
```

### Anotacion SessionAttributes

La anotación `@SessionAttributes` se utiliza en Spring Boot para indicar que un conjunto de atributos deben almacenarse en la sesión HTTP entre solicitudes.

La anotación `@SessionAttributes` se utiliza en combinación con una clase o un método. Si se utiliza con una clase, la anotación `@SessionAttributes` almacenará en la sesión HTTP todos los atributos de la clase. Si se utiliza con un método, la anotación `@SessionAttributes` almacenará en la sesión HTTP todos los atributos devueltos por el método.

Por ejemplo, el siguiente código muestra cómo utilizar la anotación `@SessionAttributes` para almacenar un atributo `User` en la sesión HTTP:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@ModelAttribute User user) {
        // Procesar el usuario
    }

    @SessionAttributes("user")
    public User createUser() {
        return new User("Juan", 25);
    }
}
```

En este código, la anotación `@SessionAttributes` almacenará el atributo `user` en la sesión HTTP. Esto significa que el atributo `user` estará disponible en todas las solicitudes posteriores.

La anotación `@SessionAttributes` también se puede utilizar para especificar el tiempo de vida de los atributos en la sesión HTTP. Por ejemplo, el siguiente código muestra cómo establecer el tiempo de vida de los atributos en la sesión HTTP en 30 minutos:

```java
@SessionAttributes(value = {"user"}, maxAge = 30 * 60 * 1000)
public User createUser() {
        return new User("Juan", 25);
    }
```

En este código, los atributos `user` se almacenarán en la sesión HTTP durante 30 minutos.

En general, la anotación `@SessionAttributes` es una herramienta útil para almacenar atributos en la sesión HTTP.

### Interfaz SessionStatus

La interfaz `SessionStatus` se utiliza en Spring Boot para representar el estado de una sesión HTTP.

La interfaz `SessionStatus` proporciona los siguientes métodos para controlar el estado de la sesión HTTP:

* `isComplete()`: Devuelve `true` si la sesión HTTP está completa.
* `setComplete()`: Marca la sesión HTTP como completa.
* `removeAttribute()`: Elimina un atributo de la sesión HTTP.
* `removeAttributes()`: Elimina todos los atributos de la sesión HTTP.

Por ejemplo, el siguiente código muestra cómo utilizar la interfaz `SessionStatus` para marcar una sesión HTTP como completa:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@ModelAttribute User user, SessionStatus sessionStatus) {
        // Procesar el usuario

        sessionStatus.setComplete();
    }
}
```

En este código, el método `setComplete()` se utiliza para marcar la sesión HTTP como completa. Esto significa que la sesión HTTP se cerrará después de que se procese la solicitud HTTP.

La interfaz `SessionStatus` también se puede utilizar para eliminar atributos de la sesión HTTP. Por ejemplo, el siguiente código muestra cómo eliminar un atributo de la sesión HTTP:

```java
@RestController
public class UserController {

    @PostMapping("/users")
    public void createUser(@ModelAttribute User user, SessionStatus sessionStatus) {
        // Procesar el usuario

        sessionStatus.removeAttribute("user");
    }
}
```

En este código, el método `removeAttribute()` se utiliza para eliminar el atributo `user` de la sesión HTTP.

En general, la interfaz `SessionStatus` es una herramienta útil para controlar el estado de las sesiones HTTP.
