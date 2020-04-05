package io.younis.integration.router;

import io.younis.integration.router.stream.BindingChannels;
import io.younis.integration.router.stream.DirectChannels;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.annotation.IntegrationComponentScan;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableBinding({DirectChannels.class, BindingChannels.class})
@IntegrationComponentScan
@EnableAsync
public class IntegrationRouterApplication {

    public static void main(String[] args) {
        SpringApplication.run(IntegrationRouterApplication.class, args);
    }

}
