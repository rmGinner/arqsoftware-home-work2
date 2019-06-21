package br.rmginner.factory.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auction.Auction;

import java.util.List;

public class AuctionFactory {

    public static Auction createFrom(AuctionDto auctionDto) {
        return new Auction(
                null,
                AuctioneerFactory.createFrom(auctionDto.getAuctioneerDto()),
                null,
                null,
                AuctionItemFactory.createFrom(auctionDto.getAuctionItemDto())
        );
    }

}
