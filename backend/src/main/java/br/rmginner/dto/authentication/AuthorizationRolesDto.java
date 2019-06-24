package br.rmginner.dto.authentication;

public class AuthorizationRolesDto {

    private boolean isAdmin;

    private boolean isBidder;

    private boolean isAuctioneer;

    public AuthorizationRolesDto(boolean isAdmin, boolean isBidder, boolean isAuctioneer) {
        this.isAdmin = isAdmin;
        this.isBidder = isBidder;
        this.isAuctioneer = isAuctioneer;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public boolean isBidder() {
        return isBidder;
    }

    public void setBidder(boolean bidder) {
        isBidder = bidder;
    }

    public boolean isAuctioneer() {
        return isAuctioneer;
    }

    public void setAuctioneer(boolean auctioneer) {
        isAuctioneer = auctioneer;
    }
}


