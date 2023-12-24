package com.angel.curso.springboot.webapp;

import org.springframework.context.annotation.*;

@Configuration
@PropertySources({
        //  Se agrego el value y el enconding por si se agregan caracteres especiales
        @PropertySource(value="classpath:values.properties", encoding = "UTF-8")
})
public class ValuesConfig {
}
