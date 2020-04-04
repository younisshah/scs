package io.younis.integration.router;

import io.younis.integration.router.notification.NotificationChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableBinding(NotificationChannels.class)
@EnableAsync
public class IntegrationRouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationRouterApplication.class, args);
    }

}
