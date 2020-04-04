package io.younis.integration.router.notification;

import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("notification")
public class NotificationProducer {

    private RequestRepository requestRepository;

    public NotificationProducer(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Router(
            inputChannel = "producer",
            autoStartup = "true",
            applySequence = "true",
            ignoreSendFailures = "true"
    )
    public List<String> route(@Payload Request request) {
        return requestRepository.getChannelsByEventCode(request.getEventCode());
    }

}
