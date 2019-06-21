package br.rmginner.dao.auctioning;

import br.rmginner.model.auction.Auction;
import br.rmginner.dto.auctioning.AuctionDto;

import java.util.List;

public interface AuctionDao {

    boolean updateAction(Auction auction);

    List<Auction> findAuctionsByOwnerCpf(String ownerCpf);

    boolean saveAuction(Auction auction);

    List<Auction> findAllAuctions();

    boolean closeAuctionBy(Long auctionId, String auctioneerCpf);

}
