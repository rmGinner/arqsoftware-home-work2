package br.rmginner.service.auctioning.bidding.impl;

import br.rmginner.bo.auctioning.bidding.BidderBo;
import br.rmginner.dao.auctioning.bidding.BidderDao;
import br.rmginner.dto.person.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.factory.auctioning.bidding.dto.BidderDtoFactory;
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

    @Override
    public boolean subscribeBid(BidDto bidDto) throws BusinessValidationException {
        BidderBo.validateIfBidderNotExists(BidderDtoFactory.createFrom(bidderDao.findByCpf(bidDto.getBidderDto().getCpf())));

        return bidService.subscribeBid(bidDto);
    }

    public List<BidDto> getSubscribedBids(String token) {
        return bidService.getSubscribedBidsOfBidder(token);
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
