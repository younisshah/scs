package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamNotificationConsumer {

    private StreamNotificationGateway notificationGateway;

    public StreamNotificationConsumer(StreamNotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    // event consumer
    @StreamListener(value = ChannelNames.EVENT_OUTPUT)
    public void consumeEvent(Request request) {
        log.info("[+] consumed stream request: {}", request);
        notificationGateway.produce(request);
    }
}
