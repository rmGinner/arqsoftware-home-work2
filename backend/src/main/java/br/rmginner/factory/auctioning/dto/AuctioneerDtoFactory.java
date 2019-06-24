package br.rmginner.factory.auctioning.dto;

import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.model.auctioning.Auctioneer;

import java.util.Objects;

public class AuctioneerDtoFactory {

    public static AuctioneerDto createFrom(Auctioneer auctioneer) {
        return Objects.nonNull(auctioneer) ? new AuctioneerDto(
                auctioneer.getCpf(),
                auctioneer.getName(),
                auctioneer.getEmail()
        ) : null;

    }
}
