package io.github.indigo;

import io.github.indigo.domain.entity.Cliente;
import io.github.indigo.domain.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;


@SpringBootApplication
public class VendasApplication {

    @Bean
    public CommandLineRunner init(@Autowired ClienteRepository clientes){
        return args -> {
            System.out.println("Salvando clientes");
            clientes.save(new Cliente("Douglas"));
            clientes.save(new Cliente("Outro cliente"));

            List<Cliente> result = clientes.encontrarPorNome("Douglas");
            result.forEach(System.out::println);


        };
    }

    // classe main
    public static void main(String[] args) {
        SpringApplication.run(VendasApplication.class, args);
    }
}
