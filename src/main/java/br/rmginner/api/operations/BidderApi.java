package br.rmginner.api.operations;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.service.auctioning.bidding.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/bidders")
public class BidderApi {

    @Autowired
    private BidderService bidderService;

    @PostMapping(path = "{cpf}/auctions/{auctionId}/bids")
    public ResponseEntity<?> subscribeBid(@PathVariable String cpf,
                                          @PathVariable Long auctionId,
                                          @RequestBody BidDto bidDto) throws BusinessValidationException {


        bidDto.setAuctionDto(new AuctionDto(auctionId));
        bidDto.setBidderDto(new BidderDto(cpf));

        var bidHasBeenSubscribed = bidderService.subscribeBid(bidDto);
        var httpStatus = bidHasBeenSubscribed ? HttpStatus.OK : HttpStatus.BAD_REQUEST;

        return new ResponseEntity<>(null, httpStatus);
    }

    @GetMapping(path = "{cpf}/auctions")
    public ResponseEntity<List<BidDto>> getSubscribedBids(@PathVariable String cpf) {
        var subscribedBids = bidderService.getSubscribedBids(cpf);

        return new ResponseEntity<>(
                subscribedBids,
                CollectionUtils.isEmpty(subscribedBids) ? HttpStatus.NO_CONTENT : HttpStatus.OK
        );
    }

}
