package io.younis.integration.router.stream;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
@Profile("stream-notification")
public class DirectChannels {

    // "produce" is a direct in-app channel.
    // It's not a Kafka topic but a Spring Integration MessageChannel instance
    @Bean
    SubscribableChannel produce() {
        return new DirectChannel();
    }

    @Bean
    SubscribableChannel enrich() {
        return new DirectChannel();
    }

    @Bean
    SubscribableChannel enriched() {
        return new DirectChannel();
    }
}
