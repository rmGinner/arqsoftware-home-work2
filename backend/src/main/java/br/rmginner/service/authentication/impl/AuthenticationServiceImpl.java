package br.rmginner.service.authentication.impl;

import br.rmginner.dao.authentication.AuthenticationDao;
import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.dto.authentication.AuthorizationRolesDto;
import br.rmginner.factory.authentication.model.AuthenticationFactory;
import br.rmginner.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private AuthenticationDao authenticationDao;

    @Override
    public AuthorizationRolesDto authenticate(AuthenticationDto authenticationDto) {
        return Optional.ofNullable(authenticationDao.authenticate(AuthenticationFactory.createFrom(authenticationDto)))
                .map(authorizationRoles -> new AuthorizationRolesDto(
                        authorizationRoles.isAdmin(),
                        authorizationRoles.isBidder(),
                        authorizationRoles.isAuctioneer()
                )).orElse(null);
    }
}
