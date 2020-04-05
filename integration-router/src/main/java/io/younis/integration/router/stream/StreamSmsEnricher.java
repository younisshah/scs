package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamSmsEnricher implements StreamEnrichmentStrategy {

    @Override
    public EnrichedRequest enrich(Request request) {

        log.info("[+] enriching stream sms");

        EnrichedRequest enrichedRequest = EnrichedRequest.builder()
                .eventCode(request.getEventCode())
                .userId(request.getUserId())
                .message("Some stream sms")
                .build();

        log.info("[+] stream sms enrichment done");

        return enrichedRequest;
    }
}
