package br.rmginner.bo.auctioning;

import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.exception.BusinessValidationException;

import java.util.Objects;

public class AuctioneerBo {

    public static void validateIfBidderNotExists(AuctioneerDto auctioneerDto) throws BusinessValidationException {
        if (Objects.isNull(auctioneerDto)) {
            throw new BusinessValidationException("Não existe nenhum proponente com este CPF.");
        }
    }
}
