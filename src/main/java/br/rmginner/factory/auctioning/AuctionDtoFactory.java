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

public class AuctionDtoFactory {

    public static AuctionDto createFrom(Auction auction,
                                        AuctioneerDto auctioneerDto,
                                        AuctionItemDto auctionItemDto,
                                        List<PhoneDto> phoneDtoList,
                                        List<BidDto> bidDtoList) {

        var auctionDto = new AuctionDto(
                auction.getId(),
                new AuctioneerDto(
                        auctioneerDto.getCpf(),
                        auctioneerDto.getName(),
                        auctioneerDto.getEmail()
                ),
                auction.getStatus(),
                new AuctionItemDto(
                        auctionItemDto.getId(),
                        auctionItemDto.getName(),
                        auctionItemDto.getDescription()
                )
        );

        auctionDto.getAuctioneerDto().setPhoneDtoList(phoneDtoList);
        auctionDto.setBidDtoList(bidDtoList);

        return auctionDto;

    }

}
