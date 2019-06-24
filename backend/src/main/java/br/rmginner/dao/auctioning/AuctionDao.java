package br.rmginner.dao.auctioning;

import br.rmginner.model.auctioning.Auction;

import java.util.List;

public interface AuctionDao {

    boolean updateAction(Auction auction);

    List<Auction> findAuctionsByOwnerCpf(String ownerCpf);

    boolean saveAuction(Auction auction);

    List<Auction> findAllAuctions();

    boolean closeAuctionBy(Long auctionId, String auctioneerCpf);

    Auction findById(Long id);

}
