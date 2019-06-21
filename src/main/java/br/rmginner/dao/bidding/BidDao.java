package br.rmginner.dao.bidding;

import br.rmginner.model.auction.Bid;

import java.util.List;

public interface BidDao {

    void saveBidWithAuctionReference(Bid bid);

    List<Bid> getSubscribedBidsOfBidder(String bidderCpf);

    List<Bid> findByAuctionId(Long auctionId);

}
