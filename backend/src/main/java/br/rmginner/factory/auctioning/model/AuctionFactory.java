package br.rmginner.factory.auctioning.model;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.model.auctioning.Auction;

public class AuctionFactory {

    public static Auction createFrom(AuctionDto auctionDto) {
        return new Auction(
                null,
                AuctioneerFactory.createFrom(auctionDto.getAuctioneer()),
                null,
                null,
                AuctionItemFactory.createFrom(auctionDto.getAuctionItem())
        );
    }

}
