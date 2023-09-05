package com.tenant.config;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResponse {
    private int status;
    private Object data;
    private Object error;
}
