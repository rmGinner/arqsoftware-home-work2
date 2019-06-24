package br.rmginner.dao.auctioning.bidding;

import br.rmginner.model.auctioning.bidding.Bid;

import java.util.List;

public interface BidDao {

    boolean saveBidWithAuctionReference(Bid bid);

    List<Bid> getSubscribedBidsOfBidder(String bidderCpf);

    List<Bid> findByAuctionId(Long auctionId);

}
