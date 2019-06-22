package br.rmginner.factory.auctioning.dto;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.person.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auctioning.Auction;

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

    public static AuctionDto createFrom(Auction auction){
        return new AuctionDto(
                auction.getId(),
                new AuctioneerDto(
                        auction.getOwner().getCpf()
                ),
                auction.getStatus(),
                new AuctionItemDto(
                        auction.getItem().getId()
                )

        );
    }

}
