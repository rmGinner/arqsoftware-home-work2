package br.rmginner.dao.auctioning;

import br.rmginner.model.auctioning.AuctionItem;

public interface AuctionItemDao {

    AuctionItem findById(Long auctionId);

}
