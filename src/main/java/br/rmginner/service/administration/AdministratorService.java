package br.rmginner.service.administration;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.List;

public interface AdministratorService {

    List<AuctionDto> getAllAuctions(String adminCpf) throws BusinessValidationException;

}
