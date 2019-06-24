package br.rmginner.dto.auctioning;

import br.rmginner.dto.auctioning.bidding.BidDto;

import java.util.List;

public class AuctionDto {

    private Long id;

    private AuctioneerDto auctioneer;

    private String status;

    private List<BidDto> bids;

    private AuctionItemDto auctionItem;

    public AuctionDto(Long id) {
        this.id = id;
    }

    public AuctionDto(Long id, AuctioneerDto auctioneer, String status, AuctionItemDto auctionItem) {
        this.id = id;
        this.auctioneer = auctioneer;
        this.status = status;
        this.auctionItem = auctionItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AuctioneerDto getAuctioneer() {
        return auctioneer;
    }

    public void setAuctioneer(AuctioneerDto auctioneer) {
        this.auctioneer = auctioneer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<BidDto> getBids() {
        return bids;
    }

    public void setBids(List<BidDto> bids) {
        this.bids = bids;
    }

    public AuctionItemDto getAuctionItem() {
        return auctionItem;
    }

    public void setAuctionItem(AuctionItemDto auctionItem) {
        this.auctionItem = auctionItem;
    }
}
