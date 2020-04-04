package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("notification")
public class NotificationService {

    private NotificationGateway notificationGateway;

    public NotificationService(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @Async
    public void publish(Request request) {
        log.info("[+] publishing request to gateway: {}", request);
        notificationGateway.publishEvent(request);
        log.info("[+] published to gateway");
    }

}
