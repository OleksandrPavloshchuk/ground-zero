package com.groundZero.settlementChamber;

import com.groundZero.settlementChamber.model.Payment;
import com.groundZero.settlementChamber.repository.PaymentRepository;
import java.math.BigDecimal;
import javax.transaction.Transactional;
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
    public CommandLineRunner demo(PaymentRepository paymentRepository) {
        return args -> saveTestData(paymentRepository);
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    private void saveTestData(PaymentRepository paymentRepository) {
        for (int i = 0; i < 5; i++) {
            final Payment p = new Payment("sourceId-" + (i % 3), "destinationId-" + (i % 4), new BigDecimal(i * i + 4));
            paymentRepository.save(p);
        }
        final Iterable<Payment> list = paymentRepository.findAll();
        list.forEach(o -> {
            LOG.info("-> " + o);
        });
    }

}
