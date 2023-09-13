package com.tenant.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.jboss.logging.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;

@Component
@Order(1)
public class TraceIdFilter implements Filter {


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        if (request instanceof HttpServletRequest) {
            String traceId = null;
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            traceId = httpRequest.getHeader("x-trace-id");
            if (traceId == null) {
                traceId = UUID.randomUUID().toString();
                MDC.put("x-trace-id", traceId);
            }
            MDC.put("x-trace-id", traceId);
            ((HttpServletResponse) response).setHeader("x-trace-id", traceId);
        }
        try {
            chain.doFilter(request, response);
        } finally {
            MDC.remove("x-trace-id");
        }
    }
}
