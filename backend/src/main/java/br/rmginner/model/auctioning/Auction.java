package br.rmginner.model.auctioning;

import br.rmginner.model.auctioning.bidding.Bid;

import java.util.List;

public class Auction {

    private Long id;

    private Auctioneer owner;

    private String status;

    private List<Bid> bids;

    private AuctionItem item;

    public Auction() {
    }

    public Auction(Long id,
                   Auctioneer owner,
                   String status,
                   List<Bid> bids,
                   AuctionItem item) {

        this.id = id;
        this.owner = owner;
        this.status = status;
        this.bids = bids;
        this.item = item;
    }

    public Auction(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Auctioneer getOwner() {
        return owner;
    }

    public void setOwner(Auctioneer owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }

    public AuctionItem getItem() {
        return item;
    }

    public void setItem(AuctionItem item) {
        this.item = item;
    }
}
