package br.rmginner.factory.auctioning.bidding.dto;

import br.rmginner.dto.auctioning.bidding.BidderDto;
import br.rmginner.factory.person.PhoneDtoFactory;
import br.rmginner.model.auctioning.bidding.Bidder;

import java.util.Objects;

public class BidderDtoFactory {

    public static BidderDto createFrom(Bidder bidder) {
        return Objects.nonNull(bidder) ? new BidderDto(bidder.getCpf(),
                bidder.getName(),
                PhoneDtoFactory.createFrom(bidder.getPhones()),
                bidder.getEmail()
        ) : null;
    }
}
