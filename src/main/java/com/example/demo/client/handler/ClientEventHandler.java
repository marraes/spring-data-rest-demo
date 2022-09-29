package com.example.demo.client.handler;

import com.example.demo.client.persistence.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.HandleBeforeSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RepositoryEventHandler
public class ClientEventHandler {

    @HandleBeforeCreate
    public void handleClientBeforeCreate(final Client client) {
        log.info("beforeClientCreation client={}", client);
    }

    @HandleAfterCreate
    public void handleClientAfterCreate(final Client client) {
        log.info("afterClientCreation client={}", client);
    }

    @HandleBeforeSave
    public void handleClientBeforeSave(final Client client) {
        log.info("beforeClientSave client={}", client);
    }

    @HandleAfterSave
    public void handleClientAfterSave(final Client client) {
        log.info("afterClientSave client={}", client);
        throw new UnsupportedOperationException();
    }

}
