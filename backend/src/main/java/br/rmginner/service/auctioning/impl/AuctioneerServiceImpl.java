package br.rmginner.service.auctioning.impl;

import br.rmginner.bo.auctioning.AuctioneerBo;
import br.rmginner.dao.auctioning.AuctioneerDao;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.exception.BusinessValidationException;
import br.rmginner.factory.auctioning.dto.AuctioneerDtoFactory;
import br.rmginner.service.auctioning.AuctioneerService;
import br.rmginner.service.auctioning.AuctionService;
import br.rmginner.dto.auctioning.AuctionDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuctioneerServiceImpl implements AuctioneerService {

    @Autowired
    private AuctionService auctionService;

    @Autowired
    private AuctioneerDao auctioneerDao;

    public boolean closeAuction(Long auctionId, String auctioneerCpf) throws BusinessValidationException {
        AuctioneerBo.validateIfBidderNotExists(AuctioneerDtoFactory.createFrom(auctioneerDao.findAuctioneerById(auctioneerCpf)));
        return auctionService.closeAuction(auctionId, auctioneerCpf);
    }

    public List<AuctionDto> findOwnAuctions(String cpf) throws BusinessValidationException {
        AuctioneerBo.validateIfBidderNotExists(AuctioneerDtoFactory.createFrom(auctioneerDao.findAuctioneerById(cpf)));
        return auctionService.findAllByAuctioneerId(cpf);
    }

    public boolean createAuction(AuctionDto auctionDto) throws BusinessValidationException {
        AuctioneerBo.validateIfBidderNotExists(AuctioneerDtoFactory.createFrom(auctioneerDao.findAuctioneerById(auctionDto.getAuctioneer().getCpf())));
        return auctionService.saveAuction(auctionDto);
    }

    @Override
    public AuctioneerDto findAuctioneerByCpf(String auctioneerCpf) throws BusinessValidationException {
        AuctioneerBo.validateIfBidderNotExists(AuctioneerDtoFactory.createFrom(auctioneerDao.findAuctioneerById(auctioneerCpf)));
        return Optional.of(auctioneerDao.findAuctioneerById(auctioneerCpf))
                .map(AuctioneerDtoFactory::createFrom)
                .orElse(null);
    }

}
