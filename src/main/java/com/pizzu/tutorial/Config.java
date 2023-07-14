package com.pizzu.tutorial;


import com.pizzu.tutorial.model.Persona;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(basePackageClasses = Persona.class)
public class Config {

    @Bean("persona1")
    public Persona getPersona1 () {
        return new Persona("Mario", "Rossi");
    }

    @Bean(name = "persona2")
    public Persona getPersona2 () {
        return new Persona("Luigi", "Verdi");
    }
}
