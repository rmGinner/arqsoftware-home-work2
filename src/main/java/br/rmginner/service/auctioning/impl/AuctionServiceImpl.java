package br.rmginner.service.auctioning.impl;

import br.rmginner.dao.auctioning.AuctionDao;
import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.factory.auctioning.AuctionDtoFactory;
import br.rmginner.factory.auctioning.AuctionFactory;
import br.rmginner.model.auction.Auction;
import br.rmginner.service.auctioning.AuctionItemService;
import br.rmginner.service.auctioning.AuctionService;
import br.rmginner.service.auctioning.AuctioneerService;
import br.rmginner.service.auctioning.PhoneService;
import br.rmginner.service.auctioning.bidding.BidService;
import br.rmginner.service.auctioning.bidding.BidderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class AuctionServiceImpl implements AuctionService {

    @Autowired
    private AuctionDao auctionDao;

    @Autowired
    private AuctioneerService auctioneerService;

    @Autowired
    private AuctionItemService auctionItemService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private BidService bidService;

    @Autowired
    private BidderService bidderService;

    @Override
    public List<AuctionDto> getAllAuctions() {
        return auctionDao.findAllAuctions()
                .stream()
                .map(getInformationAboutAuction())
                .collect(Collectors.toList());

    }

    private Function<Auction, AuctionDto> getInformationAboutAuction() {
        return auction -> {
            final AuctioneerDto auctioneer = auctioneerService.findAuctioneerByCpf(auction.getOwner().getCpf());
            final AuctionItemDto auctionItem = auctionItemService.findById(auction.getItem().getId());
            final List<PhoneDto> phoneDtoList = phoneService.findPhonesByIds(
                    auctioneer.getPhoneDtoList()
                            .stream()
                            .map(PhoneDto::getId)
                            .collect(Collectors.toList())
            );
            final List<BidDto> bidDtoList = bidService.findAllByAuctionId(auction.getId());

            return AuctionDtoFactory.createFrom(
                    auction,
                    auctioneer,
                    auctionItem,
                    phoneDtoList,
                    bidDtoList
            );
        };
    }

    public List<AuctionDto> findAllByAuctioneerId(String cpf) {
        return auctionDao.findAuctionsByOwnerCpf(cpf)
                .stream()
                .map(getInformationAboutAuction())
                .collect(Collectors.toList());
    }

    public boolean saveAuction(AuctionDto auctionDto) {
        return auctionDao.saveAuction(AuctionFactory.createFrom(auctionDto));
    }

    public boolean closeAuction(Long auctionId, String auctioneerCpf) {
        return auctionDao.closeAuctionBy(auctionId, auctioneerCpf);
    }

}
