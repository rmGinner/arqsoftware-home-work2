package br.rmginner.model.auctioning;

import br.rmginner.model.auctioning.Auction;
import br.rmginner.model.people.Person;

import java.util.List;

public class Auctioneer extends Person {

	private List<Auction> auctions;

	public Auctioneer(String auctioneerCpf) {
		super.setCpf(auctioneerCpf);
	}
}
