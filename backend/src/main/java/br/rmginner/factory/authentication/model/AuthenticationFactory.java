package br.rmginner.factory.authentication.model;

import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.dto.person.PhoneDto;
import br.rmginner.model.authentication.Authentication;
import br.rmginner.model.people.Phone;

import java.util.Objects;

public class AuthenticationFactory {

    public static Authentication createFrom(AuthenticationDto authenticationDto) {
        return Objects.nonNull(authenticationDto) ?
                new Authentication(
                        authenticationDto.getCpf(),
                        authenticationDto.getPassword()
                ) : null;
    }

    public static PhoneDto createFrom(Phone phone) {
        return Objects.nonNull(phone) ? new PhoneDto(phone.getId(), phone.getDdd(), phone.getNumber()) : null;
    }
}
