package io.younis.integration.router;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.MessageEndpoint;

@Configuration
@Profile("noop")
public class SimpleAnnotation {



    @MessageEndpoint
    class SimpleFilter {

    }

}
