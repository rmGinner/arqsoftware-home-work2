package br.rmginner.model.auctioning.bidding;

import br.rmginner.model.auctioning.Auction;

import java.math.BigDecimal;

public class Bid {

    private Long id;

    private Auction auction;

    private BigDecimal price;

    private Bidder bidder;

    public Bid(Long id, Auction auction, BigDecimal price, Bidder bidder) {
        this.id = id;
        this.auction = auction;
        this.price = price;
        this.bidder = bidder;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auction getAuction() {
        return auction;
    }

    public void setAuction(Auction auction) {
        this.auction = auction;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Bidder getBidder() {
        return bidder;
    }

    public void setBidder(Bidder bidder) {
        this.bidder = bidder;
    }
}
