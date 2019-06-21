package br.rmginner.service.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.model.people.Auctioneer;

import java.util.List;

public interface AuctioneerService {

    boolean closeAuction(Long auctionId, String auctioneerId);

    List<AuctionDto> findOwnAuctions(String auctioneerCpf);

    boolean createAuction(AuctionDto auctionDto);

    AuctioneerDto findAuctioneerByCpf(String auctioneerCpf);

}
