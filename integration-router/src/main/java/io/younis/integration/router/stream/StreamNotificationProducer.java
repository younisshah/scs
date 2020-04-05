package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.integration.annotation.Router;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Component
@Profile("stream-notification")
public class StreamNotificationProducer {

    private RequestRepository requestRepository;

    public StreamNotificationProducer(RequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    @Router(
            inputChannel = ChannelNames.PRODUCE,
            autoStartup = "true",
            applySequence = "true",
            ignoreSendFailures = "true"
    )
    public List<String> route(@Payload Request request) {
        List<String> channels = requestRepository.getChannelsByEventCode(request.getEventCode())
                .stream()
                .filter(Objects::nonNull)
                .map(c -> c + "Input")
                .collect(Collectors.toList());
        log.info("[+] stream channels: {}", channels);
        return channels;
    }

}
