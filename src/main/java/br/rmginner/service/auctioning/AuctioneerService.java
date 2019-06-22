package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.List;

public interface AuctioneerService {

    boolean closeAuction(Long auctionId, String auctioneerId) throws BusinessValidationException;

    List<AuctionDto> findOwnAuctions(String auctioneerCpf) throws BusinessValidationException;

    boolean createAuction(AuctionDto auctionDto) throws BusinessValidationException;

    AuctioneerDto findAuctioneerByCpf(String auctioneerCpf) throws BusinessValidationException;

}
