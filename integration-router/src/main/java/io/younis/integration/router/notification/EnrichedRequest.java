package io.younis.integration.router.notification;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EnrichedRequest {
    private String eventCode;
    private String userId;
    private String message;
}
