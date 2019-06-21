package br.rmginner.model.people;

import br.rmginner.model.auction.Bid;

import java.util.List;

public class Bidder extends Person {

    private List<Bid> bids;

    public Bidder(){

    }

    public Bidder(String bidderCpf) {
        super.setCpf(bidderCpf);
    }
}
