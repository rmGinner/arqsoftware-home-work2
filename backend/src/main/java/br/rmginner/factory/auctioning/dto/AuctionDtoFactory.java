package br.rmginner.factory.auctioning.dto;

import br.rmginner.dto.auctioning.AuctionDto;
import br.rmginner.dto.auctioning.AuctionItemDto;
import br.rmginner.dto.auctioning.AuctioneerDto;
import br.rmginner.dto.person.PhoneDto;
import br.rmginner.dto.auctioning.bidding.BidDto;
import br.rmginner.model.auctioning.Auction;

import java.util.List;
import java.util.Objects;

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

        auctionDto.getAuctioneer().setPhones(phoneDtoList);
        auctionDto.setBids(bidDtoList);

        return auctionDto;

    }

    public static AuctionDto createFrom(Auction auction){
        return new AuctionDto(
                auction.getId(),
                new AuctioneerDto(
                        Objects.nonNull(auction.getOwner()) ? auction.getOwner().getCpf() : null
                ),
                auction.getStatus(),
                new AuctionItemDto(
                       Objects.nonNull(auction.getItem()) ?  auction.getItem().getId() : null,
                        Objects.nonNull(auction.getItem()) ?  auction.getItem().getName() : null,
                        Objects.nonNull(auction.getItem()) ?  auction.getItem().getDescription() : null
                )

        );
    }

}
