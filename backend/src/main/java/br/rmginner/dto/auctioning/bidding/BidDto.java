package br.rmginner.dto.auctioning.bidding;

import br.rmginner.dto.auctioning.AuctionDto;

import java.math.BigDecimal;

public class BidDto {

    private Long bidId;

    private AuctionDto auction;

    private BigDecimal price;

    private BidderDto bidder;


    public BidDto(Long bidId, AuctionDto auction, BigDecimal price, BidderDto bidder) {
        this.bidId = bidId;
        this.auction = auction;
        this.price = price;
        this.bidder = bidder;
    }

    public Long getBidId() {
        return bidId;
    }

    public void setBidId(Long bidId) {
        this.bidId = bidId;
    }

    public AuctionDto getAuction() {
        return auction;
    }

    public void setAuction(AuctionDto auction) {
        this.auction = auction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BidderDto getBidder() {
        return bidder;
    }

    public void setBidder(BidderDto bidder) {
        this.bidder = bidder;
    }
}
