package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Profile("stream-notification")
public class StreamNotificationService {

    private StreamNotificationGateway notificationGateway;

    public StreamNotificationService(StreamNotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @Async
    public void publish(Request request) {
        log.info("[+] publishing request to stream gateway: {}", request);
        notificationGateway.publishEvent(request);
        log.info("[+] published to stream gateway");
    }

}
