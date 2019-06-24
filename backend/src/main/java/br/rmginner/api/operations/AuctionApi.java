package br.rmginner.api.operations;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.auctioning.AuctionService;
import br.rmginner.service.auctioning.AuctioneerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/auctions")
public class AuctionApi {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/open")
    public ResponseEntity<List<AuctionDto>> geOwnAuctions()  {
        var openedAuctions = this.auctionService.getAllOpenedAuctions();
        final var httpStatusCode = CollectionUtils.isEmpty(openedAuctions) ? HttpStatus.NO_CONTENT : HttpStatus.OK;

        return new ResponseEntity<>(openedAuctions, httpStatusCode);
    }

}
