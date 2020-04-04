package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("notification")
public class EmailConsumer {

    @ServiceActivator(inputChannel = "email")
    public void consumeEmail(Request request) {
        log.info("[+] consumed email: {}", request);
        log.info("[+] sending email...");
        if(request.getEventCode().equals("SRV-0001")) {
            throw new IllegalArgumentException("failed to send email");
        }
        log.info("[+] email sent!");
    }
}
