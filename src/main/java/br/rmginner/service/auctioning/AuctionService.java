package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.model.auction.Auction;

import java.util.List;

public interface AuctionService {

    List<AuctionDto> getAllAuctions();

    List<AuctionDto> findAllByAuctioneerId(String cpf);

    boolean saveAuction(AuctionDto auctionDto);

    boolean closeAuction(Long auctionId, String auctioneerCpf);

}
