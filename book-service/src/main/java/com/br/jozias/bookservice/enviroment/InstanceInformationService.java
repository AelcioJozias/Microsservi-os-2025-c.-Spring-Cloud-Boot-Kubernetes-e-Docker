package com.br.jozias.bookservice.enviroment;

import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

/**
 * Provides information about the instance of the application that is running.
 * This service is useful for a distributed system, where other services need to
 * know the port of this service.
 *
 * @author jozias
 */
@Service
public class InstanceInformationService implements ApplicationListener<WebServerInitializedEvent> {

    private String port;

    @Override
    public void onApplicationEvent(final WebServerInitializedEvent event) {
        this.port = String.valueOf(event.getWebServer().getPort());
    }

    /**
     * Retrieves the port of the server.
     *
     * @return the port of the server
     */
    public String retrieveServerPort() {
        return port;
    }
}
