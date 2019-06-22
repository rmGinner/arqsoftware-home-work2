package br.rmginner.factory.auctioning.bidding.model;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auctioning.Auction;
import br.rmginner.model.auctioning.bidding.Bid;
import br.rmginner.model.auctioning.bidding.Bidder;

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
