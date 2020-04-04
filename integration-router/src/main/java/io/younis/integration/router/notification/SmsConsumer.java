package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("notification")
public class SmsConsumer {

    @ServiceActivator(inputChannel = "sms")
    public void consumeSms(Request request) {
        log.info("[+] consumed sms: {}", request);
        log.info("[+] sending sms...");
        log.info("[+] sms sent!");
    }
}