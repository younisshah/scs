package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@Profile("notification")
public class NotificationEnricher {

    @ServiceActivator(inputChannel = "enrich", outputChannel = "enriched")
    public EnrichedRequest enrich(@Payload Request request, @Headers Map<String, String> headers) {

        String channel = headers.get("channel");
        log.info("[+] handling enrichment request for channel: {}", channel);

        return EnrichedRequest.builder()
                .eventCode(request.getEventCode())
                .userId(request.getUserId())
                .message("Some email")
                .build();
    }
}
