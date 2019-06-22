package br.rmginner.factory.auctioning.model;

import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.model.auctioning.Auctioneer;

public class AuctioneerFactory {

    public static Auctioneer createFrom(AuctioneerDto auctioneerDto) {
        return new Auctioneer(
                auctioneerDto.getCpf()
        );
    }

}
