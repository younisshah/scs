package io.younis.integration.router.stream;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Component
@Profile("stream-notification")
public class RequestRepository {

    public List<String> getChannelsByEventCode(String eventCode) {
        log.info("[+] getting stream channels for eventCode: {}", eventCode);
        return Arrays.asList("email", "sms");
    }

}
