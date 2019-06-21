package br.rmginner.dao.auctioning;

import br.rmginner.model.auction.AuctionItem;

public interface AuctionItemDao {

    AuctionItem findById(Long auctionId);

}
