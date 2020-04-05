package io.younis.integration.router.stream;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ChannelNames {

    // kafka channel bindings
    public static final String EVENT_OUTPUT = "eventOutput";
    public static final String EMAIL_INPUT = "emailInput";
    public static final String SMS_INPUT = "smsInput";

    // direct channel names
    public static final String PRODUCE = "produce";
    public static final String ENRICH = "enrich";
    public static final String ENRICHED = "enriched";
}
