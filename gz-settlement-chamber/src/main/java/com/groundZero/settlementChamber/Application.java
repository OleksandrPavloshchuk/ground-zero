package com.groundZero.settlementChamber;

import com.groundZero.settlementChamber.model._Probe;
import com.groundZero.settlementChamber.repository._ProbeRepository;
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
    public CommandLineRunner demo(_ProbeRepository _probeRepo) {
        return args -> {
            for( int i=0; i<3; i++) {
                _probeRepo.save( new _Probe("user-" + i));
            }
            final Iterable<_Probe> list = _probeRepo.findAll();
            list.forEach( o -> {
                LOG.info( "-> " + o );
            });
        };
    }
    
}
