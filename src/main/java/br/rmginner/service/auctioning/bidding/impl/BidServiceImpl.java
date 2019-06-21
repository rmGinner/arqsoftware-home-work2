package br.rmginner.service.auctioning.bidding.impl;

import br.rmginner.dao.bidding.BidDao;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.factory.BidFactory;
import br.rmginner.factory.auctioning.bidding.BidDtoFactory;
import br.rmginner.model.auction.Bid;
import br.rmginner.service.auctioning.bidding.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidDao bidDao;

    /**
     * @see br.rmginner.service.auctioning.bidding.BidService#subscribeBid(br.rmginner.dto.auctioning.bidding.BidDto)
     */
    public void subscribeBid(BidDto bidDto) {
        bidDao.saveBidWithAuctionReference(BidFactory.from(bidDto));
    }


    /**
     * @see br.rmginner.service.auctioning.bidding.BidService#getSubscribedBidsOfBidder(String)
     */
    public List<BidDto> getSubscribedBidsOfBidder(String bidderCpf) {
        return null;
    }

    @Override
    public List<BidDto> findAllByAuctionId(Long auctionId) {
        return bidDao.findByAuctionId(auctionId)
                .stream()
                .map(BidDtoFactory::createFrom)
                .collect(Collectors.toList());
    }

}
