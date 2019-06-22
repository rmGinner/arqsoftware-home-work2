package br.rmginner.factory.auctioning.model;

import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.model.auctioning.AuctionItem;

public class AuctionItemFactory {

    public static AuctionItem createFrom(AuctionItemDto auctionItemDto) {
        return new AuctionItem(
                null,
                auctionItemDto.getName(),
                auctionItemDto.getDescription()
        );
    }

}
