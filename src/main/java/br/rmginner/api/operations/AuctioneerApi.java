package br.rmginner.api.operations;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.auctioning.AuctioneerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auctioneers")
public class AuctioneerApi {

    @Autowired
    private AuctioneerService auctioneerService;

    @DeleteMapping(path = "{cpf}/auctions/{auctionId}")
    public ResponseEntity<?> closeAuction(@PathVariable String cpf, @PathVariable Long auctionId) throws BusinessValidationException {
        return new ResponseEntity<>(
                null,
                auctioneerService.closeAuction(auctionId, cpf) ? HttpStatus.OK : HttpStatus.BAD_REQUEST
        );
    }

    @GetMapping(path = "{cpf}/auctions")
    public ResponseEntity<List<AuctionDto>> geOwnAuctions(@PathVariable String cpf) throws BusinessValidationException {
        final var ownAuctions = auctioneerService.findOwnAuctions(cpf);
        final var httpStatusCode = CollectionUtils.isEmpty(ownAuctions) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(ownAuctions, httpStatusCode);
    }

    @PostMapping(path = "{cpf}/auctions")
    public ResponseEntity<?> createAuction(@PathVariable String cpf, @RequestBody AuctionDto auctionDto) throws BusinessValidationException {
        auctionDto.getAuctioneerDto().setCpf(cpf);
        return new ResponseEntity<>(null, auctioneerService.createAuction(auctionDto) ?
                HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }

}
