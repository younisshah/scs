package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("notification")
public class NotificationConsumer {

    private NotificationGateway notificationGateway;

    public NotificationConsumer(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    // event consumer
    @ServiceActivator(inputChannel = "event")
    public void consumeEvent(Request request) {
        log.info("[+] consumed request: {}", request);
        notificationGateway.produceEvent(request);
    }
}
