package com.example.demo.client.validator;

import com.example.demo.client.persistence.domain.Client;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Slf4j
@Component("beforeCreateClientValidator")
public class ClientValidator implements Validator {

    @Override
    public boolean supports(final Class<?> clazz) {
        return Client.class.equals(clazz);
    }

    @Override
    public void validate(final Object target, final Errors errors) {
        log.info("validationClient client={}", target);
        final Client client = (Client) target;

        if (client.getName() == null || client.getName().isBlank()) {
            errors.rejectValue("name", "validation.client.name", "Name must not be empty");
        }
    }

}
