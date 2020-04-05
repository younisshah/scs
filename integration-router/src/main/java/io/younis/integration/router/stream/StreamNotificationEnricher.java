package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamNotificationEnricher {

    @ServiceActivator(inputChannel = ChannelNames.ENRICH, outputChannel = ChannelNames.ENRICHED)
    public EnrichedRequest enrich(@Payload Request request, @Headers Map<String, String> headers) {

        String channel = headers.get("channel");

        log.info("[+] stream enrichment request for channel: {}", channel);

        EnrichedRequest enrichedRequest = StreamEnrichmentStrategy
                .getStrategy(channel)
                .orElseThrow(() -> new IllegalArgumentException("illegal stream channel resolved: " + channel))
                .enrich(request);

        log.info("[+] stream enrichment done");

        return enrichedRequest;
    }
}
