package io.younis.integration.router.gateway;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {
    private String eventCode;
    private String userId;
}
