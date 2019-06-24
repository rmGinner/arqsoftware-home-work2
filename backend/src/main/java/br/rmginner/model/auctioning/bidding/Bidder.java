package br.rmginner.model.auctioning.bidding;

import br.rmginner.model.auctioning.bidding.Bid;
import br.rmginner.model.people.Person;

import java.util.List;

public class Bidder extends Person {

    private List<Bid> bids;

    public Bidder(){

    }

    public Bidder(String bidderCpf) {
        super.setCpf(bidderCpf);
    }
}
