package br.rmginner.dao.auctioning;

import br.rmginner.model.people.Auctioneer;

public interface AuctioneerDao {

    Auctioneer findAuctioneerById(String cpf);

}
