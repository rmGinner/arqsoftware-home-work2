package br.rmginner.service.auctioning.bidding.impl;

import br.rmginner.dao.bidding.BidderDao;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.service.auctioning.bidding.BidderService;
import br.rmginner.service.auctioning.bidding.BidService;
import br.rmginner.dto.auctioning.bidding.BidDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BidderServiceImpl implements BidderService {

    @Autowired
    private BidService bidService;

    @Autowired
    private BidderDao bidderDao;

    /**
     * @see br.rmginner.service.auctioning.bidding.BidderService#subscribeBid(br.rmginner.dto.auctioning.bidding.BidDto)
     */
    public boolean subscribeBid(BidDto bidDto) {
        return false;
    }


    /**
     * @see br.rmginner.service.auctioning.bidding.BidderService#getSubscribedBids(String)
     */
    public List<BidDto> getSubscribedBids(String token) {
        return null;
    }

    @Override
    public Optional<BidderDto> findByCpf(String cpf) {
        return Optional.of(bidderDao.findByCpf(cpf))
                .map(bidder -> {
                    return new BidderDto(
                            bidder.getCpf(),
                            bidder.getName(),
                            bidder.getPhones()
                                    .stream()
                                    .map(phone -> new PhoneDto(
                                            phone.getId(),
                                            phone.getDdd(),
                                            phone.getNumber()
                                    )).collect(Collectors.toList()),
                            bidder.getEmail()
                    );
                });
    }


}
