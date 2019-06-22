package br.rmginner.dto.auctioning;

import br.rmginner.dto.auctioning.bidding.BidDto;

import java.util.List;

public class AuctionItemDto {

    private Long id;

    private String name;

    private String description;

    public AuctionItemDto(Long id) {
        this.id = id;
    }

    public AuctionItemDto(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
