package io.younis.integration.router.notification;

import java.util.Optional;

public interface EnrichmentStrategy {

    EnrichedRequest enrich(Request request);

    static Optional<EnrichmentStrategy> getStrategy(String channel) {
        switch (channel) {
            case "email":
                return Optional.of(new EmailEnricher());
            case "sms":
                return Optional.of(new SmsEnricher());
            default:
                return Optional.empty();
        }
    }
}
