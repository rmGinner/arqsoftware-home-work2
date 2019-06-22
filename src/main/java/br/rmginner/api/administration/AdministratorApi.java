package br.rmginner.api.administration;

import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.administration.AdministratorService;
import br.rmginner.dto.auctioning.AuctionDto;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/administration/{cpf}")
public class AdministratorApi {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping(path = "/auctions")
    public ResponseEntity<List<AuctionDto>> getAllAuctions(@PathVariable String cpf) throws BusinessValidationException {
        final var auctions = administratorService.getAllAuctions(cpf);
        final var httpStatusCode = CollectionUtils.isEmpty(auctions) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(auctions, httpStatusCode);
    }

}
