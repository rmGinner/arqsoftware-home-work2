package br.rmginner.factory.auctioning.bidding;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.auction.AuctionItem;
import br.rmginner.model.auction.Bid;
import br.rmginner.model.people.Auctioneer;

import java.util.List;
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
