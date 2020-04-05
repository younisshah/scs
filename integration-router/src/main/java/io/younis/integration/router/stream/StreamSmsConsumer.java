package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.Future;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamSmsConsumer {

    private StreamNotificationGateway notificationGateway;

    public StreamSmsConsumer(StreamNotificationGateway notificationGateway) {
        this.notificationGateway = notificationGateway;
    }

    @StreamListener(value = ChannelNames.SMS_INPUT)
    public void consumeSms(Request request) {
        try {
            log.info("[+] consumed stream sms: {}", request);

            Future<EnrichedRequest> enrichedFuture = notificationGateway.enrich(request, Map.of("channel", "sms"));
            EnrichedRequest enrichedRequest = enrichedFuture.get();
            log.info("[+] enriched stream sms: {}", enrichedRequest);

            log.info("[+] sending stream sms...");
            log.info("[+] stream sms sent!");
        } catch (Exception e) {
            log.error("[x] failed to enrich stream sms request with error: {}", e.getMessage());
        }
    }
}
