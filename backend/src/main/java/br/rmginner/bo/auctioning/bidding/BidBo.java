package br.rmginner.bo.auctioning.bidding;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.enums.AuctionStatus;
import br.rmginner.exception.BusinessValidationException;
import org.springframework.stereotype.Component;

public class BidBo {

    public static void validateIfAuctionIsClosed(AuctionDto auctionDto) throws BusinessValidationException {
        if (auctionDto.getStatus().equals(AuctionStatus.CLOSED.getCode())){
            throw new BusinessValidationException("O leilão informado está fechado e não pode ser realizado lances.");
        }
    }
}
