package br.rmginner.dao.bidding;

import br.rmginner.model.people.Bidder;

public interface BidderDao {

    Bidder findByCpf(String cpf);

}
