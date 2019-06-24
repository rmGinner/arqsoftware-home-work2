package br.rmginner.factory.auctioning.dto;

import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.model.auctioning.AuctionItem;

public class AuctionItemDtoFactory {

    public static AuctionItemDto createFrom(AuctionItem auctionItem) {
        return new AuctionItemDto(
                auctionItem.getId(),
                auctionItem.getName(),
                auctionItem.getDescription()
        );
    }
}
