package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class EmailEnricher implements EnrichmentStrategy {

    @Override
    public EnrichedRequest enrich(Request request) {

        log.info("[+] enriching email");

        EnrichedRequest enrichedRequest = EnrichedRequest.builder()
                .eventCode(request.getEventCode())
                .userId(request.getUserId())
                .message("Some email")
                .build();

        log.info("[+] email enrichment done");

        return enrichedRequest;
    }
}
