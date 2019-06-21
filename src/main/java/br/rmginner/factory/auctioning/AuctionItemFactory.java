package br.rmginner.factory.auctioning;

import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.model.auction.AuctionItem;
import br.rmginner.model.people.Auctioneer;

public class AuctionItemFactory {

    public static AuctionItem createFrom(AuctionItemDto auctionItemDto) {
        return new AuctionItem(
                null,
                auctionItemDto.getName(),
                auctionItemDto.getDescription()
        );
    }

}
