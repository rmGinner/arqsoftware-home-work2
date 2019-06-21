package br.rmginner.factory.auctioning;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.auctioning.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auction.Auction;
import br.rmginner.model.auction.AuctionItem;
import br.rmginner.model.people.Auctioneer;

import java.util.List;

public class AuctioneerDtoFactory {

    public static AuctioneerDto createFrom(Auctioneer auctioneer) {
        return new AuctioneerDto(
                auctioneer.getCpf(),
                auctioneer.getName(),
                auctioneer.getEmail()
        );

    }
}
