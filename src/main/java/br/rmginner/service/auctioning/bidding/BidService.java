package br.rmginner.service.auctioning.bidding;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auction.Bid;

import java.util.List;

public interface BidService {

    void subscribeBid(BidDto bidDto);

    List<BidDto> getSubscribedBidsOfBidder(String bidderToken);

    List<BidDto> findAllByAuctionId(Long auctionId);

}
