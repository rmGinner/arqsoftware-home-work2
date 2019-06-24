package br.rmginner.factory.auctioning.bidding.dto;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.factory.auctioning.dto.AuctionDtoFactory;
import br.rmginner.model.auctioning.bidding.Bid;

import java.util.Optional;

public class BidDtoFactory {

    public static BidDto createFrom(Bid bid) {
        return new BidDto(
                bid.getId(),
                AuctionDtoFactory.createFrom(bid.getAuction()),
                bid.getPrice(),
                Optional.of(bid.getBidder())
                        .map(bidder -> new BidderDto(bidder.getCpf()))
                        .orElse(null)
        );
    }
}
