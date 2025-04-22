# Notas

## JSON Web Token o JWT

Es un estandar abierto para implementar seguridad en las aplicaciones API REST basado en la especificacion RFC 7519.

**Caracteristicas**

* Escalables.
* Codificado y decodificado en Base64.
* Contienen reclamaciones o claims.
* Firmado mediante una llave secreta.
* Compacto.
* Autonomo.
* Seguro.

## Nota configuracion de seguridad

```java
@Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests( (auth) -> auth
                .requestMatchers("/users")
                .permitAll()
                .anyRequest()
                .authenticated())
                .csrf(config -> config.disable())
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .build();
    }
```

Veamos el código paso a paso:

**1. Anotación `@Bean`:**

Esta anotación marca el siguiente método como una definición de bean. Spring creará una instancia de este bean y gestionará su ciclo de vida dentro del contexto de la aplicación.

**2. Método `SecurityFilterChain filterChain(HttpSecurity http) throws Exception`:**

* Este método se llama `filterChain` y devuelve un objeto `SecurityFilterChain`.
* El parámetro `HttpSecurity` proporciona acceso para configurar varios aspectos de Spring Security, como autorización, inicio de sesión con formulario, protección CSRF, etc.
* La parte `throws Exception` indica que el método podría lanzar excepciones durante la configuración.

**3. Configuración de HttpSecurity:**

* `.authorizeHttpRequests((auth) -> ...)`: Aquí se configuran las reglas de autorización de URL. La expresión lambda define las reglas dentro del objeto `auth`:
    * `.requestMatchers("/usuarios")`: Coincide con las solicitudes a la ruta "/usuarios".
    * `.permitAll()`: Permite el acceso a "/usuarios" para cualquier usuario, independientemente de la autenticación.
    * `.anyRequest()`: Define una regla para cualquier otra ruta de solicitud no mencionada explícitamente anteriormente.
    * `.authenticated()`: Requiere que los usuarios estén autenticados para cualquier solicitud que no coincida con "/usuarios".
* `.csrf(config -> config.disable())`: Deshabilita la protección Cross-Site Request Forgery (CSRF). Por lo general, esto no se recomienda para entornos de producción y debe hacerse con precaución.
* `.sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))`: Configura la gestión de sesiones. Aquí, establece `sessionCreationPolicy` a `STATELESS`. Esto significa que Spring Security no creará sesiones HTTP para los usuarios.

**4. Construyendo el SecurityFilterChain:**

* `.build()`: Este método construye y devuelve el objeto `SecurityFilterChain` final con las reglas de seguridad configuradas.

**En resumen:**

Este fragmento de código configura Spring Security para tu aplicación. Permite que cualquier usuario acceda al punto final "/usuarios" pero requiere autenticación para cualquier otra solicitud. También deshabilita la protección CSRF y configura la aplicación para que sea sin estado (sin usar sesiones HTTP). Recuerda habilitar la protección CSRF y considerar mecanismos de autenticación alternativos para un entorno de producción seguro.

Configuracion para dejar publica la ruta /users con todos sus endpoints, todo lo demas requiere autenticacion, se deshabilito la seguridad del token csrf para evitar vulnerabilidades y se habilito el sessionManagement para que la sesion http no tenga estado (para dejar la autenticacion solo en el token).

## Acceder a la API protegida

> Nota el token tiene limite de tiempo, una vez expirado, se tiene que reiniciar la aplicacion

1. Acceder como usuario y obtener un token (por si acaso de tipo `ADMIN`):
[Login](./images/obtener-token.png)
2. Ingresar al endpoint protegido ya sea colocando el token en las cabeceras o en la opcion autorizacion:

> Opcion 1

[Con cabeceras](./images/opcion-1.png)

> Opcion 2

[Con autorizacion](./images/opcion-2.png)

