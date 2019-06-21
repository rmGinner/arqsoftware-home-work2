package br.rmginner.dto.auctioning;

import br.rmginner.dto.auctioning.bidding.BidDto;

import java.util.List;

public class AuctionDto {

    private Long id;

    private AuctioneerDto auctioneerDto;

    private String status;

    private List<BidDto> bidDtoList;

    private AuctionItemDto auctionItemDto;

    public AuctionDto(Long id, AuctioneerDto auctioneerDto, String status, AuctionItemDto auctionItemDto) {
        this.id = id;
        this.auctioneerDto = auctioneerDto;
        this.status = status;
        this.auctionItemDto = auctionItemDto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuctioneerDto getAuctioneerDto() {
        return auctioneerDto;
    }

    public void setAuctioneerDto(AuctioneerDto auctioneerDto) {
        this.auctioneerDto = auctioneerDto;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BidDto> getBidDtoList() {
        return bidDtoList;
    }

    public void setBidDtoList(List<BidDto> bidDtoList) {
        this.bidDtoList = bidDtoList;
    }

    public AuctionItemDto getAuctionItemDto() {
        return auctionItemDto;
    }

    public void setAuctionItemDto(AuctionItemDto auctionItemDto) {
        this.auctionItemDto = auctionItemDto;
    }
}
