package io.younis.integration.router;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;

@Slf4j
@Configuration
@Profile("noop")
public class Simple {

    @Bean
    public IntegrationFlow simpleFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("input"))
                .filter("World"::equals)
                .transform("Hello "::concat)
                .handle(m -> log.info("[+] received: {}", m))
                .get();
    }
}
