package io.younis.integration.router.stream;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Future;

@Service
@MessagingGateway
@Profile("stream-notification")
public interface StreamNotificationGateway {

    @Gateway(requestChannel = ChannelNames.EVENT_OUTPUT)
    @Async
    void publishEvent(@Payload Request request);

    // "produce" is a direct in-app channel.
    // It's not a Kafka topic but a Spring Integration MessageChannel instance
    @Gateway(requestChannel = ChannelNames.PRODUCE)
    @Async
    void produce(@Payload Request request);

    @Gateway(requestChannel = ChannelNames.ENRICH, replyChannel = ChannelNames.ENRICHED)
    Future<EnrichedRequest> enrich(@Payload Request request, @Headers Map<String, String> headers);
}
