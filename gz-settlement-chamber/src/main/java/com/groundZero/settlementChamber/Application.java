package com.groundZero.settlementChamber;

import com.groundZero.settlementChamber.model.Owner;
import com.groundZero.settlementChamber.repository.OwnerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {
    private static final Logger LOG = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner demo(OwnerRepository ownerRepository) {
        return args -> {
            for( int i=0; i<3; i++) {
                ownerRepository.save( new Owner("user-" + i, "password-" + i));
            }
            final Iterable<Owner> list = ownerRepository.findAll();
            list.forEach( o -> {
                LOG.info( "-> " + o );
            });
        };
    }
    
}
