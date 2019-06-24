package br.rmginner.model.authentication;

public class AuthorizationRoles {

    private boolean isAdmin = false;

    private boolean isBidder = false;

    private boolean isAuctioneer = false;

    public AuthorizationRoles() {
    }

    public AuthorizationRoles(boolean isAdmin, boolean isBidder, boolean isAuctioneer) {
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
