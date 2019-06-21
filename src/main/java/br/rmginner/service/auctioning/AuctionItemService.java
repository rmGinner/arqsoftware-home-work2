package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionItemDto;

public interface AuctionItemService {

    AuctionItemDto findById(Long auctionId);
}
