package io.younis.integration.router.stream;

import java.util.Optional;

public interface StreamEnrichmentStrategy {

    EnrichedRequest enrich(Request request);

    static Optional<StreamEnrichmentStrategy> getStrategy(String channel) {
        switch (channel) {
            case "email":
                return Optional.of(new StreamEmailEnricher());
            case "sms":
                return Optional.of(new StreamSmsEnricher());
            default:
                return Optional.empty();
        }
    }
}
