package io.younis.integration.router.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;

@Component
@Profile("notification")
public class NotificationChannels {

    @Bean
    SubscribableChannel event() {
        return new DirectChannel();
    }

    @Bean
    SubscribableChannel producer() {
        return new DirectChannel();
    }

    @Bean
    SubscribableChannel email() {
        return new DirectChannel();
    }

    @Bean
    SubscribableChannel sms() {
        return new DirectChannel();
    }

}
