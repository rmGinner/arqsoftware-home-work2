package br.rmginner.service.administration;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.model.auction.Auction;

import java.util.List;

public interface AdministratorService {

    public abstract List<AuctionDto> getAllAuctions();

}
