package io.younis.integration.router.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

@Profile("stream-notification")
public interface BindingChannels {

    @Output(ChannelNames.EVENT_OUTPUT)
    SubscribableChannel eventOutput();

    @Input(ChannelNames.EMAIL_INPUT)
    MessageChannel emailInput();

    @Output(ChannelNames.SMS_INPUT)
    MessageChannel smsInput();
}
