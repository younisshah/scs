package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@Profile("stream-notification")
public class StreamNotificationController {

    private StreamNotificationService notificationService;

    public StreamNotificationController(StreamNotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @PostMapping("/event/publish/stream")
    @ResponseStatus(code = HttpStatus.ACCEPTED)
    public void publish(@RequestBody Request request) {
        log.info("[+] publishing stream request: {}", request);
        notificationService.publish(request);
        log.info("[+] request stream accepted!");
    }

}
