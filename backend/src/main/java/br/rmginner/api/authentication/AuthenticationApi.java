package br.rmginner.api.authentication;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.authentication.AuthenticationDto;
import br.rmginner.dto.authentication.AuthorizationRolesDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.administration.AdministratorService;
import br.rmginner.service.authentication.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping(path = "/authentication")
public class AuthenticationApi {

    @Autowired
    private AuthenticationService authenticationService;

    @PostMapping
    public ResponseEntity<AuthorizationRolesDto> authenticate(@RequestBody AuthenticationDto authenticationDto) throws BusinessValidationException {
        final var authResult = authenticationService.authenticate(authenticationDto);

        return new ResponseEntity<>(authResult, Objects.nonNull(authResult) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
