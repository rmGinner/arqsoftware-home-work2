package br.rmginner.dto.auctioning.bidding;

import br.rmginner.dto.auctioning.AuctionDto;

import java.math.BigDecimal;

public class BidDto {

    private Long bidId;

    private AuctionDto auctionDto;

    private BigDecimal price;

    private BidderDto bidderDto;


    public BidDto(Long bidId, AuctionDto auctionDto, BigDecimal price, BidderDto bidderDto) {
        this.bidId = bidId;
        this.auctionDto = auctionDto;
        this.price = price;
        this.bidderDto = bidderDto;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public AuctionDto getAuctionDto() {
        return auctionDto;
    }

    public void setAuctionDto(AuctionDto auctionDto) {
        this.auctionDto = auctionDto;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BidderDto getBidderDto() {
        return bidderDto;
    }

    public void setBidderDto(BidderDto bidderDto) {
        this.bidderDto = bidderDto;
    }
}
