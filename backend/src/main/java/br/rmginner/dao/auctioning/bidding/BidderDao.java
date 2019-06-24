package br.rmginner.dao.auctioning.bidding;

import br.rmginner.model.auctioning.bidding.Bidder;

public interface BidderDao {

    Bidder findByCpf(String cpf);

}
