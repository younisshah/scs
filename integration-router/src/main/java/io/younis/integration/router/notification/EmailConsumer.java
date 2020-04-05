package io.younis.integration.router.notification;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Future;

@Slf4j
@Component
@Profile("notification")
public class EmailConsumer {

    private NotificationGateway notificationGateway;

    public EmailConsumer(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @ServiceActivator(inputChannel = "email")
    public void consumeEmail(Request request) {
        try {
            log.info("[+] consumed email: {}", request);

            Future<EnrichedRequest> enrichedFuture = notificationGateway.enrich(request, Map.of("channel", "email"));
            EnrichedRequest enrichedRequest = enrichedFuture.get();
            log.info("[+] enriched email: {}", enrichedRequest);

            log.info("[+] sending email...");
            log.info("[+] email sent!");
        } catch (Exception e) {
            log.error("[x] failed to enrich email request with error: {}", e.getMessage());
        }
    }
}
