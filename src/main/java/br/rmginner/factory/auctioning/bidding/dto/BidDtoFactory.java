package br.rmginner.factory.auctioning.bidding.dto;

import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.model.auctioning.bidding.Bid;

import java.util.Optional;

public class BidDtoFactory {

    public static BidDto createFrom(Bid bid) {
        return new BidDto(
                bid.getId(),
                null,
                bid.getPrice(),
                Optional.of(bid.getBidder())
                        .map(bidder -> new BidderDto(bidder.getCpf()))
                        .orElse(null)
        );
    }
}
