package io.younis.integration.router.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@MessagingGateway
@Profile("notification")
public interface NotificationGateway {

    @Gateway(requestChannel = "event")
    @Async
    void publishEvent(@Payload Request request);

    @Gateway(requestChannel = "producer")
    void produceEvent(@Payload Request request);
}
