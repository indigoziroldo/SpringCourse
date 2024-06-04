package io.github.indigo;

import io.github.indigo.domain.entity.Cliente;
import io.github.indigo.domain.repository.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.CommandLinePropertySource;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired Clientes clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Douglas"));
            clientes.save(new Cliente("Outro cliente"));

            boolean existe = clientes.existsByNome("Douglas");
            System.out.println("existe um cliente com o nome Douglas?" + existe);


        };
    }

    // classe main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
