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
public class SmsConsumer {

    private NotificationGateway notificationGateway;

    public SmsConsumer(NotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @ServiceActivator(inputChannel = "sms")
    public void consumeSms(Request request) {
        try {
            log.info("[+] consumed sms: {}", request);

            log.info("[+] enriching sms..");
            Future<EnrichedRequest> enrichedFuture = notificationGateway.enrich(request, Map.of("channel", "sms"));
            EnrichedRequest enrichedRequest = enrichedFuture.get();
            log.info("[+] enriched sms: {}", enrichedRequest);

            log.info("[+] sending sms...");
            log.info("[+] sms sent!");
        } catch (Exception e) {
            log.error("[x] failed to enrich sms request with error: {}", e.getMessage());
        }
    }
}