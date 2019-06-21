package br.rmginner.model.people;

import br.rmginner.model.auction.Auction;

import java.util.List;

public class Auctioneer extends Person {

	private List<Auction> auctions;

	public Auctioneer(String auctioneerCpf) {
		super.setCpf(auctioneerCpf);
	}
}
