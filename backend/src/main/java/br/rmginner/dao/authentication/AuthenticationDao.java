package br.rmginner.dao.authentication;

import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.model.auctioning.Auction;
import br.rmginner.model.authentication.Authentication;
import br.rmginner.model.authentication.AuthorizationRoles;

import java.util.List;

public interface AuthenticationDao {

    AuthorizationRoles authenticate(Authentication authentication);

}
