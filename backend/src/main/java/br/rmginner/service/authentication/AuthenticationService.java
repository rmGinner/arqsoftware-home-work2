package br.rmginner.service.authentication;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.dto.authentication.AuthorizationRolesDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.List;

public interface AuthenticationService {

    AuthorizationRolesDto authenticate(AuthenticationDto authenticationDto);

}
