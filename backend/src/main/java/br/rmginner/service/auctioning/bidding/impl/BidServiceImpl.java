package br.rmginner.service.auctioning.bidding.impl;

import br.rmginner.bo.auctioning.bidding.BidBo;
import br.rmginner.dao.auctioning.bidding.BidDao;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.factory.auctioning.bidding.model.BidFactory;
import br.rmginner.factory.auctioning.bidding.dto.BidDtoFactory;
import br.rmginner.service.auctioning.AuctionService;
import br.rmginner.service.auctioning.bidding.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    private BidDao bidDao;

    @Autowired
    private AuctionService auctionService;

    @Override
    public boolean subscribeBid(BidDto bidDto) throws BusinessValidationException {
        BidBo.validateIfAuctionIsClosed(auctionService.findById(bidDto.getAuction().getId()));

        return bidDao.saveBidWithAuctionReference(BidFactory.from(bidDto));
    }

    public List<BidDto> getSubscribedBidsOfBidder(String bidderCpf) {
        return bidDao.getSubscribedBidsOfBidder(bidderCpf)
                .stream()
                .map(BidDtoFactory::createFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<BidDto> findAllByAuctionId(Long auctionId) {
        return bidDao.findByAuctionId(auctionId)
                .stream()
                .map(BidDtoFactory::createFrom)
                .collect(Collectors.toList());
    }



}
