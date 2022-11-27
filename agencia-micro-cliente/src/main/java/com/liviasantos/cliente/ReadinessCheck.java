package com.liviasantos.cliente;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Override
    public HealthCheckResponse call() {
        var count = Cliente.count();

        if (count > 0) {
            return HealthCheckResponse.up("I'm ready");
        } else {
            return HealthCheckResponse.up("I'm not ready");
        }
    }
}
