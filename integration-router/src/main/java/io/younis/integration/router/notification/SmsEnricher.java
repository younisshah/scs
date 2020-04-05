package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class SmsEnricher implements EnrichmentStrategy {

    @Override
    public EnrichedRequest enrich(Request request) {

        log.info("[+] enriching sms");

        EnrichedRequest enrichedRequest = EnrichedRequest.builder()
                .eventCode(request.getEventCode())
                .userId(request.getUserId())
                .message("Some sms")
                .build();

        log.info("[+] sms enrichment done");

        return enrichedRequest;
    }
}
