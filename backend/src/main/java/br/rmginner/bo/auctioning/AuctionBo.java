package br.rmginner.bo.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.enums.AuctionStatus;
import br.rmginner.exception.BusinessValidationException;

public class AuctionBo {

    public static void validateIfAuctionAlreadyIsClosed(AuctionDto auctionDto) throws BusinessValidationException {
        if (auctionDto.getStatus().equals(AuctionStatus.CLOSED.getCode())){
            throw new BusinessValidationException("O leilão informado já está fechado.");
        }
    }
}
