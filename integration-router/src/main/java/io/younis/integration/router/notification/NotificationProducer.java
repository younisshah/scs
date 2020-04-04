package io.younis.integration.router.gateway;

import io.younis.integration.router.notification.Request;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("notification")
public class Producer {

    private RequestRepository requestRepository;

    public Producer(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Router(inputChannel = "event", autoStartup = "true", applySequence = "true")
    public List<String> route(@Payload Request request) {
        return requestRepository.getChannelsByEventCode(request.getEventCode());
    }

}
