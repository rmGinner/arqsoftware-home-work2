package br.rmginner.factory;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.auction.Bid;
import br.rmginner.model.people.Bidder;

public final class BidFactory {

    public static Bid from(BidDto bidDto) {
        return new Bid(
                bidDto.getBidId(),
                new Auction(
                        bidDto.getAuctionDto().getId()
                ),
                bidDto.getPrice(),
                new Bidder(
                        bidDto.getBidderDto().getCpf()
                )
        );
    }
}
