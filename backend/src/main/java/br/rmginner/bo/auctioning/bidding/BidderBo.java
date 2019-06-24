package br.rmginner.bo.auctioning.bidding;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.enums.AuctionStatus;
import br.rmginner.exception.BusinessValidationException;

import java.util.Objects;

public class BidderBo {

    public static void validateIfBidderNotExists(BidderDto bidderDto) throws BusinessValidationException {
        if (Objects.isNull(bidderDto)) {
            throw new BusinessValidationException("Não existe nenhum cliente com este CPF.");
        }
    }
}
