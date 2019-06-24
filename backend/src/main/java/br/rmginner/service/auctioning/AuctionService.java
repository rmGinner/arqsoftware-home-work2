package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.List;

public interface AuctionService {

    List<AuctionDto> getAllAuctions();

    List<AuctionDto> findAllByAuctioneerId(String cpf);

    boolean saveAuction(AuctionDto auctionDto);

    boolean closeAuction(Long auctionId, String auctioneerCpf) throws BusinessValidationException;

    AuctionDto findById(Long id);

    List<AuctionDto> getAllOpenedAuctions();
}
