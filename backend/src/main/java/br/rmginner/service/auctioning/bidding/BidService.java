package br.rmginner.service.auctioning.bidding;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.List;

public interface BidService {

    boolean subscribeBid(BidDto bidDto) throws BusinessValidationException;

    List<BidDto> getSubscribedBidsOfBidder(String bidderToken);

    List<BidDto> findAllByAuctionId(Long auctionId);

}
