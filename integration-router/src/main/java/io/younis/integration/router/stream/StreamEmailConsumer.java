package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Future;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamEmailConsumer {

    private StreamNotificationGateway notificationGateway;

    public StreamEmailConsumer(StreamNotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @ServiceActivator(inputChannel = ChannelNames.EMAIL_INPUT)
    public void consumeEmail(Request request) {
        try {
            log.info("[+] consumed stream email: {}", request);

            Future<EnrichedRequest> enrichedFuture = notificationGateway.enrich(request, Map.of("channel", "email"));
            EnrichedRequest enrichedRequest = enrichedFuture.get();
            log.info("[+] enriched stream email: {}", enrichedRequest);

            log.info("[+] sending stream email...");
            log.info("[+] stream email sent!");
        } catch (Exception e) {
            log.error("[x] failed to enrich stream email request with error: {}", e.getMessage());
        }
    }
}
