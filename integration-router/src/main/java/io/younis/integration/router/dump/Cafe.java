package io.younis.integration.router;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
@Profile("noop")
public interface Cafe {

    @Gateway(replyChannel = "replyChannel", requestChannel = "requestChannel")
    void placeOrder(String orderId);
}
