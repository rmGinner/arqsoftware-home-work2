package br.rmginner.factory.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.people.Auctioneer;

public class AuctioneerFactory {

    public static Auctioneer createFrom(AuctioneerDto auctioneerDto) {
        return new Auctioneer(
                auctioneerDto.getCpf()
        );
    }

}
