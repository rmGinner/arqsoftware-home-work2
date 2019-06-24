package br.rmginner.dao.auctioning;

import br.rmginner.model.auctioning.Auctioneer;

public interface AuctioneerDao {

    Auctioneer findAuctioneerById(String cpf);

}
