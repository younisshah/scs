package io.younis.scs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

@Slf4j
@EnableBinding(Transformer.Source.class)
public class Transformer {

    //public MessageSource<>

    public interface Source {
        String EVENT_SOURCE = "event-source";

        @Output(EVENT_SOURCE)
        MessageChannel channel();
    }

}
